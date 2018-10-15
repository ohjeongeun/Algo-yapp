package day1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_6603 {
	static int k;
	static int s[];
	static int visited[];
	static String sub;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			if(str.equals("0")) {
				return;
			}
			StringTokenizer st = new StringTokenizer(str);
	
			k = Integer.parseInt(st.nextToken());
			s = new int[k];
			visited = new int[k];
			
			for(int i=0; i<k; i++) {
				s[i] = Integer.parseInt(st.nextToken());
				
			}
			
			sub="";
			dfs(0, 0);
			System.out.println();
			
		}
	}
	
	public static void dfs(int cur, int cnt) {
		if(cnt==6) {
			System.out.println(sub);
		}
		
		
		for(int i=cur; i<k; i++) {
			String next = String.valueOf(s[i]);
			
			if(visited[i]==1) continue;
			
			visited[i]=1;
			sub+=next;
			sub+=" ";
			dfs(i, cnt+1);
			visited[i]=0;
			sub = sub.substring(0, sub.length()-next.length()-1);
			
			
		}
		
	}
	

}
