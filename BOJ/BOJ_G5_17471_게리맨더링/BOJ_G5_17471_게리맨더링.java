package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_17471_게리맨더링 {
	static int N;
	static int[] population;
	static LinkedList<Integer> adj[];
	static ArrayList<Integer> agroup;
	static ArrayList<Integer> bgroup;
	public static void main(String[] args) throws IOException{
		init();
		
		int min = Integer.MAX_VALUE;
		boolean ansFlag = false;
		// 1. 조합으로 a, b 선택  
		subset: for(int i=1; i<(1<<N-1); i++) {
			agroup = new ArrayList<Integer>();
			bgroup = new ArrayList<Integer>();
			int asum = 0, bsum = 0;
			for(int j=0; j<N; j++) {
				// 2. asum, bsum 구하기 
				if((i & 1<<j) != 0) {
					asum += population[j+1];
					agroup.add(j+1);
				}else {
					bsum += population[j+1];
					bgroup.add(j+1);
				}
			}
			// 3. a그룹, b그룹이 연결되어 있는지 체크
			boolean[] visited = new boolean[N+1];
			boolean aflag = true, bflag = true;
			
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(agroup.get(0));
			visited[agroup.get(0)] = true;
			while(!q.isEmpty()) {
				int cur = q.poll();
				for(Integer next : adj[cur]) {
					if(!visited[next] && agroup.contains(next)) {
						visited[next] = true;
						q.offer(next);
					}
				}
			}
			for(Integer a : agroup) {
				if(!visited[a]) 
					aflag = false;
			}
			if(!aflag) 	continue subset;
			
			visited = new boolean[N+1];
			q.add(bgroup.get(0));
			visited[bgroup.get(0)] = true;
			while(!q.isEmpty()) {
				int cur = q.poll();
				for(Integer next : adj[cur]) {
					if(!visited[next] && bgroup.contains(next)) {
						visited[next] = true;
						q.offer(next);
					}
				}
			}
			for(Integer b : bgroup) {
				if(!visited[b])
					bflag = false;
			}
			if(!bflag) 	continue subset;
			
			if(aflag && bflag) {
				ansFlag = true;
				min = Math.min(min, Math.abs(asum-bsum));
			}
		}
		if(!ansFlag)
			System.out.println(-1);
		else
			System.out.println(min);
		// 4. 둘 다 연결되어 있으면 최소값 갱신 
		// 5. 아니면 다른 조합 구하기
		// 두 선거구로 나눌 수 없는 경우에는 -1 출력 
	}
	static void init() throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		population = new int[N+1];
		adj = new LinkedList[N+1];
		for(int i=0; i<N+1; i++)
			adj[i] = new LinkedList<Integer>();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=1; i<=N; i++)
			population[i] = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			int size = Integer.parseInt(st.nextToken());
			for(int j=0; j<size; j++) {
				adj[i].add(Integer.parseInt(st.nextToken()));
			}
		}
	}
}
