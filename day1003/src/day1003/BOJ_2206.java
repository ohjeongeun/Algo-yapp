package day1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
	static int N;
	static int M;
	static int map[][];
	static int visited[][];
	static Queue<Integer> xq;
	static Queue<Integer> yq;
	
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new int[N][M];
		
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

		xq = new LinkedList<>();
		yq = new LinkedList<>();
		list = new ArrayList<>();
		bfs(0,0);
		if(visited[N-1][M-1]!=0) {
			list.add(visited[N-1][M-1]);
		}
		
		dfs(0);
		Collections.sort(list);
		
		if(list.isEmpty()) {
			System.out.println(-1);
		
		}else {
			System.out.println(list.get(0));
		}
		
	}
	
	public static void bfs(int y, int x) {
		yq.add(y);
		xq.add(x);
		visited[y][x]=1;
		
		while(!xq.isEmpty()) {
			int cury = yq.remove();
			int curx = xq.remove();
			
			for(int i=0; i<4; i++) {
				int ny = cury+dy[i];
				int nx = curx+dx[i];
				
				if(ny<0 || nx<0 || ny>=N || nx>=M) continue;
				
				if(map[ny][nx]==1) continue;
				
				if(visited[ny][nx]>=1) continue;
				
				yq.add(ny);
				xq.add(nx);
				visited[ny][nx] = visited[cury][curx]+1;
				
				
			}
			
			
			
		}
		
		
		
	}
	
	
	public static void dfs(int flag) {
		if(flag==1) {
			//Ãâ·Â
			/*for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.out.println();*/
			
			visited = new int[N][M];
			bfs(0, 0);
			if(visited[N-1][M-1]!=0) {
				list.add(visited[N-1][M-1]);
			}
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1) {
					map[i][j]=0;
					flag=1;
					dfs(flag);
					map[i][j]=1;
					flag=0;
				}
			}
		}
		
	}
	

}
