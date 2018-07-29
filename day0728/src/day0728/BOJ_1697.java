package day0728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1. �ϴ� �ι�� ���ٰ� �������� ������, 
2. �����ܰ�� ���ƿͼ� �ڷΰȱ�(-1),
1~2 ���ѹݺ�
*/

public class BOJ_1697 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = 0;//����
		int K = 0;//����
		while(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
		}
		
		recursive(N, K);
		
	}
	
	public static void recursive(int N, int K) {
		
		System.out.println(N+" "+K);
		
		if(N>K) {
			N=N/2;
			N=N-1;
		}
		
		recursive(2*N, K);
				
		
	
		
		
		
		
	}
	
	
}
