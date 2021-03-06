package day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1167 {
	static int V;
	static int adj[][];
	static int visited[];
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		
		adj = new int[V+1][V+1];
		visited = new int[V+1];
		
		for(int i=1; i<=V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int c = Integer.parseInt(st.nextToken());
				if(c==-1) break;
				int len = Integer.parseInt(st.nextToken());
				adj[p][c]=len;
			}
		}
		result=0;
		dfs(1, 0);
		System.out.println(result);
		
	}
	
	public static void dfs(int cur, int sum) {
		if(cur==V) return;
		result = Math.max(result, sum);
		
		for(int j=1; j<=V; j++) {
			
			if(visited[j]==0 && adj[cur][j]!=0) {
				visited[j]=1;
				dfs(j, sum += adj[cur][j]);
				visited[j]=0;
			}
		}
		
	}

}
