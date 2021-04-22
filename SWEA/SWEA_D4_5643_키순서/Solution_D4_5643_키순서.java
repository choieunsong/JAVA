package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D4_5643_키순서 {
	static int N, M, preNext[], cnt;
	static LinkedList<Integer> adj[];
	static boolean visited[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine().trim());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(in.readLine().trim());
			M = Integer.parseInt(in.readLine().trim());
			
			preNext = new int[N+1];
			adj = new LinkedList[N+1];
			for(int i=0; i<N+1; i++)
				adj[i] = new LinkedList<Integer>();
			
			StringTokenizer st = null;
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(in.readLine().trim());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj[from].add(to);
			}
			
			for(int i=1; i<N+1; i++) {
				cnt = 0;
				visited = new boolean[N+1];
				dfs(i);
				preNext[i] += cnt;		// 내 뒤에 있는 원소 수 카운트 
			}
			int result = 0;
			for(int i=1; i<=N; i++) {
				if(preNext[i] == N)
					result++;
			}
			System.out.printf("#%d %d\n",t, result);
			
		}
		
	}
	static void dfs(int v) {
		cnt++;
		for(Integer next : adj[v]) {
			if(!visited[next]) {
				visited[next] = true;
				preNext[next]++;	// 내 앞에 있는 원소 수 카운트 
				dfs(next);
			}
		}
	}
}
