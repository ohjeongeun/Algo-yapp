package day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463 {
	static int X;
	static int memo[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		X = Integer.parseInt(br.readLine());
		memo = new int[X+1];
		
		//memo[0]=0;
		//memo[1]=0;
		
		for(int i=2; i<=X; i++) {
			
			// -1로 갈 수 있는 것 일단 체크 & 전 숫자가 %2, %3==0이었으면 그 값+1 
			memo[i] = memo[i-1]+1;
			
			// %2가 되면? %2해서 얻은 값+1 vs -1로 가는 것 비교
			if(i%2==0) memo[i] = Math.min(memo[i], memo[i/2]+1);
			
			// %3가 되면? (else if 가 아니기 때문에) 
			// "%2 vs -1 해서 얻은 값" vs "%3해서 얻은값+1" 비교
			if(i%3==0) memo[i] = Math.min(memo[i], memo[i/3]+1);
			
		}
		
		System.out.println(memo[X]);
	}

}
