package day0827;

public class InsertSort {

	public static void main(String[] args) {
		int arr[] = {30, 20, 10, 50, 40, 60, 100, 80, 90, 70};
		
		insertSort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void insertSort(int arr[]) {
		
		//���ĵ� �κ����� S
		for(int i=1; i<arr.length; i++) {
			int pivot = arr[i];
			int sortedLast = i-1; //�κ����� S�� ������ ����
			
			// �ε��� ���� ����ų�, S < pivot �̸� ����
			// = �ε��� ���� ���� �ְ�, S>=pivot ������ �ݺ�
			while(sortedLast>=0 && arr[sortedLast] >= pivot) {
				arr[sortedLast+1] = arr[sortedLast]; //�迭 ���������� �а� (pivot�� �������� ��ȯ)
				sortedLast--; //S���� ������ �̵��ϸ鼭 ���ĵ� ���ҿ� ���� ����
				
			}
			
			// �ε��� ���� ����ų�, S < pivot �̸�, �� �ڿ� pivot����
			// while������ sortedLast-- ����� ������ sortedLast+1
			arr[sortedLast+1] = pivot;
			
			
		}
	}
}
