package day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725 {
	static int N;
	
	static ArrayList<Integer> data[];
	static int tree[][];
	static int visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new int[N+1];
		
		data = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			data[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			data[t1].add(t2);
			data[t2].add(t1);
		
		}
		
		tree = new int[N+1][2];
		makeTree(1);
		
		for(int k=2; k<N+1; k++) {
			for(int i=1; i<N+1; i++) {
				for(int j=0; j<2; j++) {
					if(tree[i][j]==k) {
						System.out.println(i);
					}
				}
			}
		}
		
	}
	
	public static void makeTree(int i) {
		
		for(int j=0; j<data[i].size(); j++) {
			if(visited[data[i].get(j)]==0) {
				visited[data[i].get(j)]=1;
				if(tree[i][0]==0) {
					tree[i][0] = data[i].get(j);
				}else {
					tree[i][1] = data[i].get(j);
				}
				makeTree(data[i].get(j));
			}
		}
		
	}

}
