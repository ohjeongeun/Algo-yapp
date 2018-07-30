package day0730;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_7576 {

	static int N; //세로
	static int M; //가로
	static int box[][];
	static int visited[][];
	static Queue<int[]> start;
	
	static Queue<int[]> queue;
	                 //상 우 하 좌
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {-1, 0, 1, 0};
	static int day;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
		}
		
		box= new int[N][M];
		visited = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int j=0;
			while(st.hasMoreTokens()) {
				box[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
				
		}
		
		start = new LinkedList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j]==1) {
					int tmp[] = {i, j};
					start.add(tmp);
				}
			}
		}
		
		day=0;
		bfs();
		
		boolean flag=true;
		for(int ii=0; ii<N; ii++) {
			for(int jj=0; jj<M; jj++) {
				if(box[ii][jj]==0 && visited[ii][jj]==0) {
					flag=false;
				}
			}
		}
		if(flag==false) {
			System.out.println(-1);
		}else {
			System.out.println(day);
		}
		
		
	}
	
	
	
	public static void bfs() {
		queue = new LinkedList<>();
		
		//시작점 방문
		int startY=0; int startX=0;
		while(!start.isEmpty()) {
			int tmp0[] = start.remove();
			queue.add(tmp0);
			startY=tmp0[0];
			startX=tmp0[1];
			visited[startY][startX]=1;
		}
		
		
		while(!queue.isEmpty()) {

			int qsize = queue.size();
			for(int k=0; k<qsize; k++) {
				//앞 정점 하나 뺌
				int tmp1[] = queue.remove();
				int vy = tmp1[0];
				int vx = tmp1[1];
				
				int ny; int nx;
				//뺀 정점의 이웃정점 탐색
				for(int index=0; index<4; index++) {
					ny = vy+dy[index];
					nx = vx+dx[index];
					
					//박스 범위 넘어가면 continue
					if(ny<0 || nx<0 || ny>=N || nx>=M) {
						continue;
					}
					
					//방문안했었고 칸이0이면 visited표시, enQueue
					if(visited[ny][nx]==0 && box[ny][nx]==0) {
						int tmp2[]= {ny, nx};
						queue.add(tmp2);
						visited[ny][nx]=1;
					}
					
					
				}
				
			}
			if(queue.isEmpty()) {
				return;
			}
			day++;

		}
		
		
	}
	

}
