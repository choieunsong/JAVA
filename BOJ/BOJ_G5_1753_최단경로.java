package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G5_1753_최단경로 {
	static class Node implements Comparable<Node>{
		int to, weight;
		
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", weight=" + weight + "]";
		}
		
	}
	
	static LinkedList<Node> list[];
	static boolean[] visited;
	static int[] distance;
	static final int INF = 200000000;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		
		StringTokenizer st = new StringTokenizer(in.readLine().trim(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(in.readLine().trim());
		
		list = new LinkedList[V+1];
		visited = new boolean[V+1];
		distance = new int[V+1];
		
		for(int i=0; i<V+1; i++)
			list[i] = new LinkedList<Node>();
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine().trim(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to, weight));
		}
		
		Arrays.fill(distance, INF);
		
		dijkstra(start);
		
		for(int i=1; i<V+1; i++) {
			if(distance[i] == INF)
				System.out.println("INF");
			else
				System.out.println(distance[i]);
		}
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start, 0));
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.to;
			
			if(visited[cur])	continue;
			visited[cur] = true;
			
			for(Node node : list[cur]) {
				if(distance[node.to] > distance[cur] + node.weight) {
					distance[node.to] = distance[cur] + node.weight;
					pq.add(new Node(node.to, distance[node.to]));
				}
			}
		}
	}
	
	static String input = "5 6\n" + 
			"1\n" + 
			"5 1 1\n" + 
			"1 2 2\n" + 
			"1 3 3\n" + 
			"2 3 4\n" + 
			"2 4 5\n" + 
			"3 4 6";
}
