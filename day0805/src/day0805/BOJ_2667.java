package day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2667 {
	static int N;
	static int map[][];
	static int visited[][];
					//�� �� �� ��
	static int dy[]= {0, 1, 0, -1};
	static int dx[]= {1, 0, -1, 0};
	
	static int nHouse;
	static int nDanji;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//����ũ��
		N = Integer.parseInt(br.readLine());
		
		//�����迭, �湮�迭 ����
		map = new int[N][N];
		visited = new int[N][N];
		
		//�����迭 ������ �Է�
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		//������
		nDanji=0;
		//�� �迭
		int answer[] = new int[N*N];
		//�� �迭 �ε���
		int k=0;
		
		//�������� ��(1)ã��
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				//��(1)�̰� �湮���� ������
				if(map[i][j]==1 && visited[i][j]==0) {
					nHouse=0;
					//dfs����
					dfs(i, j);
					
					//dfs������ ���� ������ �߰�
					nDanji++;
					
					//�� �迭�� ���� ��, ���� �� �Է�
					answer[k]=nHouse;
					k++;
				}
			}
		}
		
		//���� �� ���
		System.out.println(nDanji);
		
		//�� ���� �� ���� �� �������� ���� �� ���
		Arrays.sort(answer);
		for(int i=0; i<answer.length; i++) {
			if(answer[i]!=0) {
				System.out.println(answer[i]);
			}
		}
	}
	
	public static void dfs(int vy, int vx) {
		visited[vy][vx]=1;
		nHouse++;
		
		//����Ž��
		for(int i=0; i<4; i++) {
			int ny = vy + dy[i];
			int nx = vx + dx[i];
			
			//map���� ������ continue
			if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
			
			//�湮���� ���� ��(1)�̸� ���
			if(map[ny][nx]==1 && visited[ny][nx]==0) {
				dfs(ny, nx);
			}
		}
	}
}
