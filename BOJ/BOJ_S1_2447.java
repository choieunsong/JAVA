package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2447 별찍기 - 10
 * */

public class BOJ_S1_2447 {
	static char[][] map; 
			
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new char[N][N];
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				map[i][j] = ' ';
		
		paint(N, 0, 0);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++)
				sb.append(map[i][j]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	private static void paint(int n, int r, int c) {
		if(n == 1) {
			map[r][c] = '*';
			return;
		}
		int n3 = n / 3;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(i == 1 && j == 1)	continue;
				paint(n3, r + i*n3, c + j*n3);
			}
		}
	}
}
