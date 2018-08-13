package day0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052 {
static int N; //붕어빵 개수
static int price[]; //붕어빵 가격 저장할 배열
static int income[]; //income[N] = N개 샀을 때 얻을 수 있는 최대 수익
	
public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		
		//중복을 허용하여 선택해 최대값을 만드는 문제 => 뒤에서 부터 접근
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		//가격 저장
		price = new int[N+1];
		int i=1;
		while(st.hasMoreTokens()) {
			price[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		
		
		//총 4개를 판매할 때 최대값
		//=마지막 1개남았을 때 = 1개팔때 가격 + 3개팔 때 최댓값
		//=마지막 2개남았을 때 = 2개팔때 가격 + 2개팔때 최댓값
		// ...
		//=마지막 i개 남았을 때 = i개팔때 가격 + (N-i)개 팔 때 최댓값
		// 				= price[i] + income[N-i]

		
		//매 인덱스마다 i개 판매할때 최대 수익 저장
		income = new int[N+1];
		
		for(int j=1; j<=N; j++) {
			
			//income[i] 구할때마다 1~i 까지 판매할때의 최댓값을 계속 비교하여 찾음
			for(int k=1; k<=j; k++) {
				income[j] = Math.max(income[j], income[j-k]+price[k]);
			}
			
		}
		
		System.out.println(income[N]);
		
	}
	

}
