package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 오목 
 * bfs, 백트랙킹
 * 하지만 IM 난이도기 때문에 for, while만 생각해도 됨
 * 우상, 우, 우하, 하   
 * */

public class Main_1733_최은송 {
	static int map[][] = new int[19][19];;
	static int[] dr = {-1,0,1,1};
	static int[] dc = {1,1,1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		for(int i=0; i<19; i++) {
			st = new StringTokenizer(in.readLine().trim(), " ");
			for(int j=0, end=st.countTokens(); j<end; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int color=0;
		for(int r=0; r<19; r++) {
			for(int c=0; c<19; c++) {
				if(map[r][c] != 0) {
					color = map[r][c] == 1 ? 1 : 2;
					if(check(r, c, color)) {
						System.out.println(color);
						System.out.printf("%d %d\n",r+1, c+1);
					}
				}
			}
		}
	}
	
	private static boolean check(int r, int c, int color) {
		for(int i = 0; i < 4; i++) {
			int cnt = 1;
			int nr = r +dr[i];
			int nc = r +dc[i];
			for(; nr < 19 && nc < 19;) {
				if(-1 < nr && nr < 19 && -1 < nc && nc < 19 && map[nr][nc] == color) {
					cnt++;
					nr += dr[i];
					nc += dc[i];
				}
				else {
					break;
				}
				if(cnt == 5)
					return true;
			}
		}
		return false;
	}

}
