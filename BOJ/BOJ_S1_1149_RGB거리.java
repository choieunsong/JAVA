package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_1149_RGB거리 {
	
	static int N;
	static int[][] house;
	static long[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		dp = new long[N][3];
		house = new int[N][3];
		StringTokenizer st = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			house[i][0] = Integer.parseInt(st.nextToken());
			house[i][1] = Integer.parseInt(st.nextToken());
			house[i][2] = Integer.parseInt(st.nextToken());
		}
		dp();
	}
	
	static void dp() {
		dp[0][0] = house[0][0];
		dp[0][1] = house[0][1];
		dp[0][2] = house[0][2];
		for(int i=1; i < N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + house[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + house[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + house[i][2];
		}
		long temp = Math.min(dp[N-1][0], dp[N-1][1]);
		long result = Math.min(temp, dp[N-1][2]);
		System.out.println(result);
	}

}
