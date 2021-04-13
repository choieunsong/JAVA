package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_16236_아기상어 {
	static class Shark{
		public int r, c, size, eatCnt;
		public Shark(int r, int c, int size, int eatCnt) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.eatCnt = eatCnt;
		}
		public void setEatCnt() {
			eatCnt++;
			if(eatCnt == size) {
				size++;
				eatCnt = 0;
			}
		}
	}
	
	static class Fish implements Comparable<Fish>{
		public int r, c, dist;
		public Fish(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
		@Override
		public int compareTo(Fish o) {
			// dist, 세로위, 가로왼 순으로 
			if(this.dist != o.dist) { 
				return Integer.compare(this.dist, o.dist);
			}else {
				if(this.r == o.r) {
					return Integer.compare(this.c, o.c);
				}else {
					return Integer.compare(this.r, o.r);
				}
			}
		}
	}
	static int N, time = 0;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static Shark shark;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));	
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9)
					shark = new Shark(i,j,2,0);
			}
		}
		bfs();
		System.out.println(time);
	}
	static void bfs() {
		PriorityQueue<Fish> pq = new PriorityQueue<Fish>();
		
		boolean[][] visited = new boolean[N][N];		
		do {
			// 1. pq 전부 clear
			pq.clear();
			// 2. map에 있는 애들 중 사이즈가 상어보다 작은 애들을 pq에 넣는다.
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j] && map[i][j] != 0 && map[i][j] != 9 && map[i][j] < shark.size) {
						int dist = findDist(i, j);
						// 만약 거리가 -1이면 물고기까지 이동 못함 (상어보다 사이즈가 큰 물고기로 둘러쌓인 경우)  
						if(dist != -1)
							pq.offer(new Fish(i,j,dist));
					}
				}
			}
			// 2. 만약 q에 먹을 게 없으면 끝임
			if(pq.isEmpty()) {
				return;
			}
			else {
				// 2. 그 중 맨 앞에 있는 놈을 빼라
				Fish fish = pq.poll();
				shark.r = fish.r;	
				shark.c = fish.c;		// 아기상어를 잡은 물고기 좌표로 이동  
				shark.setEatCnt();		// 아기상어 먹은 갯수, 사이즈 갱신 
				time += fish.dist;		// 시간 더해주기 
				visited[fish.r][fish.c] = true;		// 방문체크  
				map[shark.r][shark.c] = 0;			// 잡아먹은 물고기는 빈칸으로 표시  
			}
		} while(true);
	}
	static int findDist(int R, int C) {
		boolean[][] visited = new boolean[N][N];
		visited[shark.r][shark.c] = true;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {shark.r, shark.c});
		
		int dist = 0, nr, nc, r, c;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				r = q.peek()[0];
				c = q.peek()[1];
				q.poll();
				
				if(r == R && c == C) {
					return dist;
				}
				for(int d=0; d<4; d++) {
					nr = r + dr[d];
					nc = c + dc[d];
					if(0 > nr || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || (map[nr][nc] != 9 && map[nr][nc] > shark.size))	
						continue;
					q.offer(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
			}
			dist++;
		}
		// 만약 해당좌표까지 도달 못하면 -1 return 
		return -1;
	}
}
