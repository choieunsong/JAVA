package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * 오목 
 * bfs, 백트랙킹
 * 하지만 IM 난이도기 때문에 for, while만 생각해도 됨
 * 우상, 우, 우하, 하   
 * */

public class Main_1733_오목_최은송 {
	static int map[][] = new int[19][19];
	static int[] dr = {-1,0,1,1};
	static int[] dc = {1,1,1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(input));
		
		StringTokenizer st;
		for(int i=0; i<19; i++) {
			String line = in.readLine().trim();
			for(int j=0, k=0; j<19; j++, k+= 2)
				map[i][j] = line.charAt(k) - '0';
		}
		
		int ans = 0, ansR = 0, ansC = 0;
		top:for(int r=0; r<19; r++) {
			for(int c=0; c<19; c++) {
				if(map[r][c] != 0) {
					for(int i=0; i<4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if(nr < 0 || nr >= 19 || nc < 0 || nc >= 19 || map[nr][nc] != map[r][c]) continue;
						
						int prevR = r-dr[i];
						int prevC = c-dc[i];
						if(-1 < prevR && prevR < 19 && -1 < prevC && prevC < 19 && map[r][c] == map[prevR][prevC])	continue;	//육목체크 
						
						int cnt = 1;
						while(-1 < nr && nr < 19 && -1 < nc && nc < 19 && map[r][c] == map[nr][nc] && cnt <= 5) {
							cnt++;
							nr += dr[i];
							nc += dc[i];
						}
						if(cnt == 5) {
							ans = map[r][c];
							ansR = r+1;
							ansC = c+1;
							break top;
						}
					}
				}
			}
		}
		if(ans != 0)
			System.out.printf("%d \n%d %d\n",ans, ansR, ansC);
		else
			System.out.println(0);
		
	}
	static String input="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 1 2 0 0 2 2 2 1 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 1 2 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 1 2 2 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 1 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 2 1 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0";

}
