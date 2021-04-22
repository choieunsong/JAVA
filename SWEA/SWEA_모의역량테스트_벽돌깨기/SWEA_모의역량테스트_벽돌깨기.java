package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_모의역량테스트_벽돌깨기 {
	static int W, H, N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[] choice;
	static int brickCnt, tempCnt;
	static int min;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		for(int t=1; t<=TC; t++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			brickCnt = 0;
			min = Integer.MAX_VALUE;
			choice = new int[N];
			map = new int[H][W];
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 0)	brickCnt++;
				}
			}
			permutation(0);
			System.out.printf("#%d %d\n",t,min);
		}
	}
	
	// 순열로 W 중 N개의 열을 선택 
	static void permutation(int cnt) {
		if(cnt == N) {
			tempCnt = brickCnt;
			int[][] mmap = copyMap();
			game(mmap);
			return;
		}
		for(int i=0; i<W; i++) {
			choice[cnt] = i;
			permutation(cnt+1);
		}
		
	}
	
	static void game(int[][] mmap) {
		for(int n = 0; n < N; n++) {
			visited = new boolean[H][W];
			
			Queue<int[]> q = new LinkedList<>();
			
			// 현재 순열의 가장 윗칸의 좌표, 값을 구해준다. 
			int w = choice[n];
			int h = -1;
			for(int r = 0; r < H; r++) {
				if(mmap[r][w] != 0) {
					h = r;
					break;
				}
			}
			
			// 만약 현재 w의 열이 전부 0이면 continue
			if(h == -1)	continue;
			q.offer(new int[] {h, w, mmap[h][w]});
			visited[h][w] = true;
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				tempCnt--;
				
				for(int d = 0; d < 4; d++) {
					for(int p = 0; p < cur[2]; p++) {
						int nr = cur[0] + dr[d] * p;
						int nc = cur[1] + dc[d] * p;
						
						if(0 > nr || nr >= H || 0 > nc || nc >= W || visited[nr][nc] || mmap[nr][nc] == 0)	continue;
						
						q.offer(new int[] {nr, nc, mmap[nr][nc]});
						visited[nr][nc] = true;
					}
				}
			}
			rebuild(mmap);
		}
		min = Math.min(min, tempCnt);
	}
	
	static void rebuild(int[][] mmap) {
		for(int w = 0; w < W; w++) {
			for(int h = 0; h < H; h++) {
				// 만약 빈칸이 발견됐으면 
				if(visited[h][w]) {
					int r = h;
					while(true) {
						mmap[r][w] = 0;
						
						if(r-1 < 0) break;
						if(map[r-1][w] == 0)	break;
						
						mmap[r][w] = mmap[r-1][w];
						mmap[r-1][w] = 0;
						r--;
					}
				}
			}
		}
	}
	
	static int[][] copyMap() {
		int[][] mmap = new int[H][W];
		for(int i = 0; i < H; i++) {
			System.arraycopy(map[i], 0, mmap[i], 0, W);
		}
		return mmap;
	}
}
