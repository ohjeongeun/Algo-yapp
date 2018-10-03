package day1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_2 {
	static int N;
	static int M;
	static int map[][];
	static int visited[][];
	static Queue<Node> q;
	
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	static ArrayList<Node> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new int[N][M];
		
		list = new ArrayList<>();
		list.add(new Node(0, 0));
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j)-'0';
				if(map[i][j]==1) {
					list.add(new Node(i, j));
				}
			}
		}
		
		/*for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}*/

		q = new LinkedList<>();

		int min =Integer.MAX_VALUE;
		for(int i=0; i<list.size(); i++) {
			visited = new int[N][M];
			int y = list.get(i).y;
			int x = list.get(i).x;
			
			map[y][x]=0;
			bfs(0,0);
			/*for(int k=0; k<N; k++) {
				for(int j=0; j<M; j++) {
					System.out.print(visited[k][j]);
				}
				System.out.println();
			}
			System.out.println();*/
			if(visited[N-1][M-1]!=0 && visited[N-1][M-1]<min) {
				min = visited[N-1][M-1];
			}
			
			map[y][x]=1;
					
		}
		
		//bfs(0,0);
		//System.out.println(visited[N-1][M-1]);
		
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
			
		}else {
			System.out.println(min);
		}
		
	}
	
	public static void bfs(int y, int x) {
		q.add(new Node(y, x));

		visited[y][x]=1;
		
		while(!q.isEmpty()) {
			int cury = q.peek().y;
			int curx = q.peek().x;
			q.remove();
			
			for(int i=0; i<4; i++) {
				int ny = cury+dy[i];
				int nx = curx+dx[i];
				
				if(ny<0 || nx<0 || ny>=N || nx>=M) continue;
				
				if(map[ny][nx]==1) continue;
				
				if(visited[ny][nx]>=1) continue;
				
				q.add(new Node(ny, nx));
				visited[ny][nx] = visited[cury][curx]+1;
				
			}
		}
	}
	
	
}

class Node {
	int y; 
	int x;
	public Node(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
}
