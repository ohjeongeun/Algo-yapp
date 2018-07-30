package day0728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
	static Queue<Integer> queue;
	
					//X-1 X+1 2*X
	static int dx[] = {-1, 1, 2};
	static int result;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = 0;//����
		int K = 0;//����
		
		//N, K�� ����
		while(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
		}
		
		result=1;
		find(N, K);
		
		System.out.println(result);

	}
	
	public static void find(int N, int K) {
		//ť ����
		queue = new LinkedList<>();
		
		//�ʱ� ������ ��ġ enQueue
		queue.add(N);
		
		while(!queue.isEmpty()) {
			
			//queue�����ŭ for������ �����ָ� depthǥ�� ����
			int qsize = queue.size(); 
			for(int j=0; j<qsize; j++) {

				int v = queue.remove();
				
				
				int nv;
				//���� �������� ��ġ Ž��
				for(int i=0; i<3; i++) {
					
					// 2*X ���� �������� ǥ�� �Ұ����ؼ� ���� ������
					if(i==2) {
						nv = 2*v;
					//X-1 or X+1
					}else {
						nv = v + dx[i];	
					}
					
					//�������� ������ġ�� ������ ������ �Լ� ����.
					if(nv==K) {
						//System.out.println(nv);
						return;
					}
					
					queue.add(nv);
					
				}
				
			}
			//System.out.println(queue);
			result++;
			
		}
		
	}
	
}
