package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *  SWEA 0203 농작물 수확하기 
 *  
 * */

public class Solution_D3_2805_최은송 {
	static int farm[][];
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/swea/2805/2805.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(in.readLine());
			farm = new int[N][N];
			for(int i = 0; i < N; i++) {
				String line = in.readLine();
				for(int j = 0; j < N; j++) {
					farm[i][j] = line.charAt(j) - '0';
				}
			}
			int cnt = 0;
			int mid = N/2;
			for(int i=0; i<N; i++) {
				cnt += farm[i][mid];
				cnt += farm[mid][i];
			}
			cnt -= farm[mid][mid];
			for(int i = 1; i < mid; i++) {
				for(int j = 1; j <= mid-i; j++) {
					cnt += farm[mid+i][mid+j];
					cnt += farm[mid+i][mid-j];
					cnt += farm[mid-i][mid+j];
					cnt += farm[mid-i][mid-j];
				}
			}
			System.out.printf("#%d %d\n",testCase, cnt);
			
		}

	}

}
