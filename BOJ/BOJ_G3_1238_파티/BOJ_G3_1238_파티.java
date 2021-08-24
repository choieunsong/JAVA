package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G3_1238_파티 {
    static class Edge implements Comparable<Edge>{
        int v, weight;
        public Edge(int v, int weight){
            this.v = v;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.weight, o.weight);
        }
    }
    static int N, M, X;
    static LinkedList<Edge> edges[];
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        edges = new LinkedList[N+1];
        for(int i=1; i<N+1; i++)
            edges[i] = new LinkedList<Edge>();


        for(int i=0; i<M; i++){
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[from].add(new Edge(to, weight));
        }
        int max = 0;
        // 출발지 -> X
        int[] result = new int[N+1];
        for(int i=1; i<=N; i++){
            result[i] = dijkstra(i, X);
        }
        // X -> 출발지
        dijkstra(X, 0);
        for(int i=1; i<=N; i++){
            max = Math.max(max, result[i] + dist[i]);
        }
        System.out.println(max);
    }
    static int dijkstra(int start, int dest){
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        boolean[] visited = new boolean[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.offer(new Edge(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if(visited[cur.v])  continue;
            visited[cur.v] = true;

            for(Edge next : edges[cur.v]){
                if(dist[next.v] > dist[cur.v] + next.weight){
                    dist[next.v] = dist[cur.v] + next.weight;
                    pq.offer(new Edge(next.v, dist[next.v]));
                }
            }
        }
        return dist[dest];
    }

}
