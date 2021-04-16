package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_모의역량테스트_등산로조성 {
	static int N, K, map[][], max;
	static boolean visited[][];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			int maxHeight = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] >= maxHeight) {
						maxHeight = map[i][j];
					}
				}
			}
			
			// 봉우리 넣어주기 
			max = Integer.MIN_VALUE;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == maxHeight) {
						visited = new boolean[N][N];
						visited[i][j] = true;
						dfs(maxHeight, i, j, 1, 1);
						visited[i][j] = false;
					}
				}
			}
			System.out.printf("#%d %d\n",t,max);
		}
	}
	// cnt 1: 공사가능, 0 : 공사불가능  
	static void dfs(int height, int r, int c, int cnt, int dist) {
		max = Math.max(max, dist);
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc]) {
				visited[nr][nc] = true;
				if(map[nr][nc] < height) {
					dfs(map[nr][nc], nr, nc, cnt, dist+1);
				}else if(map[nr][nc] >= height && map[nr][nc] - K < height && cnt == 1) {
					dfs(height-1, nr, nc, cnt-1, dist+1);
				}
				visited[nr][nc] = false;
			}
		}
	}
}
