package day1008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[n+1][2*n];
		int memo[][] = new int[n+1][2*n];
		StringTokenizer st = null;
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int j=0;
			while(st.hasMoreTokens()) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
			
		}

		for(int i=1; i<=n; i++) {
			for(int j=0; j<2*n; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i=1; i<=n; i++) {
			for(int j=0; j<2*n; j++) {
				memo[i][j] = memo[i-1][j/2] + arr[i][j];
			}
		}
		
		
		
		for(int i=1; i<=n; i++) {
			for(int j=0; j<2*n; j++) {
				System.out.print(memo[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
}
