package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S3_1463_1로만들기 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
//		int[] dp = new int[1000001];
//		
//		for(int i=2; i<=N; i++) {			
//			int min = Integer.MAX_VALUE;
//			if(i % 3 == 0 && dp[i/3] < min)	min = dp[i/3] + 1;
//			if(i % 2 == 0 && dp[i/2] < min)	min = dp[i/2] + 1;
//			if(dp[i-1] < min)				min = dp[i-1] + 1;
//			dp[i] = min;
//		}
//		System.out.println(dp[N]);
		
		int[] memo = new int[N+1];
		
		for(int i=2; i<=N; i++) {
			memo[i] = memo[i-1] + 1;
			if(i%2 == 0)
				memo[i] = Math.min(memo[i],  memo[i/2] +1);
			if(i%3 == 0)
				memo[i] = Math.min(memo[i],  memo[i/3] +1);
		}
		System.out.println(memo[N]);
	}

}
