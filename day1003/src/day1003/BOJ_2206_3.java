package day1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_3 {
	static int N;
	static int M;
	static int map[][];
	static int visited[][][];
	static Queue<Node> q;
	
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new int[N][M][2];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		/*for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}*/

		q = new LinkedList<>();

		
		bfs(0, 0);
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(visited[i][j][0]+" ");
			}
			System.out.println();
		}
		System.err.println();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(visited[i][j][1]+" ");
			}
			System.out.println();
		}
		System.out.println(visited[N-1][M-1][0]);
		System.out.println(visited[N-1][M-1][1]);	
		
		int a = visited[N-1][M-1][0];
		int b = visited[N-1][M-1][1];
		
		if(a==0 && b ==0) {
			System.out.println(-1);
		}else if(a==0) {
			System.out.println(b);
		}else if(b==0) {
			System.out.println(a);
		}else {
			System.out.println(Math.min(a, b));
		}
		
		
		
	}
	
	//가는 도중 뿌셔야하므로 시작점에서 가까운 "단 한번"만 뿌실수 있음
	public static void bfs(int y, int x) {
		q.add(new Node(y, x, 0));

		visited[y][x][0]=1;
		//visited[y][x][1]=1;
		
		while(!q.isEmpty()) {
			int cury = q.peek().y;
			int curx = q.peek().x;
			int flag = q.peek().flag;
			q.remove();
			
			for(int i=0; i<4; i++) {
				int ny = cury+dy[i];
				int nx = curx+dx[i];
				
				if(ny<0 || nx<0 || ny>=N || nx>=M) continue;

				if(visited[ny][nx][flag]>0) continue;
				
				//다음 정점이 벽이 아니면
				if(map[ny][nx]==0) {
					//현재 flag대로 이어감. 전에 부셨었으면 부신대로..
					q.add(new Node(ny, nx, flag));
					visited[ny][nx][flag] = visited[cury][curx][flag]+1;					
				}
				
				//다음 정점이 벽이면
				if(map[ny][nx]==1) {
					
					//이미 부셨었음
					if(flag==1) {
						continue;
						
					//아직 안뿌심.	
					}else {
						
						//뿌시고
						q.add(new Node(ny, nx, 1));
						visited[ny][nx][1] = visited[cury][curx][0]+1;					
				
					}
				}
				
			}
		}
	}
	
	
}

class Node {
	int y; 
	int x;
	int flag;
	public Node(int y, int x, int flag) {
		this.y = y;
		this.x = x;
		this.flag = flag;
	}
	
}
