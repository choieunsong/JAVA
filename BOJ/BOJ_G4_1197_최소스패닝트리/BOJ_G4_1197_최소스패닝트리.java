package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G4_1197_최소스패닝트리 {
	static int V, E;
	static LinkedList<Node> list[];
	
	static class Node implements Comparable<Node>{
		int to, cost;
		public Node(int idx, int cost) {
			this.to = idx;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost) ;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new LinkedList[V+1];
		for(int i=1; i<=V; i++)
			list[i] = new LinkedList<>();
		
		for(int i=1; i<=E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, weight));
			list[to].add(new Node(from, weight));
		}
		System.out.println(prim());
	}
	
	static int prim() {
		boolean[] visited = new boolean[V+1];
		int[] minEdge = new int[V+1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		minEdge[1] = 0;
		pq.offer(new Node(1, minEdge[1]));
		
		int result = 0, cnt = 0;
		while(true) {
			Node minNode = pq.poll();
			if(visited[minNode.to])	continue;
			
			visited[minNode.to] = true;
			result += minNode.cost;
			
			if(++cnt == V)	break;
			
			for(Node node : list[minNode.to]) {
				if(!visited[node.to] && minEdge[node.to] > node.cost) {
					minEdge[node.to] = node.cost;
					pq.offer(new Node(node.to, node.cost));
				}
			}
		}
		return result;
	}
}
