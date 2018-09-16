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
			// 매 회전. 첫 min은 arr[i]로 초기화
			int minIndex = i;
			int minValue = arr[i];
			
			// arr[i+1] ~ .. arr[n-1] 까지, arr[i]보다 작은놈 있는지 찾으며. min값 계속해서 갱신
			for(int j=i+1; j<n; j++) {
				if(arr[j]<minValue) {
					minIndex = j;
					minValue = arr[j];
				}
				
			}
			
			//갱신 된 min값, arr[i] 교환. min값 갱신 안되있어도 상관 없음.
			int tmp = arr[i];
			arr[i] = minValue;
			minValue = tmp;
			
			
		}
		return arr[k];
		
	}
	
}
