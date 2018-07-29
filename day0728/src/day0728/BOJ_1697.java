package day0728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1. 일단 두배로 가다가 동생범위 넘으면, 
2. 그전단계로 돌아와서 뒤로걷기(-1),
1~2 무한반복
*/

public class BOJ_1697 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = 0;//수빈
		int K = 0;//동생
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
