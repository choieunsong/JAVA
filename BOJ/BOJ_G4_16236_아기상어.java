package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G4_16236_아기상어 {
	static class Fish implements Comparable<Fish>{
		int r, c, size, dist;
		
		public Fish(int r, int c, int size, int dist) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Fish o) {
			if(this.dist == o.dist) {
				if(this.r == o.r)
					return this.c - o.c;
				else
					return this.r - o.r;
			}else {
				return this.dist - o.dist; 
			}
		}

		@Override
		public String toString() {
			return "Fish [r=" + r + ", c=" + c + ", size=" + size + ", dist=" + dist + "]";
		}
		
	}
	static class Shark{
		int r, c, size, cnt;
		
		public Shark(int r, int c, int size, int cnt) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.cnt = cnt;
		}
	}
	
	static int[][] map;
	static int N;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Shark shark;
	static PriorityQueue<Fish> pq = new PriorityQueue<Fish>();
	static int ans = 0;
 
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(input));
		
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark = new Shark(i, j, 2, 0);
					map[i][j] = 0;
				}
			}
		}
		bfs();
	}
	
	static void bfs() {
		pqUpdate();
//		System.out.println("==================");
		int cnt = 0;
		Fish fish;
		while(!pq.isEmpty()) {
			fish = pq.poll();
			shark.r = fish.r;
			shark.c = fish.c;
			shark.cnt += 1;
			if(shark.cnt == shark.size) {
				shark.cnt = 0;
				shark.size += 1;
			}
			ans += fish.dist;
			map[fish.r][fish.c] = 0;
//			System.out.printf("#%d fish: %d %d dist: %d\n", cnt++, fish.r, fish.c, fish.dist);
//			System.out.printf("shark - r: %d c: %d size: %d ans:%d\n",shark.r, shark.c, shark.size, ans);
//			System.out.println("==================");
			pqUpdate();
		}
		System.out.println(ans);
	}
	
	// fish들 거리정보 수정 
	static void pqUpdate() {
		pq.clear();
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] != 0) {
					if(map[r][c] < shark.size) {
						int dist = findDist(r, c);
						Fish fish = new Fish(r, c, map[r][c], dist);
						pq.offer(fish);
					}
				}
			}
		}
//		Iterator<Fish> iter = pq.iterator();
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}
	}
	
	//dist 구하기 
	static int findDist(int endr, int endc) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {shark.r, shark.c,0});
		
		boolean visited[][] = new boolean[N][N];
		visited[shark.r][shark.c] = true;
		int r = 0, c = 0, size = 0, dist = 0;
		while(!q.isEmpty()){
			r = q.peek()[0];
			c = q.peek()[1];
			dist = q.peek()[2];
			q.poll();
			
			if(r == endr && c == endc) {
//				System.out.printf("r: %d, c: %d, dist: %d\n",endr,endc,dist);
				return dist;
			}
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc]) {
					if(map[nr][nc] <= shark.size) {
						visited[nr][nc] = true;
						q.offer(new int[] {nr, nc, dist+1});
					}
				}
			}
		}
		return 0;
	}
	
}
