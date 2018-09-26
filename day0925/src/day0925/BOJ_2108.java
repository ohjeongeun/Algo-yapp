package day0925;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_2108 {
	
	static int N;
	static int arr[];
	static int arr2[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		//산술평균, 중앙값, 범위 구하기 위한 배열
		arr = new int[N];
		
		//최빈값 구하기 위한 배열. 
		arr2 = new int[8002];
		for(int i=0; i<N; i++) {
			int token = Integer.parseInt(br.readLine());
			
			// 음수는 index 처리 할 수 없으니 
			// -4000  -1 => 1 ~ 4000
			// 0=> 4001 , 1 ~ 4000 => 4002 ~ 8001
			int nToken = token+4001;
			arr2[nToken]++;
			
			arr[i]=token;
			
		}
		
		double sum=0;
		//산술평균
		for(int i=0; i<N; i++) {
			sum += arr[i];
		}
		double avg = sum/N;
		System.out.println(Math.round(avg));
		
		
		//중앙값
		Arrays.sort(arr);
		System.out.println(arr[N/2]);

		
		//최빈값
		ArrayList<Integer> list = new ArrayList<>();
		int max=0;
		for(int i=arr2.length-1; i>=1; i--) {
			//큰놈 찾음
			if(max<arr2[i]) {
				max = arr2[i];
			}
		}	
		
		for(int i=arr2.length-1; i>=1; i--) {
			if(max==arr2[i]) {
				list.add(i-4001);
			}
		}
			
		Collections.sort(list);

		if(list.size()>1) {
			System.out.println(list.get(1));
		}else {
			System.out.println(list.get(0));
		}
		
		//범위
		System.out.println(arr[N-1]-arr[0]);

	}
}
