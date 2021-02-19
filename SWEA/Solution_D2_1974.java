package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 스도쿠 검증 
 * */

public class Solution_D2_1974_최은송 {
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(inputData));
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			map = new int[9][9];
			StringTokenizer st;
			
			for(int i=0; i<9; i++) {
				st = new StringTokenizer(in.readLine()+" ");
				for(int j=0; j<9; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			System.out.printf("#%d %d\n",tc, check() ? 1 : 0);
		}
	}
	
	public static boolean check() {
		int sum=0;
		// 모든 row 검사
		for(int r=0; r<9; r++) {
			sum = 0;
			for(int c=0; c<9; c++) 
				sum += map[r][c];
			if(sum != 45)	return false;
		}
		// 모든 col 검사
		for(int c=0; c<9; c++) {
			sum = 0;
			for(int r=0; r<9; r++)
				sum +=  map[r][c];
			if(sum != 45)	return false;
		}
		
		// 3x3 퍼즐 검사 
		for(int r=0; r<9; r+=3) {
			for(int c=0; c<9; c+=3) {
				sum = 0;
				for(int y = 0; y < 3; y++) 
					for(int x = 0; x < 3; x++)
						sum += map[r+y][c+x];
				if(sum != 45)	return false;
			}
		}
		return true;
	}
	

	static String inputData = "10\n" + 
			"7 3 6 4 2 9 5 8 1\n" + 
			"5 8 9 1 6 7 3 2 4\n" + 
			"2 1 4 5 8 3 6 9 7\n" + 
			"8 4 7 9 3 6 1 5 2\n" + 
			"1 5 3 8 4 2 9 7 6\n" + 
			"9 6 2 7 5 1 8 4 3\n" + 
			"4 2 1 3 9 8 7 6 5\n" + 
			"3 9 5 6 7 4 2 1 8\n" + 
			"6 7 8 2 1 5 4 3 9\n" + 
			"7 3 6 4 8 9 2 5 1\n" + 
			"8 5 2 7 3 1 6 9 4\n" + 
			"9 1 4 5 6 2 7 3 8\n" + 
			"4 9 7 2 5 6 8 1 3\n" + 
			"5 6 3 1 8 7 9 4 2\n" + 
			"2 8 1 9 4 3 5 6 7\n" + 
			"6 7 5 3 2 4 1 8 9\n" + 
			"1 4 9 6 7 8 3 2 5\n" + 
			"3 2 8 1 9 5 4 7 6\n" + 
			"2 4 6 7 5 3 1 9 8\n" + 
			"7 5 8 1 9 4 2 3 6\n" + 
			"3 9 1 2 6 8 7 5 4\n" + 
			"5 8 2 3 4 6 9 7 1\n" + 
			"1 6 3 9 7 2 4 8 5\n" + 
			"9 7 4 8 1 5 6 2 3\n" + 
			"4 2 7 5 8 1 3 6 9\n" + 
			"6 3 5 4 2 9 8 1 7\n" + 
			"8 1 9 6 3 7 5 4 2\n" + 
			"8 4 5 2 9 6 1 3 7\n" + 
			"1 3 6 7 5 8 4 9 2\n" + 
			"9 7 2 1 3 4 6 5 8\n" + 
			"2 9 7 4 6 3 8 5 1\n" + 
			"4 6 1 5 8 2 9 7 3\n" + 
			"5 8 3 9 7 1 2 4 6\n" + 
			"3 2 8 6 4 5 7 1 9\n" + 
			"7 1 4 3 2 9 6 8 5\n" + 
			"6 5 9 8 1 7 3 2 4\n" + 
			"4 5 7 1 6 3 8 2 9\n" + 
			"6 3 9 8 2 7 5 4 1\n" + 
			"7 9 3 4 8 5 1 6 2\n" + 
			"1 8 2 5 4 9 6 3 7\n" + 
			"8 6 1 7 9 2 3 5 4\n" + 
			"5 2 4 6 3 1 7 9 8\n" + 
			"3 7 6 9 1 4 2 8 5\n" + 
			"2 4 5 3 7 8 9 1 6\n" + 
			"9 1 8 2 5 6 4 7 3\n" + 
			"1 5 2 3 8 6 9 4 7\n" + 
			"4 8 3 2 7 9 1 5 6\n" + 
			"7 6 9 1 5 4 8 2 3\n" + 
			"2 1 8 6 4 7 5 3 9\n" + 
			"6 9 7 5 3 8 2 1 4\n" + 
			"5 3 4 9 1 2 6 7 8\n" + 
			"9 7 1 4 6 5 3 8 2\n" + 
			"8 2 5 7 9 3 4 6 1\n" + 
			"3 4 6 8 2 1 7 9 5\n" + 
			"1 5 8 6 7 2 3 4 9\n" + 
			"7 2 9 3 4 8 5 1 6\n" + 
			"6 3 4 5 1 9 7 2 8\n" + 
			"8 9 2 1 2 5 6 7 4\n" + 
			"3 7 6 8 9 4 2 5 1\n" + 
			"5 4 1 7 3 6 8 9 3\n" + 
			"2 8 7 9 6 1 4 3 5\n" + 
			"4 1 5 2 8 3 9 6 7\n" + 
			"9 6 3 4 5 7 1 8 2\n" + 
			"1 2 4 9 3 6 7 8 5\n" + 
			"7 8 6 2 4 5 3 9 1\n" + 
			"3 9 5 1 7 8 2 4 6\n" + 
			"5 1 9 4 6 2 8 7 3\n" + 
			"4 6 7 8 9 3 5 1 2\n" + 
			"8 3 2 5 1 7 9 6 4\n" + 
			"9 7 3 6 5 4 1 2 8\n" + 
			"6 5 8 7 2 1 4 3 9\n" + 
			"2 4 1 3 8 9 6 5 7\n" + 
			"5 9 3 8 4 1 7 6 2\n" + 
			"2 1 8 7 6 3 4 9 5\n" + 
			"7 6 4 9 2 5 1 3 8\n" + 
			"4 3 6 5 9 2 8 1 7\n" + 
			"1 8 5 4 3 7 9 2 6\n" + 
			"9 2 7 1 8 6 5 4 3\n" + 
			"3 4 1 6 5 8 2 7 9\n" + 
			"6 5 9 2 7 4 3 8 1\n" + 
			"8 7 2 3 1 9 6 5 4\n" + 
			"7 1 4 5 8 9 2 3 6\n" + 
			"8 5 2 3 6 4 7 1 9\n" + 
			"3 6 9 1 7 2 8 5 4\n" + 
			"2 3 1 9 4 6 5 7 8\n" + 
			"6 8 5 7 3 2 9 4 1\n" + 
			"9 4 7 8 1 5 3 6 2\n" + 
			"1 7 8 6 9 3 4 2 5\n" + 
			"4 2 3 1 5 8 6 9 7\n" + 
			"5 9 6 4 2 7 1 8 3\n";
	
}
