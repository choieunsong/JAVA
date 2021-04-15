package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로 {
	static class Edge implements Comparable<Edge>{
		public int from, to;
		public long weight;
		
		public Edge() {}
		public Edge(int from, int to, long weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}
	
	static int findSet(int a) {
		if(parents[a] == a)	return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot)	return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	static int N;
	static int[][] edge;
	static PriorityQueue<Edge> pq;
	static int[] parents;
	static double E;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));;
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(in.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(in.readLine());
			init();
			
			System.out.printf("#%d %d\n", t, kruskal());
		}
	}
	
	static long kruskal() {
		long dist = 0;
		int cnt = 0;
		while(!pq.isEmpty() && cnt != N-1) {
			Edge cur = pq.poll();
			if(union(cur.from, cur.to)) {
				dist += cur.weight;
				cnt++;
			}
		}
		double result = dist * E;
		return Math.round(result);
	}
	
	static void init() throws IOException{
		// union-find parent 배열 초기화 
		parents = new int[N];
		for(int i=0; i<N; i++)
			parents[i] = i;
		
		edge = new int[N][2];
		
		// x좌표 
		StringTokenizer st = new StringTokenizer(in.readLine().trim(), " ");
		for(int i=0; i<N; i++) {
			edge[i][0] = Integer.parseInt(st.nextToken());
		}
		// y좌표 
		st = new StringTokenizer(in.readLine().trim(), " ");
		for(int i=0; i<N; i++) {
			edge[i][1] = Integer.parseInt(st.nextToken());
		}
		
		E = Double.parseDouble(in.readLine());
		
		pq = new PriorityQueue<Edge>();
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				long dist = (long)Math.pow(edge[i][0] - edge[j][0], 2) + (long)Math.pow(edge[i][1] - edge[j][1], 2);
				pq.offer(new Edge(i, j, dist));
			}
		}
	}
}
