package day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991 {
	static int N;
	static String tree[];
	static String answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		tree = new String[(int) Math.pow(2, 26)];
		tree[1] = "A";
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				String p = st.nextToken();
				int cindex = findParentIndex(p)*2;
				int c2index = cindex+1;
				
				tree[cindex] = st.nextToken();
				tree[c2index] = st.nextToken();
				
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
		if(node>2*N+1) return;
		
		makeAnswer(tree[node]);
		pre(2*node);
		pre(2*node+1);
	}
	
	public static void in(int node) {
		if(node>2*N+1) return;
		
		in(2*node);
		makeAnswer(tree[node]);
		in(2*node+1);
	}
	
	public static void post(int node) {
		if(node>2*N+1) return;
		
		post(2*node);
		post(2*node+1);
		makeAnswer(tree[node]);
	}
	
	public static void makeAnswer(String node) {
		
		if(node!=null && !node.isEmpty() &&!node.equals("") && !node.equals(".") ) {
			answer += node;
		}
	}
	
	public static int findParentIndex(String p) {
		int index=0;
		for(int i=1; i<tree.length; i++) {
			if(p.equals(tree[i])) {
				index = i;
				break;
			}
		}
		return index;
	}

}
