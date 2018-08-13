package day0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052 {
static int N; //�ؾ ����
static int price[]; //�ؾ ���� ������ �迭
static int income[]; //income[N] = N�� ���� �� ���� �� �ִ� �ִ� ����
	
public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		
		//�ߺ��� ����Ͽ� ������ �ִ밪�� ����� ���� => �ڿ��� ���� ����
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		//���� ����
		price = new int[N+1];
		int i=1;
		while(st.hasMoreTokens()) {
			price[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		
		
		//�� 4���� �Ǹ��� �� �ִ밪
		//=������ 1�������� �� = 1���ȶ� ���� + 3���� �� �ִ�
		//=������ 2�������� �� = 2���ȶ� ���� + 2���ȶ� �ִ�
		// ...
		//=������ i�� ������ �� = i���ȶ� ���� + (N-i)�� �� �� �ִ�
		// 				= price[i] + income[N-i]

		
		//�� �ε������� i�� �Ǹ��Ҷ� �ִ� ���� ����
		income = new int[N+1];
		
		for(int j=1; j<=N; j++) {
			
			//income[i] ���Ҷ����� 1~i ���� �Ǹ��Ҷ��� �ִ��� ��� ���Ͽ� ã��
			for(int k=1; k<=j; k++) {
				income[j] = Math.max(income[j], income[j-k]+price[k]);
			}
			
		}
		
		System.out.println(income[N]);
		
	}
	

}
