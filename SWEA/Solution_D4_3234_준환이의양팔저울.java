package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 준환이의 양팔저울 
 * dfs, 백트래킹 
 * */

public class Solution_D4_3234_최은송 {
	static int cnt;
	static int N;
	static int[] w;
	static int[] pw;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(in.readLine());
			w = new int[N];
			pw = new int[N];
			cnt = 0;
			
			StringTokenizer st = new StringTokenizer(in.readLine().trim(), " ");
			for(int i=0; i<N; i++) {
				w[i] = Integer.parseInt(st.nextToken());
			}
			
			permu(0,0);
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}
	
	private static void permu(int idx, int flag) {
		if(idx == N) {
			dfs(0,0,0);
			return;
		}
		for(int i=0; i<N; i++) {
			if((flag & 1<<i) !=0) continue;
			pw[idx] = w[i];
			permu(idx+1, flag | 1<<i);
		}
	}
	
	private static void dfs(int idx, int left, int right) {
		if(left < right)
			return;
		if(idx == N) {
			cnt++;
			return;
		}
		dfs(idx+1, left + pw[idx], right);
		dfs(idx+1, left, right + pw[idx]);
	}

}

