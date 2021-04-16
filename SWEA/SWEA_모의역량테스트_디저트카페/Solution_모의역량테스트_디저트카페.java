package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_모의역량테스트_디저트카페 {
	static int N, map[][], max;
	static boolean[] used;
	static int startR, startC;
	static int dr[] = {1,1,-1,-1};
	static int dc[] = {1,-1,-1,1};

	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(in.readLine().trim());
			map = new int[N][N];
			used = new boolean[101];
			
			StringTokenizer st = null;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j <N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = -1;
			for(int r = 0; r <N-2; r++) {
				for(int c = 1; c <N-1; c++) {
					startR = r;
					startC = c;
					used[map[r][c]] = true;
					dfs(r, c, 0, 1);
					used[map[r][c]] = false;
				}
			}
			System.out.printf("#%d %d\n", t, max);
		}
	}
	
	static void dfs(int r, int c, int d, int typeCnt) {
		// 현재 방향에 머물러 있거나, 다음 방향으로 가기 
		for(int i = 0; i < 2; i++) {
			// 만약 3번 선을 그리고 있으면 방향전환 하면 안됨 
			if(d + i == 4) {
				continue;
			}
			
			d = (d + i) % 4;
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 경계체크 
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
				continue;
			}
			if(nr == startR && nc == startC) {
				max = Math.max(typeCnt, max);
				return;
			}
			if(used[map[nr][nc]]) {
				continue;
			}
			used[map[nr][nc]] = true;
			dfs(nr, nc, d, typeCnt+1);
			used[map[nr][nc]] = false;
		}
	}
}
