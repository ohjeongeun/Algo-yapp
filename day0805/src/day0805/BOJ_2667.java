package day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2667 {
	static int N;
	static int map[][];
	static int visited[][];
					//우 하 좌 상
	static int dy[]= {0, 1, 0, -1};
	static int dx[]= {1, 0, -1, 0};
	
	static int nHouse;
	static int nDanji;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//지도크기
		N = Integer.parseInt(br.readLine());
		
		//지도배열, 방문배열 생성
		map = new int[N][N];
		visited = new int[N][N];
		
		//지도배열 데이터 입력
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		//단지수
		nDanji=0;
		//답 배열
		int answer[] = new int[N*N];
		//답 배열 인덱스
		int k=0;
		
		//지도에서 집(1)찾음
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				//집(1)이고 방문한적 없으면
				if(map[i][j]==1 && visited[i][j]==0) {
					nHouse=0;
					//dfs돌림
					dfs(i, j);
					
					//dfs돌리고 나서 단지수 추가
					nDanji++;
					
					//답 배열에 단지 내, 집의 수 입력
					answer[k]=nHouse;
					k++;
				}
			}
		}
		
		//단지 수 출력
		System.out.println(nDanji);
		
		//각 단지 내 집의 수 오름차순 정렬 후 출력
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
		
		//방향탐색
		for(int i=0; i<4; i++) {
			int ny = vy + dy[i];
			int nx = vx + dx[i];
			
			//map범위 넘으면 continue
			if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
			
			//방문한적 없고 집(1)이면 재귀
			if(map[ny][nx]==1 && visited[ny][nx]==0) {
				dfs(ny, nx);
			}
		}
	}
}
