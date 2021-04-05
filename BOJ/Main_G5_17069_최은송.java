package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_G5_17069_최은송 {
	static int N;
	static char[][] map;
	static long[][][] dp;
	static int[][] dir = {{0, -1}, {-1, 0}, {-1, -1}};
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new char[N][N];
		dp = new long[N][N][3];
		
		for(int i=0; i<N; i++)
			map[i] = in.readLine().replaceAll(" ", "").toCharArray();
		
		dp();
	}
	
	static void dp() {
		dp[0][1][0] = 1;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				fillDp(r, c);
			}
		}
		long answer = dp[N-1][N-1][0] + dp[N-1][N-1][1] +dp[N-1][N-1][2];
		System.out.println(answer);
	}
	
	static void fillDp(int r, int c) {
		if(map[r][c] == '1') return;
		
		// 가로, 세로 방향일 때 
		int nr, nc;
		for(int d = 0; d < 2; d++) {
			nr = r + dir[d][0];
			nc = c + dir[d][1];
			if(nr < 0 || nc < 0 || map[nr][nc] == '1')	continue;
			dp[r][c][d] += dp[nr][nc][d];
			dp[r][c][d] += dp[nr][nc][2];
		}
		// 대각선 방향일 때 체크 
		boolean flag = true;
		for(int d = 0; d < 3; d++) {
			nr = r + dir[d][0];
			nc = c + dir[d][1];
			if(nr < 0 || nc < 0 || map[nr][nc] == '1') {
				flag = false;
				break;
			}
		}
		if(flag) {
			for(int d = 0; d < 3; d++) {
				nr = r + dir[2][0];
				nc = c + dir[2][1];
				dp[r][c][2] += dp[nr][nc][d];
			}
		}
	}
}
