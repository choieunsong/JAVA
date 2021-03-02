package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ_S5_10157_자리배정 {
	static int C;
	static int R;
	static int K;
	static int cnt = 1;
//						  상,우,하,좌   
	static int[][] dir = {{0,1,0,-1},{1,0,-1,0}};
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(input));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(in.readLine());
		map = new int[R+1][C+1];
		
		if(K > R * C) {
			System.out.println("0");
		}
		else {
			count(0, 1, 1);
		}
	}
	
	static void count(int d, int x, int y) {
		int nx = 0, ny = 0;
		while(cnt != K) {
			map[y][x] = cnt;
			nx = x + dir[0][d];
			ny = y + dir[1][d];

			if(0 >= nx || nx > C || 0 >= ny || ny > R || map[ny][nx] != 0) {
				d = (d+1) % 4;
				nx = x + dir[0][d];
				ny = y + dir[1][d];
			}
			
			x = nx;
			y = ny;
			cnt++;
		}
		System.out.printf("%d %d\n", x, y);
	}
	
	static String input = "7 6\n" + 
			"11";
}