package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_모의역량테스트_활주로건설 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N, X;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		int TC = Integer.parseInt(in.readLine());
		for(int t = 1; t <= TC; t++) {
			init();
			int ans = buildRow() + buildCol();
			System.out.printf("#%d %d\n",t,ans);
		}
	}
	static int buildCol() {
		int cnt = 0;
		boolean[][] visited = new boolean[N][N];
		col: for(int c = 0; c < N; c++) {
			int n = map[0][c];
			for(int i = 1; i < N; i++) {
				if(n == map[i][c]) {
				}else if(map[i][c] - n == 1) {
					int j = i-1;
					while(j >= i-X) {
						if(j < 0 || map[j][c] != n || visited[j][c]) {
							continue col;
						}
						visited[j][c] = true;
						j--;
					}
					n = map[i][c];
				}else if(n - map[i][c] == 1) {
					visited[i][c] = true;
					int j = i+1;
					while(j <= i + X - 1) {
						if(j >= N || map[j][c] != n-1 || visited[j][c]) {
							continue col;
						}
						visited[j][c] = true;
						j++;
					}
					n = map[i+X-1][c];
					i = i+X-1;
				}else {
					continue col;
				}
			}
			cnt++;
		}
		return cnt;
	}
	
	static int buildRow() {
		int cnt = 0;
		boolean[][] visited = new boolean[N][N];
		row: for(int r = 0; r < N; r++) {
			int n = map[r][0];
			for(int i = 1; i < N; i++) {
				if(n == map[r][i]) {
				}else if(map[r][i] - n == 1) {
					int j = i-1;
					while(j >= i-X) {
						if(j < 0 || map[r][j] != n || visited[r][j]) {
							continue row;
						}
						visited[r][j] = true;
						j--;
					}
					n = map[r][i];
				}else if(n - map[r][i] == 1) {
					visited[r][i] = true;
					int j = i+1;
					while(j <= i + X - 1) {
						if(j >= N || map[r][j] != n-1 || visited[r][j]) {
							continue row;
						}
						visited[r][j] = true;
						j++;
					}
					n = map[r][i+X-1];
					i = i+X-1;
				}else {
					continue row;
				}
			}
			cnt++;
		}
		return cnt;
	}
	static void init() throws IOException{
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i = 0; i <N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
