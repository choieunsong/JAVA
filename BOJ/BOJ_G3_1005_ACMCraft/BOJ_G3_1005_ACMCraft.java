package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G3_1005_ACMCraft {
	static int N, K, W, inDegree[], cost[], result;
	static LinkedList<Integer> adj[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			inDegree = new int[N+1];
			cost = new int[N+1];
			adj = new LinkedList[N+1];
			for(int i=0; i<N+1; i++)
				adj[i] = new LinkedList<Integer>();
			
			st = new StringTokenizer(in.readLine());
			for(int i=1; i<=N; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(in.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj[from].add(to);
				inDegree[to]++;
			}
			W = Integer.parseInt(in.readLine());
			topologySort();
			System.out.println(result);
		}
	}
	static void topologySort() {
		result = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		// i번째 건물을 짓기 전에 걸리는 시간 
		int pre[] = new int[N+1];
		//진입차수가 1인 노드를 큐에 삽입 
		for(int i=1; i<=N; i++) {
			if(inDegree[i] == 0) 	q.offer(i);
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			// 해당 정점과 연결된 모든 정점에 대해 간선 수 - 1
			for(int next : adj[cur]) {
				// 다음 건물을 짓기 전에 걸리는 시간의 최댓값을 갱신 
				pre[next] = Math.max(pre[next], pre[cur] + cost[cur]);

				if(--inDegree[next] == 0) {
					q.offer(next);
				}
			}
		}
		result = pre[W] + cost[W];
	}
}
