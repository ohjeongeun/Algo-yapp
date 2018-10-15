package day1008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {
	static int N;
	static int map[][];
	static int memo[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][3];
		memo = new int[N+1][3];
		StringTokenizer st = null;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		//memo[0][0] = memo[0][1] = memo[0][2] = 0
		
		for(int i=1; i<=N; i++) {
			memo[i][0] = Math.min(memo[i-1][1], memo[i-1][2]) + map[i][0]; //첫 시작 R
			memo[i][1] = Math.min(memo[i-1][0], memo[i-1][2]) + map[i][1]; //첫 시작 G
			memo[i][2] = Math.min(memo[i-1][0], memo[i-1][1]) + map[i][2]; //첫 시작 B
			
		}
		
		for(int i=0; i<=N; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(memo[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println(Math.min(Math.min(memo[N][0], memo[N][1]), memo[N][2]));
		
		
	}
}
