package day0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {
	static int N; //����� ��
	static int score[];
	static int memo[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		score = new int[N+1];
		memo = new int[N+1];
		for(int i=1; i<=N; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		
		
		//ù��� �����¹�� +1��� �ۿ� ����
		memo[1] = score[1];

		//�ι�° ��� ������ ��� �ΰ���(+2���, +1+1���)
		memo[2] = score[2] + Math.max(memo[0], memo[0]+score[1]);
		
		for(int i=3; i<=N; i++) {
								//+2���,          +2+1���  
			memo[i] = score[i] + Math.max(memo[i-2], memo[i-3]+score[i-1]);
		}
		

		System.out.println(memo[N]);
	}
	
	

}
