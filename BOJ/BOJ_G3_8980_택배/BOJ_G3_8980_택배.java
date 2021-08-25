package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G3_8980_택배 {
    static class Box implements Comparable<Box>{
        int from, to, weight;
        public Box(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Box o){
            if(this.to == o.to){
                return this.from - o.from;
            }else{
                return Integer.compare(this.to, o.to);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(in.readLine());

        List<Box> list = new ArrayList<Box>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(in.readLine());
            list.add(new Box(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);

        int[] cities = new int[N+1];
        Arrays.fill(cities, C);

        int sum = 0;
        for(int i=0; i<M; i++){
            Box box = list.get(i);
            int plus = 10000;
            for(int j=box.from; j<box.to; j++){
                if(cities[j] < plus){
                    plus = cities[j];
                }
            }
            if(plus >= box.weight) plus = box.weight;
            for(int j=box.from; j<box.to; j++) {
                cities[j] -= plus;
            }
            sum += plus;
        }
        System.out.println(sum);
    }
}
