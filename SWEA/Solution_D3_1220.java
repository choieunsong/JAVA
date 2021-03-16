package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_1220 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];
			String line;
			for(int i=0; i<N; i++) {
				line = in.readLine().trim();
				for(int j=0, k=0; j<N; j++, k+=2) {
					map[i][j] = line.charAt(k) - '0';
				}
			}
			int cnt = 0;
			for(int c=0; c<N; c++) {
				int pre = 0;
				boolean flagN = false;
				for(int r=0; r<N; r++) {
					if(map[r][c] != 0) {
						if(map[r][c] == 1) {
							flagN = true;
							pre = 1;
						}else if(map[r][c] == 2) {
							if(pre == 1 && flagN) {
								cnt++;
							}
							pre = 2;
						}
					}
				}
			}
			System.out.printf("#%d %d\n",tc, cnt);
		}
	}

}
