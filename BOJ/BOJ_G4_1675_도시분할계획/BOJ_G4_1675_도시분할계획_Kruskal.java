package boj;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G4_1675_도시분할계획_Kruskal {
    static class Edge implements Comparable<Edge>{
        public int start,to, cost;
        public Edge(int start,int to, int cost){
            this.start = start;
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge e){
            return Integer.compare(this.cost, e.cost);
        }
    }
    static PriorityQueue<Edge> pq;
    static int N, M, parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        pq = new PriorityQueue<Edge>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost =  Integer.parseInt(st.nextToken());
            pq.offer(new Edge(from, to, cost));
        }
        System.out.println(kruskal());
    }
    public static int kruskal(){
        parent = new int[N+1];
        for(int i=1; i<=N; i++)
            parent[i] = i;

        int count = 0;
        int dist = 0;
        while(count < N-2){
            Edge edge = pq.poll();
            int p1 = find(edge.start);
            int p2 = find(edge.to);
            if(p1 != p2){
                count++;
                union(p1, p2);
                dist += edge.cost;
            }
        }
        return dist;
    }
    public static void union(int a, int b){
        parent[a] = b;
    }
    public static int find(int a){
        if(parent[a] == a)  return a;
        else    return parent[a] = find(parent[a]);
    }
}
