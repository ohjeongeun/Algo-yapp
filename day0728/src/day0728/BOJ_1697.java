package day0728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
	static Queue<Integer> queue;
	static int dx[] = {-1, 1, 2};
	static int result;
	
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = 0;//수빈
		int K = 0;//동생
		while(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
		}
		result=1;
		find(N, K);
		
		System.out.println(result);
		long end = System.currentTimeMillis();

		System.out.println( "실행 시간 : " + ( end - start )/1000.0 );



	}
	
	public static void find(int N, int K) {
		queue = new LinkedList<>();
		
		//초기 수빈이 위치
		queue.add(N);
		
		while(!queue.isEmpty()) {
			
			int qsize = queue.size(); 
			for(int j=0; j<qsize; j++) {

				int v = queue.remove();
				
				int nv;
				for(int i=0; i<3; i++) {
					
					//다음 수빈이의 위치
					if(i==2) {
						nv = 2*v;
					}else {
						nv = v + dx[i];	
					}
					
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
