package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G2_17472_다리만들기2 {
	static int[][] map, adjMatrix;
	static boolean[][] visited;
	static int R, C;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<C; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int V = initIsland();
//		for(int i=0; i<R; i++)
//			System.out.println(Arrays.toString(map[i]));
//		System.out.println(V);
		
		adjMatrix = new int[V+1][V+1];
		
		for(int r = 1; r < V+1; r++)
			Arrays.fill(adjMatrix[r], Integer.MAX_VALUE);
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c <C; c++) {
				if(map[r][c] != 0) {
					makeBridge(r, c);
				}
			}
		}
//		System.out.println("=================");
//		for(int r = 1; r <V+1; r++)
//			System.out.println(Arrays.toString(adjMatrix[r]));
		
		System.out.println(prim(V));
	}
	
	// 프림 
	static int prim(int V) {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		
		Edge[] edge = new Edge[V+1];
		
		for(int i=1; i<V+1; i++) {
			if(i == 1)
				edge[1] = new Edge(1, 0);
			else
				edge[i] = new Edge(i, Integer.MAX_VALUE);
			pq.offer(edge[i]);
		}
		
		int result = 0;
		while(!pq.isEmpty()) {
			Edge front = pq.poll();
			if(front.dist == Integer.MAX_VALUE) {
				return -1;
			}
			result += front.dist;
			
			for(int i=1; i<V+1; i++) {
				Edge child = edge[i];
				if(pq.contains(child)) {
					if(child.dist > adjMatrix[front.idx][i]) {
						child.dist = adjMatrix[front.idx][i];
						pq.remove(child);
						pq.offer(child);
					}
				}
			}
		}
		return result;
	}
	
	// 다리 놓기 
	static void makeBridge(int r, int c) {
		visited[r][c] = true;
		int base = map[r][c];
		
		for(int d=0; d<4; d++) {
			for(int l = 1; ;l++) {
				int nr = r + dr[d] * l;
				int nc = c + dc[d] * l;
				if(0 <= nr && nr < R && 0 <= nc && nc < C) {
					if(map[nr][nc] == 0) {
						continue;
					}else if(map[nr][nc] == base) {
						break;
					}else {
						if(l > 2) {
							int to = map[nr][nc];
							adjMatrix[base][to] = adjMatrix[to][base] = Math.min(adjMatrix[base][to], l-1);
						}
						break;
					}
				}else {
					break;
				}
			}
		}
	}
	
	// 섬 전처리 
	static int initIsland() {
		int color = 1;
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(!visited[r][c] && map[r][c] != 0) {
					bfs(r, c, color);
					color++;
				}
			}
		}
		
		return color - 1;
	}
	
	static void bfs(int r, int c, int color) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {r, c});
		visited[r][c] = true;
		map[r][c] = color;
		
		while(!q.isEmpty()) {
			r = q.peek()[0];
			c = q.peek()[1];
			q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(0 <= nr && nr < R && 0 <= nc && nc < C && !visited[nr][nc] && map[nr][nc] != 0) {
					visited[nr][nc] = true;
					map[nr][nc] = color;
					q.add(new int[] {nr, nc});
				}
			}
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int idx, dist;
		
		public Edge(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.dist - o.dist;
		}

		@Override
		public String toString() {
			return "Edge [idx=" + idx + ", dist=" + dist + "]";
		}
		
		
	}
}
