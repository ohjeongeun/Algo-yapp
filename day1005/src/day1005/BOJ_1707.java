package day1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1707 {
	static int adj[][];
	static int visited[];
	static int V;
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		for(int t=0; t<K; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); //정점
			int E = Integer.parseInt(st.nextToken()); //간선
			
			adj = new int[V+1][V+1];
			visited = new int[V+1];
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				adj[p][c]=1;
				
			}
			
			
			/*for(int i=1; i<=V; i++) {
				for(int j=1; j<=V; j++) {
					System.out.print(adj[i][j]);
				}	
				System.out.println();
			}*/
			
			flag=true;
			dfs(1);
			if(flag==true ) {
				System.out.println("YES");
			}
			
		}
		
	}
	
	public static void dfs(int v) {
		
		for(int j=1; j<=V; j++) {
			
			if(adj[v][j]==1) {
				
				if(visited[j]==0) {
					visited[j]=1;
					dfs(j);
					visited[j]=0;
				
				}else if(visited[j]==1) {
					System.out.println("NO");
					flag=false;
					return;
				}
				
				
			}
			
			
		}
		
		
	}

}
