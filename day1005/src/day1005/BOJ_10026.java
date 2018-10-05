package day1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026 {
	static int N;
	static String map[][];
	static int visited[][];
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	static Queue<Node> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new String[N][N];
		visited = new int[N][N];
		String s="";
		for(int i=0; i<N; i++) {
			s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = Character.toString(s.charAt(j));
			}
			
		}
		
		q = new LinkedList<>();
		int d=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]==0) {
					Dbfs(i, j);
					d++;
				}
			}
		}
		
		visited = new int[N][N];
		int c=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]==0) {
					bfs(i, j);
					c++;
				}
			}
		}
		
		System.out.println(c+" "+d);
		
		
		
	}
	
	public static void bfs(int y, int x) {
		q.add(new Node(y, x));
		visited[y][x]=1;
		
		
		while(!q.isEmpty()) {
			int cury = q.peek().y;
			int curx = q.peek().x;
			q.remove();
			
			for(int i=0; i<4; i++) {
				int ny = cury+dy[i];
				int nx = curx+dx[i];
				
				if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
				
				if(visited[ny][nx]==1) continue;
				
				//같으면 넣기
				if(map[ny][nx].equals(map[cury][curx])) {
					q.add(new Node(ny, nx));
					visited[ny][nx]=1;
				}
			}
		}
	}
	
	
	public static void Dbfs(int y, int x) {
		q.add(new Node(y, x));
		visited[y][x]=1;
		
		
		while(!q.isEmpty()) {
			int cury = q.peek().y;
			int curx = q.peek().x;
			q.remove();
			
			for(int i=0; i<4; i++) {
				int ny = cury+dy[i];
				int nx = curx+dx[i];
				
				if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
				
				if(visited[ny][nx]==1) continue;
				
				//적 or 록 이면
				if(map[cury][curx].equals("R") || map[cury][curx].equals("G")) {
					if(map[ny][nx].equals("R") || map[ny][nx].equals("G")) {
						q.add(new Node(ny, nx));
						visited[ny][nx]=1;
					}else {
						continue;
					}
					
					
				}else {
					
					//같지 않으면 
					if(!map[ny][nx].equals(map[cury][curx])) {
						continue;
						
					//같으면 넣고
					}else {
						q.add(new Node(ny, nx));
						visited[ny][nx]=1;
					}
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
