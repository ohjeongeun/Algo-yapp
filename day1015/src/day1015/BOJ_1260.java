package day1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {
	static int N; //정점개수
	static int M; //간선개수
	static int V; //시작 정점 번호
	static ArrayList<Integer> adj[];
	static int visited[];
	static Queue<Integer> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		//adj는 배열리스트 타입의 배열. 즉 행은 배열, 열은 ArrayList
		adj = new ArrayList[N+1];
		
		//각 행 별로 ArrayList 선언
		for(int i=0; i<=N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //정점
			int b = Integer.parseInt(st.nextToken()); //a의 이웃 정점
			
			adj[a].add(b);
			adj[b].add(a);
		}
		
		//인접리스트 출력Test
		/*for(int i=0; i<=N; i++) {
			//i는 각 정점. adj[i]의 원소들은 i의 이웃 정점들
			System.out.println(adj[i]);
		}*/
		
	
		visited = new int[N+1];
		
		visited[V]=1;
		dfs(V);
		System.out.println();
		
		q = new LinkedList<>();
		Arrays.fill(visited, 0);
		bfs(V);
		
	}
	
	public static void dfs(int cur) {
		System.out.print(cur+" ");
		
		for(int i=0; i<adj[cur].size(); i++) {
			
			int next = adj[cur].get(i);
			if(visited[next]==0) {
				visited[next]=1;
				dfs(next);
			}
		}
		
	}
	
	public static void bfs(int start) {
		q.add(start);
		visited[start]=1;
		
		while(!q.isEmpty()) {
			int cur = q.remove();
			System.out.print(cur+" ");
			
			for(int i=0; i<adj[cur].size(); i++) {
				
				int next = adj[cur].get(i);
				if(visited[next]==0) {
					q.add(next);
					visited[next]=1;
					
				}
				
			}
			
		}
		
	}
	
}
