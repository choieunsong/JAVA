package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_5215_최은송 {
	static int N;
	static int L;
	static int max;
	static int[][] hamburger;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			hamburger = new int[N][2];
			max = Integer.MIN_VALUE;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				hamburger[i][0] = Integer.parseInt(st.nextToken());
				hamburger[i][1] = Integer.parseInt(st.nextToken());
			}
			find(0,0,0);
			System.out.printf("#%d %d\n",tc,max);
		}
	}
	
	public static void find(int cnt, int calrorie, int flag) {
		if(cnt == N) {
			if(calrorie <= L) {
				int sum = 0;
				for(int i=0; i<N; i++) {
					if((flag & 1<<i) != 0) {
						sum += hamburger[i][0];
					}
				}
				max = Math.max(max, sum);
			}
			return;
		}
		
		calrorie += hamburger[cnt][1];
		find(cnt + 1, calrorie, flag | 1<<cnt);
		calrorie -= hamburger[cnt][1];
		find(cnt + 1, calrorie, flag);	
	}
}
