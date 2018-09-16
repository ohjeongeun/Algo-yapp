package day0827;

public class QuickSort {

	public static void main(String[] args) {
		//int arr[] = {30, 20, 10, 50, 40, 60, 100, 80, 90, 70};
		int arr[] = {6,5,3,1,8,7,2,4};
		quickSort(arr, 0, arr.length-1);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}

	}
	
	public static void quickSort(int arr[], int begin, int end) {
		if(begin<end) {
			int pivot = partition(arr, begin, end);
			quickSort(arr, begin, pivot-1);//pivot의 왼쪽 정렬
			quickSort(arr, pivot+1, end); //pivot의 오른쪽 정렬
			
		}
		
	}
	
	
	public static int partition(int arr[], int begin, int end) {
		int pivot = (begin+end)/2; //초기 피봇
		int left = begin;
		int right = end;
		
		while(left<right) {
			
			//arr[left]가 arr[pivot]보다 크거나 같은 것 찾으면 탐색 종료.
			while(arr[left]<arr[pivot] && left<right) { 
				left++;
			}
			
			//arr[right]가 arr[pivot]보다 작은 것 찾으면 탐색 종료.
			while(arr[right]>=arr[pivot] && left<right) {
				right--;
			}
			
			//left==right이기 전에 찾음
			if(left<right) {
				
				//left, right딱 붙어있는 경우
				//pivot설정할 때 pivot==left가 됨.
				if(left==pivot) {
					pivot = right;
				}
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
				
				
			}
			
		}
	
		//pivot<=left or right<pivot 못 찾아서 
		//left==right 일 경우까지 온 경우
		int tmp = arr[pivot];
		arr[pivot] = arr[right];
		arr[right] = tmp;
		
		return right; 
	}
	
	
	
	

}
