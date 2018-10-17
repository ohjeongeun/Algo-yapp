package day1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1932 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n+1][n+1];
		int memo[][] = new int[n+1][n+1];
		
		StringTokenizer st = null;
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int j=1;
			while(st.hasMoreTokens()) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				j++;
				
			}
		}

		//케이스 나누기
		//1. 왼쪽 대각선
		// 시작부터 쭉 왼쪽 대각선을 타고오는 방법밖에 없음
		//2. 오른쪽 대각선
		// 시작부터 쭉 오른쪽 대각선 타고오는 방법밖에 없음
		//3. 중간
		// 과거값 좌, 우 중에서 큰 값 + 자기자신
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				
				//왼쪽 대각선
				if(j==1) {
					memo[i][1] = memo[i-1][1] + arr[i][1];
					
				//오른쪽 대각선	
				}else if(j==i) {
					memo[i][j] = memo[i-1][j-1] + arr[i][j];
					
				//중간	
				}else {
										//과거 좌,          과거 우
					memo[i][j] = Math.max(memo[i-1][j-1], memo[i-1][j]) + arr[i][j];
					
				}
				
				
			}
		}
		
		//출력Test
		/*for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(memo[i][j]+" ");
			}
			System.out.println();
		}*/
		
		//2차원 배열 n행 오름차순 정렬
		Arrays.sort(memo[n]);
		System.out.println(memo[n][n]);
		
	}
}
