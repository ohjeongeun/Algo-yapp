package day0827;

public class SelectionSort {
	public static void main(String[] args) {
		int arr[] = {30, 20, 10, 50, 40, 60, 100, 80, 90, 70};
		selectionSort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void selectionSort(int arr[]) {
		int n = arr.length;
		
		for(int i=0; i<n; i++) {
			int minIndex = i;
			
			for(int j=i+1; j<n; j++) {
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
					
				}
				
			}
			
			int tmp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = tmp;
		}
		
		
	}
	
}
