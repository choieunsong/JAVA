package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 백준 S1 쿼드트리 
 * 분할정복, 재귀 
 * */

public class BOJ_S1_1992 {
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String line = in.readLine().trim();
			for(int j=0; j<N; j++)
				map[i][j] = line.charAt(j) - 48;
		}
		recur(N,0,0);
	}
	
	public static void recur(int n, int r, int c) {
		if(n == 1) {
			System.out.print(map[r][c]);
			return;
		}
		boolean isZero = true;
		boolean isOne = true;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i+r][j+c]== 1)
					isZero = false;
				if(map[i+r][j+c]== 0)
					isOne = false;
			}
		}
		if(isZero)	System.out.print(0);
		else if(isOne)	System.out.print(1);
		else {
			System.out.print("(");
			int half = n/2;
			for(int i=0; i<2; i++)
				for(int j=0; j<2; j++)
					recur(n/2, r + i * half, c + j * half);
			System.out.print(")");
		}
	}
	

}
