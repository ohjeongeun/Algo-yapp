package day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1167_1 {
	static int V;
	static ArrayList<Node> adj[];
	static int visited[];
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[V+1];
		visited = new int[V+1];
		
		for(int i=0; i<V+1; i++) {
			adj[i] = new ArrayList<Node>();
		}
		
		for(int i=1; i<=V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int c = Integer.parseInt(st.nextToken());
				if(c==-1) break;
				int len = Integer.parseInt(st.nextToken());
				adj[p].add(new Node(c, len));
			}
		}
		
		/*for(int i=1; i<=V; i++) {
			for(int j=0; j<adj[i].size(); j++) {
				System.out.print(adj[i].get(j).n+" "+adj[i].get(j).len);
			}
			System.out.println();
		}*/
		
		for(int i=1; i<=V; i++) {
			dfs(i);
		}
		
		br.close();
	}
	
	public static void dfs(int cur) {
		for(int j=0; j<adj[cur].size(); j++) {
			//cur과 cur의 이웃점들 거리 비교
			
		}
	}

}

class Node {
	int n;
	int len;
	
	Node(int n, int len) {
		this.n = n;
		this.len = len;
	}
	
}
