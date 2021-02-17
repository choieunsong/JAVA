package swea;

import java.util.Arrays;
import java.util.Scanner;

/**
 * SWEA D2 2001 파리퇴치 최은송 
 * */

public class SWEA2001 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int testCase=1; testCase<=T; testCase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int map[][] = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0, idx=0; j<N; j++, idx+=2) {
					map[i][j] = sc.nextInt();
				}
			}
	
			int max=0, sum=0;
			for(int r=0; r < N-M+1; r++) {
				for(int c=0; c < N-M+1; c++) {
					
					for(int y=0; y<M; y++) {
						for(int x=0; x<M; x++) {
							sum += map[r+y][c+x];
						}
					}
					if(sum > max) max = sum;
					sum = 0;
				}
			}
			System.out.printf("#%d %d\n", testCase, max);
		}

	}

}
