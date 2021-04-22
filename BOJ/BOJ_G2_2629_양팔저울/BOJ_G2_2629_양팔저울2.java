package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G2_2629_양팔저울2 {
	static int weightNum, weight[];
	static boolean dp[][];
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		weightNum = Integer.parseInt(in.readLine());
		weight = new int[weightNum];
		dp = new boolean[weightNum+1][40001];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<weightNum; i++)
			weight[i] = Integer.parseInt(st.nextToken());
		
		dp(0, 0);
		int N = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(st.nextToken());
			boolean ans = false;
			for(int j=0; j<=weightNum; j++) {
				if(dp[j][n]) {
					ans = true;
					break;
				}
			}
			System.out.printf("%s ", ans ? "Y" : "N");
		}
		System.out.println();
	}
	
	static void dp(int idx, int sum) {
		if(idx == weightNum) {
			dp[idx][sum] = true;
			return;
		}
		if(dp[idx][sum]) {
			return;
		}
		dp[idx][sum] = true;
		dp(idx+1, sum + weight[idx]);
		dp(idx+1, sum);
		dp(idx+1, Math.abs(sum - weight[idx]));
	}
}

/*
4
2 3 3 3 
3
1 4 10
*/