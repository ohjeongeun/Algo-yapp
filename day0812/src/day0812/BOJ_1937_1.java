package day0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1937_1 {
	
	static int n;
	static int forest[][];
	static int visited[][];
	
					//우 하 좌 상
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	static int day;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		forest = new int[n+1][n+1];
		visited = new int[n+1][n+1];
		
		StringTokenizer st;
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int j=1;
			while(st.hasMoreTokens()) {
				forest[i][j]=Integer.parseInt(st.nextToken());
				j++;
			}
		}
		
		max = Integer.MIN_VALUE;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				max = Math.max(max, dp(i, j));
				//System.out.println(day);
				/*if(day>max) {
					max=day;
				}*/
				
				//출력
				for(int ii=1; ii<=n; ii++) {
					for(int jj=1; jj<=n; jj++) {
						System.out.print(visited[ii][jj]);
						
					}
					System.out.println();
				}
				System.out.println();
			}
		}
		
/*		for(int ii=1; ii<=n; ii++) {
			for(int jj=1; jj<=n; jj++) {
				System.out.print(visited[ii][jj]);
				
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println(max);*/
		
		
		
	}
	
	public static int dp(int y, int x) {
		//방문한적 있는 곳이면 종료.................
		if(visited[y][x]!=0) return visited[y][x];
		
		//day는 매번 1로 초기화
		day=1;
		for(int i=0; i<4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			//경계선 안이고 현재 대나무보다 많으면
			if((ny>=0 && ny<=n) && (nx>=0 && nx<=n)) {
				if(forest[ny][nx] > forest[y][x]) {
					day = Math.max(day, dp(ny, nx)+1);
					visited[y][x] = day;
				}
			}
			
			
		}
		return day;
		
	}
	
	
	

}
