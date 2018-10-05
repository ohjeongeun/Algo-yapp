package day1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1707 {
	static int K;
	static int V;
	static int E;
	static Queue<Node> q;
	static ArrayList<Integer> arr[];
	static String visited[];
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		for(int t=0; t<K; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			arr = new ArrayList[V+1];
			visited = new String[V+1];
			for(int i=0; i<=V; i++) {
				arr[i] = new ArrayList<>();
			}
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				arr[p].add(c);
				arr[c].add(p);
				
			}
			
			q = new LinkedList<>();
			flag=true;
			Arrays.fill(visited, "X");
			bfs(1);
			
			if(flag==true) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
		
	}
	
	public static void bfs(int v) {
		q.add(new Node(v, "A"));
		visited[v]="A";
		
		while(!q.isEmpty()) {
			int curNode = q.peek().node;
			String curColor = q.peek().option;
			q.remove();
			
			for(int i=0; i<arr[curNode].size(); i++) {
				int nextNode = arr[curNode].get(i);
				
				if(curColor.equals("A")) {
					
					
					//비어있으면
					if(visited[nextNode].equals("X")) {
						visited[nextNode]="B";
						q.add(new Node(nextNode, "B"));
					
					//비어있지 않으면
					}else {
						
						//맞게 들어갔으면 넘기기
						if(visited[nextNode].equals("B")) {
							continue;
						}else {
							flag=false;
						}
						
					}
					
					
				}else if(curColor.equals("B")) {
					//비어있으면	
					if(visited[nextNode].equals("X")) {
						visited[nextNode]="A";
						q.add(new Node(nextNode, "A"));
					
					//비어있지 않으면
					}else {
						if(visited[nextNode].equals("A")) {
							continue;
						}else {
							flag=false;
						}
						
					}
				}
			}
		}
	}
}

class Node {
	int node;
	String option;
	public Node(int node, String option) {
		this.node = node;
		this.option = option;
	}
	
}
