package day0926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_9322 {
	static int T;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			n = Integer.parseInt(br.readLine());

			HashMap<String, Integer> p1 = new HashMap<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++) {
				p1.put(st.nextToken(), i);
				
			}
			
			//p1 찾아서 value에 저장 
			HashMap<Integer, String> p2 = new HashMap<>();
			st = new StringTokenizer(br.readLine());
			StringTokenizer value = new StringTokenizer(br.readLine());
			
			//crypto의 key : p1->p2 index순서
			HashMap<Integer, String> crypto = new HashMap<>();
			for(int i=1; i<=n; i++) {
				String s = st.nextToken();
				String v = value.nextToken();
				if(p1.containsKey(s)) {
					p2.put(p1.get(s), s);
					crypto.put(p1.get(s), v);
				}
			}
			
			//복호화
			for(int i=1; i<=n; i++) {
				System.out.print(crypto.get(i)+" ");
			}
			
			
		}
		
	}

}
