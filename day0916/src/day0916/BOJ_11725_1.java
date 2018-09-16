package day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725_1 {
	static int N;
	
	static ArrayList<Integer> data[];
	static int parents[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parents = new int[N+1];
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
		
		//1의 부모는 0
		findParents(1, 0);
		for(int i=2; i<parents.length; i++) {
			System.out.println(parents[i]);
		}
		
	}
	
	public static void findParents(int child, int parent) {
		
		parents[child] = parent;
		for(int i=0; i<data[child].size(); i++) {
			
			//child와 연결된 노드중에 부모아니면(자식인거임)
			if(data[child].get(i)!=parent) {
				//child의 자식과, child를 부모로 하여 재귀
				findParents(data[child].get(i), child);
			}
		}
		
	}

}
