package day1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963 {
	static int w;//너비
	static int h;//높이
	static int map[][];
	static int visited[][];
					// 우   하     좌     상  좌상대 우상대 우하대 좌하대
	static int dx[] = {1, 0, -1, 0, -1, 1, 1, -1};
	static int dy[] = {0, 1, 0, -1, -1, -1, 1, 1};
	static Queue<Node> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			String input = br.readLine();
			
			if(input.equals("0 0")) {
				return;
				
			}else {
				
				StringTokenizer st = new StringTokenizer(input);
				
				w = Integer.parseInt(st.nextToken());
				h = Integer.parseInt(st.nextToken());
				
				map = new int[h][w];
				visited = new int[h][w];
				
				for(int i=0; i<h; i++) {
					st = new StringTokenizer(br.readLine());
					for(int j=0; j<w; j++) {
						map[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				
				//출력Test
				/*for(int i=0; i<h; i++) {
					for(int j=0; j<w; j++) {
						System.out.print(map[i][j]);
					}
					System.out.println();
				}
				System.out.println();*/
				
				int cnt=0;
				q = new LinkedList<>();
				for(int i=0; i<h; i++) {
					for(int j=0; j<w; j++) {
						if(visited[i][j]==0 && map[i][j]==1) {
							bfs(i, j);
							cnt++;
						}
					}
				}
				
				System.out.println(cnt);
				
			}
		}
	}
	
	public static void bfs(int y, int x) {
		q.add(new Node(y, x));
		visited[y][x]=1;
		
		while(!q.isEmpty()) {
			int cury = q.peek().y;
			int curx = q.peek().x;
			q.poll();
			
			for(int i=0; i<8; i++) {
				int ny = cury+dy[i];
				int nx = curx+dx[i];
				
				if(ny<0 || nx<0 || ny>=h || nx>=w) continue;
				
				if(visited[ny][nx]==1) continue;
				
				if(map[ny][nx]==1) {
					q.add(new Node(ny, nx));
					visited[ny][nx]=1;
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
