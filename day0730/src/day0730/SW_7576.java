package day0730;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_7576 {

	static int N; //����
	static int M; //����
	static int box[][];
	static int visited[][];
	static Queue<int[]> start;
	
	static Queue<int[]> queue;
	                 //�� �� �� ��
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {-1, 0, 1, 0};
	static int day;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//M, N ������ �Է� ����
		while(st.hasMoreTokens()) {
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
		}
		
		//�迭 ���� �� �ʱ�ȭ
		box= new int[N][M];
		visited = new int[N][M];
		
		//�ڽ� �迭�� input data ����
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int j=0;
			while(st.hasMoreTokens()) {
				box[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
				
		}
		
		// ���� �丶�䰡 �������� ��� �ֱ� ������
		// �������� ���ҷ��ϴ� queue�� start ����
		start = new LinkedList<>();
		
		//�����丶�� ã���� start�� enQueue
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j]==1) {
					int tmp[] = {i, j};
					start.add(tmp);
				}
			}
		}
		
		//day�ʱ�ȭ �� �Լ� ȣ��
		day=0;
		bfs();
		
		//������ �丶�� �ϳ��� ������ -1ǥ�� ������ϱ� ������
		boolean flag=true;
		for(int ii=0; ii<N; ii++) {
			for(int jj=0; jj<M; jj++) {
				// bfs�� Ž�� ���� �丶�� ã����� ��
				// => �丶�䰡 ����ִ� ĭ �� bfs�� �湮 ���� ĭ
				if(box[ii][jj]==0 && visited[ii][jj]==0) {
					flag=false;
				}
			}
		}
		
		//������ �丶�� �ϳ��� ���� ���
		if(flag==false) {
			System.out.println(-1);
		
		// ������ ���
		}else {
			System.out.println(day);
		}
		
	}
	
	
	public static void bfs() {
		queue = new LinkedList<>();
		
		//�ʱ� ���� �丶�� �湮
		int startY=0; int startX=0;
		
		//�ʱ� ���� �丶�� ������ �ִ� start queue�� �ִ� ���Һ��� enQueue, visited ������
		while(!start.isEmpty()) {
			int tmp0[] = start.remove();
			queue.add(tmp0);
			startY=tmp0[0];
			startX=tmp0[1];
			visited[startY][startX]=1;
		}
		
		
		while(!queue.isEmpty()) {

			//queue depth ǥ�� ���� queue������� ���� ������
			int qsize = queue.size();
			for(int k=0; k<qsize; k++) {
				//�� ����v �ϳ� ��
				int tmp1[] = queue.remove();
				int vy = tmp1[0];
				int vx = tmp1[1];
				
				int ny; int nx;
				//�� ����v�� �̿�����n Ž��
				for(int index=0; index<4; index++) {
					ny = vy+dy[index];
					nx = vx+dx[index];
					
					//�ڽ� ���� �Ѿ�� continue
					if(ny<0 || nx<0 || ny>=N || nx>=M) {
						continue;
					}
					
					//�湮���߾��� ĭ��0�̸� visitedǥ��, enQueue
					if(visited[ny][nx]==0 && box[ny][nx]==0) {
						int tmp2[]= {ny, nx};
						queue.add(tmp2);
						visited[ny][nx]=1;
					}
					
				}
				
			}
			if(queue.isEmpty()) { //queue������� �ѹ��� Ȯ��. day++ ������
				return;
			}
			day++;

		}
		
	}
	
}
