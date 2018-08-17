package day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2444 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<2*N-1; j++) {
				//¡â
				
				if(j<N-1-i) {
					System.out.print(" ");
				
				}else if(N-1-i<=j && j<=N-1+i) {
					System.out.print("*");
				
				}
				
			}
			System.out.println();
		}
		
		for(int i=N-2; i>=0; i--) {
			for(int j=0; j<2*N-1; j++) {
				//¡ä
				if(j<N-1-i) {
					System.out.print(" ");
				
				}else if(N-1-i<=j && j<=N-1+i) {
					System.out.print("*");
				
				}
			}
			System.out.println();
		}
		
		
	}

}
