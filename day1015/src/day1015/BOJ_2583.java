package day1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2583 {
	static int M;
	static int N; 
	static int K;
	static int map[][];
	static int visited[][];
	static Queue<Node> q;
	
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	static int area;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new int[M][N];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			
			//화면 상 모눈종이 왼쪽 위
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
		
			//화면 상 모눈종이 오른쪽 아래
			int destX = Integer.parseInt(st.nextToken())-1;
			int destY = Integer.parseInt(st.nextToken())-1;
			
			//모눈종이 칠하기
			for(int y=startY; y<=destY; y++) {
				for(int x=startX; x<=destX; x++) {
					map[y][x]=1;
				}
			}
				
		}
		
		/*for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}*/
		
		q = new LinkedList<>();
		int cnt=0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]==0 && map[i][j]==0) {
					area=0;
					bfs(i, j);
					//System.out.println(area);
					list.add(area);
					cnt++;
				}
			}
		}
		
		Collections.sort(list);
		System.out.print(cnt+" ");
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		
	}
	
	public static void bfs(int y, int x) {
		q.add(new Node(y, x));
		visited[y][x]=1;
		area = 1;
		
		while(!q.isEmpty()) {
			int cury = q.peek().y;
			int curx = q.peek().x;
			q.remove();
			
			for(int i=0; i<4; i++) {
				int ny = cury + dy[i];
				int nx = curx + dx[i];
				
				if(ny<0 || nx<0 || ny>=M || nx>=N) continue;
				if(visited[ny][nx]==1) continue;
				if(map[ny][nx]==1) continue;
				
				q.add(new Node(ny, nx));
				visited[ny][nx]= 1;
				area+=1;
			}
			
			
		}
		
		
	}
	

}

class Node {
	int y, x;
	public Node(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
