package day0926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1620_1 {
	static String arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new String[N+1];
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=1; i<=N; i++) {
			arr[i] = br.readLine();
			map.put(arr[i], i);
		}
		
		
		for(int i=0; i<M; i++) {
			String command = br.readLine();
			
			if(1<=command.charAt(0)-'0'&&command.charAt(0)-'0'<=9) {
				int index = Integer.parseInt(command);
				System.out.println(arr[index]);
			
			}else {
				System.out.println(map.get(command));
				
			}
		}
	}
}
