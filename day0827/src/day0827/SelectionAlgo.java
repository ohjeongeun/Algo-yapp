package day0827;

public class SelectionAlgo {

	public static void main(String[] args) {
		int arr[] = {30, 20, 10, 50, 40, 60, 100, 80, 90, 70};
		int result = selectionAlgo(arr, 2);
		System.out.println(result);
	}
	
	public static int selectionAlgo(int arr[], int k) {
		int n = arr.length;
		
		for(int i=0; i<=k; i++) {
			// �� ȸ��. ù min�� arr[i]�� �ʱ�ȭ
			int minIndex = i;
			int minValue = arr[i];
			
			// arr[i+1] ~ .. arr[n-1] ����, arr[i]���� ������ �ִ��� ã����. min�� ����ؼ� ����
			for(int j=i+1; j<n; j++) {
				if(arr[j]<minValue) {
					minIndex = j;
					minValue = arr[j];
				}
				
			}
			
			//���� �� min��, arr[i] ��ȯ. min�� ���� �ȵ��־ ��� ����.
			int tmp = arr[i];
			arr[i] = minValue;
			minValue = tmp;
			
			
		}
		return arr[k];
		
	}
	
}
