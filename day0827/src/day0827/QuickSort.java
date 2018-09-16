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
			quickSort(arr, begin, pivot-1);//pivot�� ���� ����
			quickSort(arr, pivot+1, end); //pivot�� ������ ����
			
		}
		
	}
	
	
	public static int partition(int arr[], int begin, int end) {
		int pivot = (begin+end)/2; //�ʱ� �Ǻ�
		int left = begin;
		int right = end;
		
		while(left<right) {
			
			//arr[left]�� arr[pivot]���� ũ�ų� ���� �� ã���� Ž�� ����.
			while(arr[left]<arr[pivot] && left<right) { 
				left++;
			}
			
			//arr[right]�� arr[pivot]���� ���� �� ã���� Ž�� ����.
			while(arr[right]>=arr[pivot] && left<right) {
				right--;
			}
			
			//left==right�̱� ���� ã��
			if(left<right) {
				
				//left, right�� �پ��ִ� ���
				//pivot������ �� pivot==left�� ��.
				if(left==pivot) {
					pivot = right;
				}
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
				
				
			}
			
		}
	
		//pivot<=left or right<pivot �� ã�Ƽ� 
		//left==right �� ������ �� ���
		int tmp = arr[pivot];
		arr[pivot] = arr[right];
		arr[right] = tmp;
		
		return right; 
	}
	
	
	
	

}
