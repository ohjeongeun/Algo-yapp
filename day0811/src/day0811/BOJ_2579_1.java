package day0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579_1 {
	static int N;
	static int stair[];
	static int oneStep[];
	static int twoStep[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// 0   1   2   3   4   5   6
		//[0][10][20][15][25][10][20]
		//                        v (필수 방문)
		
		//1.                   v  v (1. +1이동)
		//1)           v       v  v (1. +2+1이동)
		//=> oneStep[i] =  stair[i] + twoStep[i-1]
		
		//2.               v      v (2.  +2이동)
		//1)           v   v      v (2-1. +1+2이동)
		//=> twoStep[i] = stair[i] + oneStep[i-2];
		
		//2)       v       v      v (2-2. +2+2이동)
		//=> twoStep[i] = start[i] + twoStep[i-2];
		
		stair = new int[N+1];
		oneStep = new int[N+1];
		twoStep = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		oneStep[1] = stair[1];
		twoStep[1] = stair[1];
		
		for(int i=2; i<=N; i++) {
			oneStep[i] = stair[i] + twoStep[i-1];
			twoStep[i] = stair[i] + Math.max(oneStep[i-2], twoStep[i-2]);
			
		}
		
		
		System.out.println(Math.max(oneStep[N], twoStep[N]));
		
	}

}
