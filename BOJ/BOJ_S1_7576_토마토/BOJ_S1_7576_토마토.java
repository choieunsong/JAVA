package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_7576_토마토 {
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int R, C, zeroCnt = 0;
	
	public static void main(String[] args) throws IOException{
		init();
		System.out.println(bfs());
	}
	static int bfs() {
		int time=-1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				int[] cur = q.poll();
				q.poll();
				for(int d=0; d<4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if(0 > nr || nr >= R || 0 > nc || nc >= C || map[nr][nc] != 0)	continue;
					map[nr][nc] = 1;
					zeroCnt--;						// 0 카운트를 1 줄여준다 
					q.offer(new int[] {nr,nc});
				}
			}
			time++;
		}
		return zeroCnt == 0 ? time : -1;	// 민약 처음부터 토마토가 다 익어있다면 time=0이 됨. 따로 예외처리 안해도 된다. 
	}
	static void init() throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visited = new boolean[R][C];
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(in.readLine());
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 1)	q.offer(new int[] {r,c});
				else if(map[r][c] == 0)	zeroCnt++;
			}
		}
	}
}
