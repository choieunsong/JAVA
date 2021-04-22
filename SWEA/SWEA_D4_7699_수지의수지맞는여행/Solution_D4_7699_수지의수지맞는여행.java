package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7699_수지의수지맞는여행 {
	static int R, C, max;
	static char map[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static boolean[] alpha;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			
			for(int i=0; i<R; i++) {
				char[] ch = in.readLine().toCharArray();
				for(int j=0; j<C; j++) {
					map[i][j] = ch[j];
				}
			}
			alpha = new boolean[26];
			alpha[map[0][0] - 'A'] = true;
			max = 0;
			dfs(0, 0, 1);
			System.out.printf("#%d %d\n",t,max);
		}
	}
	static void dfs(int r, int c, int cnt) {
		max = Math.max(max, cnt);
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C)	continue;
			if(!alpha[map[nr][nc] - 'A']) {
				alpha[map[nr][nc] - 'A'] = true;
				dfs(nr, nc, cnt+1);
				alpha[map[nr][nc] - 'A'] = false;
			}
		}
	}
}
