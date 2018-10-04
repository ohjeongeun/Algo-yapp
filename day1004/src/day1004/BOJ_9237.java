package day1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_9237 {
	static int N;
	static Integer arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		int max=0;
		for(int i=0; i<N; i++) {
			int k = N-1-i;
			arr[i]-=k;
			if(max<arr[i]) {
				max=arr[i];
			}
		}
		
		System.out.println(max+N+1);
		
		
	}

}
