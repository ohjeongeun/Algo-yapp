package day1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014 {
	static int F, S, G, U, D;
	static int visited[];
	static Queue<Integer> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken()); //ÃÑ FÃþ
		S = Integer.parseInt(st.nextToken()); //°­È£
		G = Integer.parseInt(st.nextToken()); //½ºÅ¸Æ®¸µÅ©
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		visited = new int[F+1];
		q = new LinkedList<>();
		
		bfs(S);
		int result = visited[G];
		if(result==0) {
			System.out.println("use the stairs");
		}else {
			System.out.println(result-1);
		}
	}
	
	public static void bfs(int s) {
		q.add(s);
		visited[s]=1;
		
		while(!q.isEmpty()) {
			int cur = q.remove();
			
			int dx[] = new int[]{U, -D};
			for(int i=0; i<dx.length; i++) {
				int next = cur + dx[i];
				
				if(next<0 || next>F) continue;
				
				if(visited[next]>0) continue;
				
				q.add(next);
				visited[next] = visited[cur]+1;
				
				
			}
		}
	}
}
