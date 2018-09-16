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
			
			// -1�� �� �� �ִ� �� �ϴ� üũ & �� ���ڰ� %2, %3==0�̾����� �� ��+1 
			memo[i] = memo[i-1]+1;
			
			// %2�� �Ǹ�? %2�ؼ� ���� ��+1 vs -1�� ���� �� ��
			if(i%2==0) memo[i] = Math.min(memo[i], memo[i/2]+1);
			
			// %3�� �Ǹ�? (else if �� �ƴϱ� ������) 
			// "%2 vs -1 �ؼ� ���� ��" vs "%3�ؼ� ������+1" ��
			if(i%3==0) memo[i] = Math.min(memo[i], memo[i/3]+1);
			
		}
		
		System.out.println(memo[X]);
	}

}
