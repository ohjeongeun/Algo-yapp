package day0827;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = {30, 20, 10,50, 40, 60, 100, 80, 90, 70};
		bubbleSort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void bubbleSort(int arr[]) {
		int n = arr.length;
		
		for(int i=n-1; i>=0; i--) { //�� ȸ�� �� ��ȯ�� Ƚ�� : i 
			for(int j=0; j<=i-1; j++) {
				if(arr[j] > arr[j+1]) { //���� �� �� �����ϸ�
					int tmp = arr[j+1]; //��ȯ
					arr[j+1] = arr[j];
					arr[j] = tmp;
				}
			}
			
		}
	}

}
