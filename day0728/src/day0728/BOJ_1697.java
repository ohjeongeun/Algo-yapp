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
		
		int N = 0;//수빈
		int K = 0;//동생
		
		//N, K값 받음
		while(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
		}
		
		result=1;
		find(N, K);
		
		System.out.println(result);

	}
	
	public static void find(int N, int K) {
		//큐 생성
		queue = new LinkedList<>();
		
		//초기 수빈이 위치 enQueue
		queue.add(N);
		
		while(!queue.isEmpty()) {
			
			//queue사이즈만큼 for문으로 감싸주면 depth표현 가능
			int qsize = queue.size(); 
			for(int j=0; j<qsize; j++) {

				int v = queue.remove();
				
				
				int nv;
				//다음 수빈이의 위치 탐색
				for(int i=0; i<3; i++) {
					
					// 2*X 경우는 덧셈으로 표현 불가능해서 직접 곱해줌
					if(i==2) {
						nv = 2*v;
					//X-1 or X+1
					}else {
						nv = v + dx[i];	
					}
					
					//수빈이의 다음위치가 동생과 같으면 함수 종료.
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
