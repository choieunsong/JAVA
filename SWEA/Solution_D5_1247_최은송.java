package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 최적 경로 
 * 백트래킹, 순열  
 * */

public class Solution_D5_1247_최은송 {
	static int N;
	static int[][] cust;		//cust[N][0]: x, cust[N][1]:y
	static int min;
	static int[] order;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(in.readLine());
			cust = new int[N+2][2];
			order = new int[N+2];
			min = Integer.MAX_VALUE;
			
			StringTokenizer st = new StringTokenizer(in.readLine().trim(), " ");
			cust[0][0] = Integer.parseInt(st.nextToken());
			cust[0][1] = Integer.parseInt(st.nextToken());
			cust[N+1][0] = Integer.parseInt(st.nextToken());
			cust[N+1][1] = Integer.parseInt(st.nextToken());
			
			for(int i=1; i<=N; i++) {
				cust[i][0] = Integer.parseInt(st.nextToken());
				cust[i][1] = Integer.parseInt(st.nextToken());
			}
			order[0] = 0;
			order[N+1] = N+1;
			//permutation(1, 0);
			dfs(1,0,0);
			System.out.printf("#%d %d\n",tc,min);
		}
	}
	//순열로 풀기
	private static void permutation(int cnt, int flag) {
		if(cnt == N+1) {
			int sum = 0;
			for(int i=0; i<N+1; i++) {
				sum += Math.abs(cust[order[i]][0] - cust[order[i+1]][0]) + Math.abs(cust[order[i]][1] - cust[order[i+1]][1]);
			}
			min = Math.min(sum, min);
			return;
		}
		for(int i=1; i<N+1; i++) {
			if((flag & 1<<i) != 0)	continue;
			order[cnt] = i;
			permutation(cnt+1, flag | 1<<i);
		}
	}
	//백트래킹으로 풀기 
	private static void dfs(int cnt, int dist, int flag) {
		if(dist > min)	return;
		if(cnt == N+1) {
			dist += Math.abs(cust[order[cnt]][0] - cust[order[cnt-1]][0]) + Math.abs(cust[order[cnt]][1] - cust[order[cnt-1]][1]);
			min = Math.min(dist, min);
			return;
		}
		for(int i=1; i<N+1; i++) {
			if((flag & 1<<i) != 0) 	continue;
			order[cnt] = i;
			int d = Math.abs(cust[order[cnt]][0] - cust[order[cnt-1]][0]) + Math.abs(cust[order[cnt]][1] - cust[order[cnt-1]][1]);
			dfs(cnt+1, dist+d, flag | 1<<i);
		}
	}
}
