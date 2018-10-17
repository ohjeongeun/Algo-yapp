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

		//���̽� ������
		//1. ���� �밢��
		// ���ۺ��� �� ���� �밢���� Ÿ����� ����ۿ� ����
		//2. ������ �밢��
		// ���ۺ��� �� ������ �밢�� Ÿ����� ����ۿ� ����
		//3. �߰�
		// ���Ű� ��, �� �߿��� ū �� + �ڱ��ڽ�
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				
				//���� �밢��
				if(j==1) {
					memo[i][1] = memo[i-1][1] + arr[i][1];
					
				//������ �밢��	
				}else if(j==i) {
					memo[i][j] = memo[i-1][j-1] + arr[i][j];
					
				//�߰�	
				}else {
										//���� ��,          ���� ��
					memo[i][j] = Math.max(memo[i-1][j-1], memo[i-1][j]) + arr[i][j];
					
				}
				
				
			}
		}
		
		//���Test
		/*for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(memo[i][j]+" ");
			}
			System.out.println();
		}*/
		
		//2���� �迭 n�� �������� ����
		Arrays.sort(memo[n]);
		System.out.println(memo[n][n]);
		
	}
}
