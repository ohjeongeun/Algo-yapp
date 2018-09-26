package day0926;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ex {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int result = 0;
				if(o1<o2) {
					result = 1;
				}else {
					result = -1;
				}
				return result;
			}
			
		});
		
		pq.add(9);
		pq.add(3);
		pq.add(2);
		pq.add(1);
		pq.add(7);
		pq.add(0);
		
		for(int i=0; i<6; i++) {
			System.out.println(pq.poll());
		}
		
		
		
	}

}
