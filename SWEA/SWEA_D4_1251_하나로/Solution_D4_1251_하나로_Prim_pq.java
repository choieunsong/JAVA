package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로_Prim_pq {
	static int N;
	static long[][] adjMatrix;
	
	static class Vertex implements Comparable<Vertex>{
		int no;
		long cost;
		
		public Vertex(int no, long cost) {
			this.no = no;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return Long.compare(this.cost, o.cost);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(in.readLine());
			adjMatrix = new long[N][N];
			
			int x[] = new int[N];
			StringTokenizer st = new StringTokenizer(in.readLine());
			// 각 섬의 x좌표 
			for(int i=0; i<N; i++)
				x[i] = Integer.parseInt(st.nextToken());
			
			int y[] = new int[N];
			st = new StringTokenizer(in.readLine());
			// 각 섬의 y좌표 
			for(int i=0; i<N; i++)
				y[i] = Integer.parseInt(st.nextToken());
			
			// 인접행렬 구하기
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					adjMatrix[j][i] = adjMatrix[i][j] = getDistance(x[i], x[j], y[i], y[j]);
				}
			}
			double E = Double.parseDouble(in.readLine());
			System.out.printf("#%d %d\n",t, Math.round(makeMst()*E));
		}
	}
	
	static long makeMst() {
		long[] minEdge = new long[N];
		boolean[] visited = new boolean[N];
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		// 임의의 정점을 시작점으로 만듬 
		minEdge[0] = 0;
		
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		pq.offer(new Vertex(0, minEdge[0]));
		
		long result = 0;	// 최소신장트리 비용 
		int cnt = 0;		// 정점 개수 
		
		while(true){
			// 신장트리에 포함되지 않은 정점 중 최소간선비용의 정점 선택 
			Vertex minVertex = pq.poll();
			if(visited[minVertex.no])	continue;
			
			// 신장트리에 포함시킴 
			visited[minVertex.no] = true;
			result += minVertex.cost;
			if(++cnt == N)	break;
			
			for(int i=0; i<N; i++) {
				if(!visited[i] && minEdge[i] > adjMatrix[minVertex.no][i]) {
					minEdge[i] = adjMatrix[minVertex.no][i];
					pq.offer(new Vertex(i, minEdge[i]));
				}
			}
		}

		return result;
	}
	
	static long getDistance(int x1, int x2, int y1, int y2) {
		return (long)(Math.pow(x1-x2, 2) + Math.pow(y1-y2,2));
	}
}
