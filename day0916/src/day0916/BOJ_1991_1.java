package day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991_1 {
	static int N;
	static int tree[][];
	static String answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		tree = new int[27][2];
		
		for(int i=1; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = st.nextToken().charAt(0)-64;
			
			for(int j=0; j<2; j++) {
				int c = st.nextToken().charAt(0)-64;
				tree[p][j]=c;
			}
		}
		
		answer="";
		pre(1);
		System.out.println(answer);
		
		answer="";
		in(1);
		System.out.println(answer);
		
		answer="";
		post(1);
		System.out.println(answer);
	
		
	}
	
	public static void pre(int node) {
		if(node<=0) return;
		
		answer+= Character.toString((char)(node+64));
		pre(tree[node][0]);
		pre(tree[node][1]);
	}
	
	public static void in(int node) {
		if(node<=0) return;
		
		in(tree[node][0]);
		answer+= Character.toString((char)(node+64));
		in(tree[node][1]);
	}
	
	public static void post(int node) {
		if(node<=0) return;
		
		post(tree[node][0]);
		post(tree[node][1]);
		answer+= Character.toString((char)(node+64));
	}
	


}
