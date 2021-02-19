package swea;

import java.util.Arrays;
import java.util.Scanner;

/**
 * SWEA D4 7208 지도 칠하기 
 * */

public class Solution_D4_7208_최은송 {
	
	static int N;
	static int map[][];
	static int color[];
	static int permu[];
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		
		for(int tc = 1; tc<= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			color = new int[N];
			permu = new int[N];
			for(int i=0; i<N; i++) {
				color[i] = sc.nextInt();
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			min = Integer.MAX_VALUE;
			find(0);
			System.out.printf("#%d %d\n", tc, min);
			
		}
		
	}
	
	private static boolean check() {
		for(int r=0; r<N; r++) {
			for(int c=r+1; c<N; c++) {
				if(map[r][c] == 1 && permu[r] == permu[c]) {
					return false;
				}
			}
		}
		return true;
	}
		
	private static void find(int cnt) {
		if(cnt == N) {
			//중복이 있으면 return
			if(check()) {
				//중복이 없는경우 
				int diff = 0;
				for(int i=0; i<N; i++) {
					if(color[i] != permu[i])
						diff++;
				}
				min = Math.min(min, diff);
			}
			return;
		}
		
		for(int i=1; i<5; i++) {
			permu[cnt] = i;
			find(cnt + 1);
		}
	}


}
