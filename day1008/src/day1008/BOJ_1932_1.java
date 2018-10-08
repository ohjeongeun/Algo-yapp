package day1008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1932_1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[n+1][n+1];
		int memo[][] = new int[n+1][n+1];
		StringTokenizer st = null;
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int j=1;
			while(st.hasMoreTokens()) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
			
		}

		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				
				//왼쪽 가장자리
				if(j==1) {
					memo[i][j] = memo[i-1][j] + arr[i][j];
					
				//오른쪽 가장자리
				}else if(j==i) {
					memo[i][j] = memo[i-1][j-1] + arr[i][j];
				
				//중간
				}else {
					memo[i][j] = Math.max(memo[i-1][j-1], memo[i-1][j]) + arr[i][j];
						
				}
				
			}
		}
		
		Arrays.sort(memo[n]);
		System.out.println(memo[n][n]);
		
		
		//출력Test
		/*for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(memo[i][j]+" ");
			}
			System.out.println();
		}*/
		
		
	}
}
