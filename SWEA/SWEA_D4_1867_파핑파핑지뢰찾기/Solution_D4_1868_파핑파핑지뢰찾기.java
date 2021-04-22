package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D4_1868_파핑파핑지뢰찾기 {
	static int N, ans[][];
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,-1,-1,0,0,1,1,1};
	static int[] dc = {-1,0,1,-1,1,-1,0,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(in.readLine());
			map = new char[N][];
			ans = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) 
				map[i] = in.readLine().toCharArray();

			calAns();
			System.out.printf("#%d %d\n",t, bfs());
		}
	}
	static int bfs() {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != '*' && ans[i][j] == 0 && !visited[i][j]) {
					Queue<int[]> q = new LinkedList<int[]>();
					q.offer(new int[] {i, j});
					visited[i][j] = true;
					cnt++;
					while(!q.isEmpty()) {
						int[] pos = q.poll();
						int r = pos[0];
						int c = pos[1];
						for(int d = 0; d < 8; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == '*' || visited[nr][nc])	continue;
							visited[nr][nc] = true;
							if(ans[nr][nc] == 0)
								q.offer(new int[] {nr, nc});
						}
					}
				}
			}
		}
		for(int r = 0; r < N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] != '*' && !visited[r][c]) 
					cnt++;
			}
		}
		return cnt;
	}
	static void calAns() {
		int nr, nc, cnt = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] == '*') {
					for(int d=0; d<8; d++) {
						nr = r +dr[d];
						nc = c +dc[d];
						if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == '*') continue;
						ans[nr][nc]++;
					}
				}
			}
		}
	}
}