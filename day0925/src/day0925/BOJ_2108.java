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
		
		arr = new int[N];
		arr2 = new int[8002];
		for(int i=0; i<N; i++) {
			int token = Integer.parseInt(br.readLine());
			
			if(token<0) {
				// -4000  -1 => 1 ~ 4000
				int nToken = token+4001;
				arr2[nToken]++;
			
				// 0=> 4001 , 1 ~ 4000 => 4002 ~ 8001
			}else {
				int nToken = token+4001;
				arr2[nToken]++;
			}
			
			arr[i]=token;
			
		}
		
		double sum=0;
		//»ê¼úÆò±Õ
		for(int i=0; i<N; i++) {
			sum += arr[i];
		}
		double avg = sum/N;
		System.out.println(Math.round(avg));
		
		
		//Áß¾Ó°ª
		Arrays.sort(arr);
		System.out.println(arr[N/2]);
		
		ArrayList<Integer> list = new ArrayList<>();
		int max=0;
		int index=0;
		//ÃÖºó°ª
		for(int i=arr2.length-1; i>=1; i--) {
			//Å«³ð Ã£À½
			if(max<arr2[i]) {
				max = arr2[i];
				index = i;
			}
		}	
		
		for(int i=arr2.length-1; i>=1; i--) {
			if(max==arr2[i]) {
				list.add(i-4001);
			}
		}
			
		//System.out.println(list);
		Collections.sort(list);
		//System.out.println(list);
			
		if(list.size()>1) {
			System.out.println(list.get(1));
		}else {
			System.out.println(list.get(0));
		}
		
		//¹üÀ§
		System.out.println(arr[N-1]-arr[0]);
		

	}
}
