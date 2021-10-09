package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G4_1674_도시분할계획 {
    static class Edge implements Comparable<Edge>{
        public int to, cost;
        public Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge e){
            return Integer.compare(this.cost, e.cost);
        }
    }
    static int N, M;
    static LinkedList<Edge> list[];
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new LinkedList[N+1];
        for(int i=1; i<N+1; i++)
            list[i] = new LinkedList<Edge>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[from].add(new Edge(to, cost));
            list[to].add(new Edge(from, cost));
        }
        visited = new boolean[N+1];
        System.out.println(prim());
    }

    public static int prim(){
        PriorityQueue<Edge> q = new PriorityQueue<Edge>();
        q.offer(new Edge(1, 0));
        int dist = 0;
        int max = 0;
        while(!q.isEmpty()){
            Edge current = q.poll();

            if(!visited[current.to]) visited[current.to] = true;
            else    continue;

            max = Math.max(max, current.cost);
            dist += current.cost;

            for(int i=0; i<list[current.to].size(); i++){
                Edge next = list[current.to].get(i);
                if(!visited[next.to]){
                    q.offer(new Edge(next.to, next.cost));
                }
            }
        }
        return dist - max;
    }
}
