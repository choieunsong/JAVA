package boj;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_B1_2839_설탕배달_dp {
	static int min = Integer.MAX_VALUE; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] dp = new int[5001];
		Arrays.fill(dp, 5000);
		dp[1] = dp[3] = dp[5] = 1;
		for(int i=6; i<=N; i++) {
			dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
		}
		int ans = dp[N] >= 5000 ? -1 : dp[N];
		System.out.println(ans);
	}
}
