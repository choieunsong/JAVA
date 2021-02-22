package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_D3_7236_저수지의물의총깊이구하기 {
	static char[][] map;
	static int N;
	static int max;
	static int[] dr = {-1,-1,-1,0,0,1,1,1};		//좌상,상,우상,좌,우,좌하,하,우하 
	static int[] dc = {-1,0,1,-1,1,-1,0,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(in.readLine());
			map = new char[N][N];
			max = Integer.MIN_VALUE;
			for(int i=0; i<N; i++) {
				String line = in.readLine().trim();
				for(int j=0, k=0; j<N; j++, k+=2) {
					map[i][j] = line.charAt(k);
				}
			}
			
			find();
			System.out.printf("#%d %d\n", tc, max);
		}
	}
	
	private static void find() {
		int nr, nc;
		for(int r=1; r<N-1; r++) {
			for(int c=1; c<N-1; c++) {
				if(map[r][c] == 'W') {
					int cnt = 0;
					for(int i=0; i<8; i++) {
						nr = r + dr[i];
						nc = c + dc[i];
						if(map[nr][nc] == 'W')
							cnt++;
					}
					cnt = cnt == 0 ? 1 : cnt;
					max = Math.max(max, cnt);
				}
			}
		}
	}

}
