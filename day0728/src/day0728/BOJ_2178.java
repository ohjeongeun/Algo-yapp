package day0728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
N��Mũ���� �迭�� ǥ���Ǵ� �̷ΰ� �ִ�.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
�̷ο��� 1�� �̵��� �� �ִ� ĭ�� ��Ÿ����, 0�� �̵��� �� ���� ĭ�� ��Ÿ����. 
�̷��� �̷ΰ� �־����� ��, (1, 1)���� ����Ͽ� (N, M)�� ��ġ�� �̵��� �� ������ �ϴ� �ּ��� ĭ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
���� �������� 15ĭ�� ������ (N, M)�� ��ġ�� �̵��� �� �ִ�. ĭ�� �� ������ ���� ��ġ�� ���� ��ġ�� �����Ѵ�.

�Է�
4 6
101111
101010
101011
111011

���
15
*/

public class BOJ_2178 {

	static int N;
	static int M;
	static int map[][];
	static int visited[][];
	static Queue<int[]> queue;
					// ��     ��     ��     ��  
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken()); //����
			M = Integer.parseInt(st.nextToken()); //����
		}
		
		map = new int[N][M];
		visited = new int[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		bfs(0, 0);
		System.out.println(map[N-1][M-1]);
		
	}
	
	
	public static void bfs(int i, int j) {
		//Create queue
		queue = new LinkedList<>();
		
		//ù ���� y��ǥ, x��ǥ
		int tmp[]= {i, i};
		
		//ù ���� enQueue, visitedǥ��
		queue.add(tmp);
		visited[i][j] = 1;
		
		
		//����v �� y��ǥ, x��ǥ 
		int vy; int vx;

		//queue ������� ���� ����
		while(!queue.isEmpty()) {
			
			//queue�� ù ���� ��
			int tmp1[] = queue.remove();
			vy=tmp1[0];
			vx=tmp1[1];
			
			int ny; int nx;
			//v�� �̿����� ����n Ž��
			for(int index=0; index<4; index++) {

				//����n
				ny = vy+dy[index];
				nx = vx+dx[index];
				
				//map[N][X] ���� ���� �ʵ��� (���� ������ continue)
				if(ny<0 || nx<0 || ny==N || nx==M) {
					continue;
				}
				
				//����n�� not visited�̰�, ��(1)�̸� enQueue, visitedǥ��
				if(visited[ny][nx]==0 && map[ny][nx]==1) {
					int tmp2[] = {ny, nx};
					queue.add(tmp2);
					visited[ny][nx]=1;
					
					
					map[ny][nx] = map[vy][vx]+1;
					
					/*//ã�� �����̸� ����
					if(ny==N-1 && nx==M-1) {
						return;
					}*/
				
				}
				
			}
			
		}
		
	}
	

}
