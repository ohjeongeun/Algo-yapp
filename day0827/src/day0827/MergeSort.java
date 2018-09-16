package day0827;

import java.util.LinkedList;

public class MergeSort {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(30);
		list.add(20);
		list.add(10);
		list.add(50);
		list.add(40);
		list.add(60);
		list.add(100);
		list.add(80);
		list.add(90);
		list.add(70);
		
		System.out.println("result"+mergeSort(list));

	}
	
	public static LinkedList<Integer> mergeSort(LinkedList<Integer> list) {
		//분할 과정
		//리스트 길이 1이면 분할 종료
		if(list.size()==1) return list;
		
		LinkedList<Integer> left = new LinkedList<>();
		LinkedList<Integer> right = new LinkedList<>();
		LinkedList<Integer> result = new LinkedList<>(); //합병된 결과 담을 list
		
		int middle = list.size()/2;
		
		for(int x=0; x<middle; x++) {
			left.add(list.get(x));
		}
		
		for(int x=middle; x<list.size(); x++) {
			right.add(list.get(x));
		}
		
		//출력 테스트
		System.out.println("left "+left);
		left = mergeSort(left);
		
		//출력 테스트
		System.out.println("right "+right);
		right = mergeSort(right);
		
		return merge(result, left, right);
		
	}
	
	public static LinkedList<Integer> merge(LinkedList<Integer> result, LinkedList<Integer> left, LinkedList<Integer> right) {
		
		
		while(left.size()>0 || right.size()>0) {
			
			//1. left, right 둘 다 0보다 클 때
			if(left.size()>0 && right.size()>0) {
				
				//left첫 원소 <= right 첫원소
				if(left.getFirst() <= right.getFirst()) {
					//작은 쪽 첫 원소 결과리스트에 삽입
					result.add(left.removeFirst());
				}else {
					result.add(right.removeFirst());
				}
			
			//2. right원소는 다 정렬 됬고, left 원소만 남았을 때
			}else if(left.size()>0) {
				result.add(left.removeFirst());
			
			//3. left원소는 다 정렬됬고, right 원소만 남았을 때
			}else if(right.size()>0) {
				result.add(right.removeFirst());
			}
			
			//출력 테스트
			System.out.println(result);
		}
		
		
		return result;
	}
	
	

}
