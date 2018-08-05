package day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012 {
	static int T;//�׽�Ʈ���̽� ����
	static int M;//���߹� ���α���
	static int N;//���߹� ���α���
	static int K;//���� �ɾ��� ��ġ ����
	static int Y;
	static int X;
					//�� �� �� ��
	static int dy[]= {0, 1, 0, -1};
	static int dx[]= {1, 0, -1, 0};
	static int map[][];
	static int visited[][];
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				M = Integer.parseInt(st.nextToken());
				N = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
			}
			
			map = new int[N][M];
			visited = new int[N][M];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens()) {
					X = Integer.parseInt(st.nextToken());
					Y = Integer.parseInt(st.nextToken());
					map[Y][X] = 1;
				}
			}
			
			cnt=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==1 && visited[i][j]==0) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
			
		}
	
	}
	
	public static void dfs(int vy, int vx) {
		visited[vy][vx]=1;
		//����Ž��
		for(int i=0; i<4; i++) {
			int ny = vy + dy[i];
			int nx = vx + dx[i];
			
			//map���� ������ continue
			if(ny<0 || nx<0 || ny>=N || nx>=M) continue;
			
			//�湮���� ���� ��(1)�̸� ���
			if(map[ny][nx]==1 && visited[ny][nx]==0) {
				dfs(ny, nx);
			}
		}
	}
}
