package day0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1937 {
	
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
				visited = new int[n+1][n+1];
				day=0;
				dp(i, j);
				//System.out.println(day);
				if(day>max) {
					max=day;
				}
				
				/*//출력
				for(int ii=1; ii<=n; ii++) {
					for(int jj=1; jj<=n; jj++) {
						System.out.print(visited[ii][jj]);
						
					}
					System.out.println();
				}
				System.out.println();*/
			}
		}
		
		System.out.println(max);
		
		
		
	}
	
	public static void dp(int y, int x) {
		int vy=y; int vx=x;
		visited[vy][vx] = 1;
		day++;
		
		for(int i=0; i<4; i++) {
			int ny = vy+dy[i];
			int nx = vx+dx[i];
			
			if(ny<0 || nx<0 || ny>=n || nx>=n) {
				continue;
			}
			
			//다음점이 현재점보다 작거나 같으면 pass
			if(forest[ny][nx] <= forest[vx][vy]) {
				continue;
			}
			
			//방문안한지점이면
			if(visited[ny][nx]==0) {
				visited[ny][nx]=1;
				vy = ny;
				vx = nx;
				day++;
			}
			
		}
		
	}

}
