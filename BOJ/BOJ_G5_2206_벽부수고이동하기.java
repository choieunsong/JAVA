package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_2206_벽부수고이동하기 {
	static int[][] map;
	static boolean[][][] visited;
	static int N;
	static int M;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M][2];
		
		for(int i=0; i <N; i++) {
			String line = in.readLine();
			for(int j=0; j < M; j++) {
				map[i][j] = line.charAt(j) - 48;
			}
		}
		System.out.println(bfs());
	}
	
	//방문 체크를 벽을 부수고 왔는지, 안부수고 왔는지 2가지로 상태를 체크해 주겠다. 
	static int bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {0,0,1,1});
		visited[0][0][1] = true;
			
		int r, c, cnt, block, nr, nc;
		while(!q.isEmpty()) {
			r = q.peek()[0];
			c = q.peek()[1];
			cnt = q.peek()[2];
			block = q.peek()[3];		//block = 1: 벽 안부숨, 0: 벽 부숨 
			q.poll();
			
			if(r == N-1 && c == M-1)
				return cnt;
			
			for(int d = 0; d < 4; d++) {
				nr = r + dr[d];
				nc = c + dc[d];
				if(0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc][block]) {
					if(map[nr][nc] == 0) {
						visited[nr][nc][block] = true;
						q.offer(new int[] {nr, nc, cnt+1, block});
					}
					else if(map[nr][nc] == 1 && block == 1) {
						visited[nr][nc][0] = true;
						q.offer(new int[] {nr, nc, cnt+1, 0});
					}
				}
			}
		}
		return -1;
	}
}
