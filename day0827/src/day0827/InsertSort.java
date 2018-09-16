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
		
		//정렬된 부분집합 S
		for(int i=1; i<arr.length; i++) {
			int pivot = arr[i];
			int sortedLast = i-1; //부분집합 S의 마지막 원소
			
			// 인덱스 범위 벗어나거나, S < pivot 이면 멈춤
			// = 인덱스 범위 내에 있고, S>=pivot 있으면 반복
			while(sortedLast>=0 && arr[sortedLast] >= pivot) {
				arr[sortedLast+1] = arr[sortedLast]; //배열 오른쪽으로 밀고 (pivot은 마지막에 교환)
				sortedLast--; //S원소 앞으로 이동하면서 정렬된 원소와 비교해 나감
				
			}
			
			// 인덱스 범위 벗어나거나, S < pivot 이면, 그 뒤에 pivot삽입
			// while문에서 sortedLast-- 해줬기 때문에 sortedLast+1
			arr[sortedLast+1] = pivot;
			
			
		}
	}
}
