package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_최은송 {
	static int N, M, L, R, C;
	static int[][] map;
	static boolean[][] visited;
//						상,하,좌,우
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
//								상하좌우      상하   좌우    상우    하우    하좌    상좌	
	static int[][] DIR = {{} , {0,1,2,3}, {0,1}, {2,3}, {0,3}, {1,3}, {1,2}, {0,2}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.printf("#%d %d\n",t, findLoc());
		}
	}
	
	static int findLoc() {
		int cnt = 0, r, c, nr, nc, dir, nd;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {R, C, map[R][C]});
		visited[R][C] = true;
		
		for(int l = 0; l < L; l++) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int[] cur = q.poll();
				r = cur[0];
				c = cur[1];
				dir = cur[2];
				cnt++;
				
				for(int d = 0, len = DIR[dir].length; d < len; d++) {
					nd = DIR[dir][d];	// 현재 위치에서 어디로 갈거냐 
					nr = r + dr[nd];
					nc = c + dc[nd];

					if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 0) continue;
					
					int nextDir = map[nr][nc];
					switch(nd) {
						case 0: 
							if(nextDir == 1 || nextDir == 2 || nextDir == 5 ||nextDir == 6) 
								q.offer(new int[] {nr, nc, nextDir});
								visited[nr][nc] = true;
							break;
						case 1 :
							if(nextDir == 1 || nextDir == 2 || nextDir == 4 ||nextDir == 7) 
								q.offer(new int[] {nr, nc, nextDir});
								visited[nr][nc] = true;
							break;
						case 2 :
							if(nextDir == 1 || nextDir == 3 || nextDir == 4 ||nextDir == 5) 
								q.offer(new int[] {nr, nc, nextDir});
								visited[nr][nc] = true;
							break;
						case 3 :
							if(nextDir == 1 || nextDir == 3 || nextDir == 6 ||nextDir == 7) 
								q.offer(new int[] {nr, nc, nextDir});
								visited[nr][nc] = true;
							break;
					}
				}
			}
		}
		return cnt;
	}
}
