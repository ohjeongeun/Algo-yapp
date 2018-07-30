package day0728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 
이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

입력
4 6
101111
101010
101011
111011

출력
15
*/

public class BOJ_2178 {

	static int N;
	static int M;
	static int map[][];
	static int visited[][];
	static Queue<int[]> queue;
					// 우     하     좌     상  
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken()); //세로
			M = Integer.parseInt(st.nextToken()); //가로
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
		
		//첫 정점 y좌표, x좌표
		int tmp[]= {i, i};
		
		//첫 정점 enQueue, visited표시
		queue.add(tmp);
		visited[i][j] = 1;
		
		
		//정점v 의 y좌표, x좌표 
		int vy; int vx;

		//queue 비어있지 않은 동안
		while(!queue.isEmpty()) {
			
			//queue의 첫 원소 뺌
			int tmp1[] = queue.remove();
			vy=tmp1[0];
			vx=tmp1[1];
			
			int ny; int nx;
			//v의 이웃정점 정점n 탐색
			for(int index=0; index<4; index++) {

				//정점n
				ny = vy+dy[index];
				nx = vx+dx[index];
				
				//map[N][X] 범위 넘지 않도록 (범위 넘으면 continue)
				if(ny<0 || nx<0 || ny==N || nx==M) {
					continue;
				}
				
				//정점n이 not visited이고, 길(1)이면 enQueue, visited표시
				if(visited[ny][nx]==0 && map[ny][nx]==1) {
					int tmp2[] = {ny, nx};
					queue.add(tmp2);
					visited[ny][nx]=1;
					
					
					map[ny][nx] = map[vy][vx]+1;
					
					/*//찾는 정점이면 리턴
					if(ny==N-1 && nx==M-1) {
						return;
					}*/
				
				}
				
			}
			
		}
		
	}
	

}
