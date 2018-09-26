package day0926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class BOJ_11279_2 {
	static int N;
	static LinkedList<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int max=0;
		list = new LinkedList<>();
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x==0) {
				
				//사이즈 0 이상
				if(list.size()>0) {
					
					System.out.println(list.removeFirst());

					if(list.size()==0) {
						max=0;
					}else {
						max = list.getFirst();
					}
					
				} else {
					max=0;
					System.out.println(0);
				}
				
			}else {
				if(max<=x) {
					max=x;
					list.addFirst(x);
				}else {
					list.addLast(x);
				}
				
			}
			
			
			
			
		}
		
	}

}
