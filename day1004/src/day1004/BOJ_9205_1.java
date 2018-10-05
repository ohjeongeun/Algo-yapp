package day1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205_1 {
	static int T;
	static int N;
	static int visited[];
	static Queue<Node> q;
	
	static int fentaY;
	static int fentaX;
	
	static LinkedList<Node> list;
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine()); //편의점 개수
						
			StringTokenizer st = new StringTokenizer(br.readLine());
			list = new LinkedList<>();
			
			int homeY = Integer.parseInt(st.nextToken());
			int homeX = Integer.parseInt(st.nextToken());
			list.add(new Node(homeY, homeX));
			
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				list.add(new Node(y, x));
			}
			
			st = new StringTokenizer(br.readLine());
			fentaY = Integer.parseInt(st.nextToken());
			fentaX = Integer.parseInt(st.nextToken());
			list.add(new Node(fentaY, fentaX));
			
			visited = new int[N+2];
			
			q = new LinkedList<>();
			flag=false;
			bfs(homeY,homeX);
			if(flag==true) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
		}
	}
	
	public static int len(Node a, Node b) {
		int result=0;
		result = Math.abs(a.x-b.x)+Math.abs(a.y-b.y);
		return result;
	}
	
	public static void bfs(int y, int x) {
		q.add(new Node(y, x));
		visited[0]=1;
		
		while(!q.isEmpty()) {
			Node cur = q.remove();
			if(cur.equals(list.getLast())) {
				flag=true;
				return;
			}
			
			for(int i=0; i<N+2; i++) {
				Node p = list.get(i);
				
				if(visited[i]==1) continue;
				
				//현재위치와 편의점까지의 거리
				int distance = len(cur, p);
				
				if(distance<=1000) {
					q.add(p);
					visited[i]=1;
				}
				
				
			}
		}
	}
}

class Node {
	int y, x;
	public Node(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
}
