package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_S2_1931_회의실배정 {
    static class Meet implements Comparable<Meet>{
        public int start, end;
        public Meet(int start, int end){
            this.start = start;
            this.end = end;
        }
        public int compareTo(Meet o){
            if(this.end == o.end)
                return this.start - o.start;
            else
                return this.end - o.end;
        }
    }
    static int N;
    static PriorityQueue<Meet> pq = new PriorityQueue<Meet>();
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        StringTokenizer st = null;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(in.readLine());
            pq.offer(new Meet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        System.out.println(greedy());
    }
    static int greedy(){
        int ret = 0;
        Meet meet;
        int prevEnd = 0;
        while(!pq.isEmpty()){
            meet = pq.poll();
            if(meet.start >= prevEnd){
                ret++;
                prevEnd = meet.end;
            }
        }
        return ret;
    }
}

