package day1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_1 {
	static int N;
	static int M;
	static int map[][];
	static int visited[][];
	static Queue<Integer> xq;
	static Queue<Integer> yq;
	
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	static ArrayList<Integer> xlist;
	static ArrayList<Integer> ylist;
	
	static ArrayList<Integer> result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new int[N][M];
		
		xlist = new ArrayList<>();
		ylist = new ArrayList<>();
		xlist.add(0);
		ylist.add(0);
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j)-'0';
				if(map[i][j]==1) {
					ylist.add(i);
					xlist.add(j);
				}
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

		result = new ArrayList<>();
		for(int i=0; i<xlist.size(); i++) {
			visited = new int[N][M];
			int y = ylist.get(i);
			int x = xlist.get(i);
			
			map[y][x]=0;
			bfs(0,0);
			if(visited[N-1][M-1]!=0) {
				result.add(visited[N-1][M-1]);
			}
			
			map[y][x]=1;
					
		}
		
		//bfs(0,0);
		//System.out.println(visited[N-1][M-1]);
		
		Collections.sort(result);
		if(result.size()>0) {
			System.out.println(result.get(0));
			
		}else {
			System.out.println(-1);
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
	
	
}
