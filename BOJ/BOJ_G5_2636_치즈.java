package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_2636_치즈 {
	static int R;
	static int C;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int c = 0; c < C; c++)
				map[r][c] = Integer.parseInt(st.nextToken());
		}
		int time = 0, cnt = 0;
		int prevCnt = melt();
		while(true) {
			// prevCnt = cnt 저장 
			// time++ 
			time++;
			// 외부공기 전처리
			initAir();
			// 1인 애들 찾아서 녹여준다 
			cnt = melt();
			// 만약 cnt가 0이면 끝내준다
			if(cnt == 0) {
				break;
			}
			prevCnt = cnt;
		}
		System.out.printf("%d\n%d",time,prevCnt);
	}
	
	static int melt() {
		int[][] temp = new int[R][C];
		int nr, nc;
		int originCnt = 0, meltCnt = 0;
		boolean air = false;
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] == 1) {
					originCnt++;
					air = false;
					
					for(int d = 0; d < 4; d++) {
						nr = r + dr[d];
						nc = c + dc[d];
						if(map[nr][nc] == 2) 
							air = true;
					}
					if(air) {
						meltCnt++;
						temp[r][c] = 0;
					}else {
						temp[r][c] = 1;
					}
				}
			}
		}
		for(int i=0; i<R; i++)
			System.arraycopy(temp[i], 0, map[i], 0, C);
		return originCnt - meltCnt;
	}
	
	// 외부 공기는 2로 처리해준다. 
	static void initAir() {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visit = new boolean[R][C];
		q.offer(new int[] {0,0});
		visit[0][0] = true;
		
		while(!q.isEmpty()) {
			int r = q.peek()[0];
			int c = q.peek()[1];
			q.poll();
			for(int d = 0; d <4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(0 <= nr && nr < R && 0 <= nc && nc < C && !visit[nr][nc] && map[nr][nc] == 0) {
					visit[nr][nc] = true;
					map[nr][nc] = 2;
					q.offer(new int[] {nr, nc});
				}
			}
		}
	}
}

/*
5 5 
0 0 0 0 0
0 1 1 0 0
0 1 0 1 0
0 1 1 1 0
0 0 0 0 0
*/
