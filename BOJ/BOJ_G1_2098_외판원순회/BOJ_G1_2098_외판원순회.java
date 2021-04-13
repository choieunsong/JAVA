package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G1_2098_외판원순회 {
	static int N; 
	static int[][] map;
	static long[][] dp;
	static long min = Long.MAX_VALUE;
	static final long INF = 987654321L;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		
		StringTokenizer st = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		dp = new long[N][1 << N];
		long ans = TSP(0, 1);
		System.out.println(ans);
	}
	static long TSP(int cur, int flag) {
		if(flag == (1 << N) - 1) {
			if(map[cur][0] == 0)	return INF;	//시작점으로 갈 수 없음
			return map[cur][0];					// 시작점으로 갈 수 있음 		
		}
		if(dp[cur][flag] != 0)
			return dp[cur][flag];
		
		dp[cur][flag] = INF;
		for(int i = 0; i<N; i++) {
			if((flag & 1<<i) == 0 && map[cur][i] != 0) {
				dp[cur][flag] = Math.min(dp[cur][flag], TSP(i, flag | 1<<i) + map[cur][i]);
			}
		}
		return dp[cur][flag];
	}
}