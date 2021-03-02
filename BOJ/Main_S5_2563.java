package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 색종이 
 * */

public class Main_S5_2563 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		int[][] map = new int[101][101];
		int cnt = 0; 
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int r=y; r<y+10; r++) {
				for(int c=x; c<x+10; c++) {
					if(map[r][c] == 1)	continue;
					map[r][c] = 1;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
