package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B2_2669_직사각형네개의합집합의면적구하기 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[101][101];
		StringTokenizer st;
		int x, y, x2, y2, sum = 0;
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(in.readLine().trim(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			for(int r = y; r < y2; r++) {
				for(int c = x; c < x2; c++) {
					if(map[r][c] == 0) {
						map[r][c] = 1;
						sum++;
					}
				}
			}
		}
		System.out.println(sum);

	}

}
