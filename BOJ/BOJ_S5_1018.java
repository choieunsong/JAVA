package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 백준 S5 체스판 다시 칠하기 
 * */

public class BOJ_S5_1018 {
	static char[][] w_board = {
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'}
	};
	
	static char[][] b_board = {
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		
		for(int i=0; i<N; i++) {
			String line = in.readLine();
			for(int j=0; j<M; j++)
				map[i][j] = line.charAt(j);
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i+8 <= N; i++) {
			for(int j=0; j+8 <= M; j++) {
				
				int wcnt = 0, bcnt = 0;
				//흰색으로 시작할 때 
				for(int r = i; r < i+8; r++) {
					for(int c = j; c < j+8; c++) {
						if(map[r][c] != w_board[r-i][c-j])
							wcnt++;
					}
				}
				
				//검은색으로 시작할 때
				for(int r = i; r < i+8; r++) {
					for(int c = j; c < j+8; c++) {
						if(map[r][c] != b_board[r-i][c-j])
							bcnt++;
					}
				}
				int wbmin = Math.min(wcnt, bcnt);
				min = Math.min(min, wbmin);
			}
		}
		System.out.println(min);
	}

}
