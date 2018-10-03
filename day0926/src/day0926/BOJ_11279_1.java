package day0926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class BOJ_11279_1 {
	static int N;
	static PriorityQueue<Integer> pq;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int result = 0;
				
				if(o1<o2) {
					result = 1; //내림차순
				}else {
					result = -1;
				}
				
				return result;
			}
			
		});
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x==0) {
				if(pq.size()>0) {
					System.out.println(pq.poll());
				}else {
					System.out.println(0);
				}
			}else {
				pq.add(x);
				
			}
			
		}
		
	}

}
