package day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {

	static int N;
	static int M;
	static int V;
	static int a[][];
	static int visited[];
	static Queue<Integer> queue;
	
	static String result1;
	static String result2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=0; //������ ����
		M=0; //������ ����
		V=0; //Ž���� ���� ��ȣ
		while(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
		}
		
		//������� ����
		a = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int v = Integer.parseInt(st.nextToken());
				int w =  Integer.parseInt(st.nextToken());
				a[v][w] = 1;
				a[w][v] = 1;
				
			}
		}
		
		visited = new int[N+1];
		result1="";
		dfs(V);

		
		queue = new LinkedList<>();
		visited = new int[N+1];
		result2="";
		bfs(V);
		
		System.out.println(result1);
		System.out.println(result2);
		br.close();

	}
	
	public static void bfs(int start) {
		queue.add(start);
		visited[start]=1;
		result2 += String.valueOf(start);
		
		int v=0;//����
		int w=0;//�̿���
		while(!queue.isEmpty()) {
			
			//ť �Ǿ� ���� �ϳ� ����
			v = queue.remove();
				
			//�� ������ ���� �̿��� Ž��
			for(int j=0; j<N+1; j++) {
				
				//���ǿ� �´� �̿��� ������
				if(a[v][j]==1 && visited[j]==0) {
					w = j;
					
					//enQueue, �湮 ǥ��
					queue.add(w);
					visited[w]=1;
					result2+= " "+String.valueOf(w);
				}
			}
		}
	}
	
	public static void dfs(int v) {
		visited[v]=1;
		result1 += String.valueOf(v)+" ";
		
		for(int j=0; j<N+1; j++) {
			//���� �´� �̿�ã����
			if(visited[j]==0 && a[v][j]==1) {
				dfs(j);
			}
		}
	}
	
}
