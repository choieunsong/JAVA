package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  3109 빵집 (식당예제 실습) 
 * 백트래킹, dfs 
 * */

public class BOJ_G2_3109 {
	static int ans, R, C;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,0,1};
	static int[] dc = {1,1,1};
	static int cnt = 0;
	static boolean ansExist = false;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		for(int i=0; i < R; i++) {
			String line = in.readLine().trim();
			for(int j=0; j < C; j++)
				map[i][j] = line.charAt(j);
		}
		for(int i=0; i<R; i++) {
			ansExist = false;
			dfs(i,0);
		}
		
		System.out.println(cnt);
	}
	
	private static void dfs(int r, int c) {
		visited[r][c] = true; 
		if(c == C-1) {
			ansExist = true;
			cnt++;
			return;
		}
		for(int i=0; i<3; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(-1 < nr && nr < R && -1 < nc && nc < C) {
				if(!visited[nr][nc] && map[nr][nc] == '.') {
					dfs(nr, nc);
					if(ansExist)	return;
//					visited[nr][nc] 안해주는 이유:어차피 그 branch로 가봤자 답이 없다. 가지치기 해주기 
				}
			}
		}
	}

}
