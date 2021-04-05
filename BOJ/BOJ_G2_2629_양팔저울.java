package boj;

import java.util.Scanner;

public class BOJ_G2_2629_양팔저울 {
	static int chuNum;
	static int[] chu;
	static boolean[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		chuNum = sc.nextInt();
		chu = new int[chuNum+1];
		dp = new boolean[chuNum+1][40001];
				
		for(int i=0; i<chuNum; i++)	{
			chu[i] = sc.nextInt();
		}
		
		find(0, 0);
		
		StringBuilder sb = new StringBuilder();
		int marbleNum = sc.nextInt();
		for(int i = 0; i < marbleNum; i++) {
			int marble = sc.nextInt();
			boolean flag = false;
			for(int j=0; j <= chuNum; j++) {
				if(dp[j][marble]) { 
					sb.append("Y "); 
					flag = true;
					break;
				}
			}
			if(!flag)	sb.append("N ");
		}
		System.out.println(sb.toString());
	}
	static void find(int cnt, int weight) {
		if(cnt > chuNum)	return;
		if(dp[cnt][weight])	return;
		
		dp[cnt][weight] = true;
		
		find(cnt+1, weight + chu[cnt]);
		find(cnt+1, weight);
		find(cnt+1, Math.abs(weight - chu[cnt]));
	}
}

/*
4
2 3 3 3 
3
1 4 10
*/