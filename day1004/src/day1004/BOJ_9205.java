package day1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205 {
	static int T;
	static int N;
	static int map[][];
	static int visited[][];
	static Queue<Node> q;
	
	static int dx[] = {50, 0, -50, 0};
	static int dy[] = {0, 50, 0, -50};
	static int fentaY;
	static int fentaX;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine()); //편의점 개수
						
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int homeY = Integer.parseInt(st.nextToken());
			int homeX = Integer.parseInt(st.nextToken());
			
			
			ArrayList<Node> list = new ArrayList<>();
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				list.add(new Node(y, x, 0));
			}
			
			st = new StringTokenizer(br.readLine());
			fentaY = Integer.parseInt(st.nextToken());
			fentaX = Integer.parseInt(st.nextToken());
			
			map = new int[fentaY+1][fentaX+1];
			visited = new int[fentaY+1][fentaX+1];
			
			for(int i=0; i<N; i++) {
				int y = list.get(i).y;
				int x = list.get(i).x;
				map[y][x]=2; //편의점 표식
			}
			
			q = new LinkedList<>();
			bfs(homeY,homeX);
			
		}
	}
	
	
	public static void bfs(int y, int x) {
		q.add(new Node(y, x, 20));
		visited[y][x]=1;
		
		while(!q.isEmpty()) {
			int cury = q.peek().y;
			int curx = q.peek().x;
			int curnum = q.peek().num;
			
			if(cury==fentaY && curx==fentaX) {
				if(curnum<0) {
					System.out.println("sad");
				}else {
					System.out.println("happy");
				}
			}
			
			
			q.remove();
			
			for(int i=0; i<4; i++) {
				int ny = cury+dy[i];
				int nx = curx+dx[i];
				
				if(ny<0 || nx<0 || ny>fentaY || nx>fentaX) continue;
				
				if(visited[ny][nx]==1) continue;
				
				if(map[ny][nx]==2) {
					q.add(new Node(ny, nx, 20));
					visited[ny][nx]=1;
				}
				
				if(map[ny][nx]==0) {
					q.add(new Node(ny, nx, curnum-1));
					visited[ny][nx] = 1;
				}
			}
			
		}
	}
}

class Node {
	int y, x, num;
	public Node(int y, int x, int num) {
		this.y = y;
		this.x = x;
		this.num = num;
	}
	
}
