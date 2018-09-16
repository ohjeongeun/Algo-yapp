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
		//���� ����
		//����Ʈ ���� 1�̸� ���� ����
		if(list.size()==1) return list;
		
		LinkedList<Integer> left = new LinkedList<>();
		LinkedList<Integer> right = new LinkedList<>();
		LinkedList<Integer> result = new LinkedList<>(); //�պ��� ��� ���� list
		
		int middle = list.size()/2;
		
		for(int x=0; x<middle; x++) {
			left.add(list.get(x));
		}
		
		for(int x=middle; x<list.size(); x++) {
			right.add(list.get(x));
		}
		
		//��� �׽�Ʈ
		System.out.println("left "+left);
		left = mergeSort(left);
		
		//��� �׽�Ʈ
		System.out.println("right "+right);
		right = mergeSort(right);
		
		return merge(result, left, right);
		
	}
	
	public static LinkedList<Integer> merge(LinkedList<Integer> result, LinkedList<Integer> left, LinkedList<Integer> right) {
		
		
		while(left.size()>0 || right.size()>0) {
			
			//1. left, right �� �� 0���� Ŭ ��
			if(left.size()>0 && right.size()>0) {
				
				//leftù ���� <= right ù����
				if(left.getFirst() <= right.getFirst()) {
					//���� �� ù ���� �������Ʈ�� ����
					result.add(left.removeFirst());
				}else {
					result.add(right.removeFirst());
				}
			
			//2. right���Ҵ� �� ���� ���, left ���Ҹ� ������ ��
			}else if(left.size()>0) {
				result.add(left.removeFirst());
			
			//3. left���Ҵ� �� ���ĉ��, right ���Ҹ� ������ ��
			}else if(right.size()>0) {
				result.add(right.removeFirst());
			}
			
			//��� �׽�Ʈ
			System.out.println(result);
		}
		
		
		return result;
	}
	
	

}
