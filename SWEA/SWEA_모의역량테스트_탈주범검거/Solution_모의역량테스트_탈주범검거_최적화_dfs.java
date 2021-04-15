package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_모의역량테스트_탈주범검거_최적화_dfs{
	static int N, M, L, R, C;
	static int[][] map;
	static int[][] visited;
//						상,좌,우,하
	static int[] dr = {-1,0,0,1};
	static int[] dc = {0,-1,1,0};	
	static String type[] = {
			null,
			"0312",	// 1: 상하좌우
			"03",	// 2: 상하
			"12",	// 3: 좌우
			"02",	// 4: 상우 
			"32",	// 5: 하우
			"31",	// 6: 하좌 
			"01"	// 7: 상좌  
	};
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new int[N][M];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					visited[i][j] = Integer.MAX_VALUE;		// 최소값 갱신을 위해 맥스값으로 초기화 
				}
			}
			System.out.printf("#%d %d\n",t, getCount());
		}
	}
	
	static int getCount() {
		int count = 0;
		
		dfs(R, C, 1);
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(visited[r][c] != Integer.MAX_VALUE)	++count;
			}
		}
		return count;
	}
	
	static void dfs(int r, int c, int time) {
		visited[r][c] = time;
		if(time == L)	return;
		
		String info = type[map[r][c]];		// 현 구조물의 타입으로 이동 가능한 방향의 정보 
		
		for(int d=0, length = info.length(); d<length; d++) {
			int dir = info.charAt(d) - '0';
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr >=0 && nr <N && nc >= 0 && nc < M && map[nr][nc] > 0 && visited[nr][nc] > time
					&& type[map[nr][nc]].contains(Integer.toString(3-dir))) {
				
				dfs(nr, nc, time+1);
			}
		}
	}
	
}
