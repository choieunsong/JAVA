package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
/**
 * 알파벳
 * 백트래킹, dfs 
 * */

public class BOJ_G4_1987 {
	static int R, C;
	static int[][] map;
	static boolean[] alpha; 
	static int max = Integer.MIN_VALUE;
	static int cnt = 1;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException, NumberFormatException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		alpha = new boolean[26];
		
		for(int i=0; i<R; i++) {
			String line = in.readLine();
			for(int j=0; j<C; j++)
				map[i][j] = line.charAt(j) - 65;
		}
		
		alpha[map[0][0]] = true; 
		dfs(0,0,1);
		System.out.println(max);
	}
	
	private static void dfs(int r, int c, int cnt) {
		max = Math.max(max, cnt);
		
		for(int i=0; i<4; i++) {	
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if(0<=nr && nr <R && 0<=nc && nc<C) {
				if(!alpha[map[nr][nc]]) {
					alpha[map[nr][nc]] = true;
					dfs(nr, nc, cnt+1);
					alpha[map[nr][nc]] = false;
				}
			}
		}
	}

}
