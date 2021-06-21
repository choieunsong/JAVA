package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G4_17140_이차원배열과연산 {
    static int r, c, k, A[][];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        A = new int[101][101];
        for(int i=1; i<=3; i++){
            st = new StringTokenizer(in.readLine());
            for(int j=1; j<=3; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }
        System.out.printf("%d\n", A[r][c] == k ? 0 : solve());
    }

    static int solve(){
        int R = 3, C = 3, ret = -1;
        for(int i=1; i<=100; i++){
            if(R >= C){
               C = rSort(R, C);
            }else{
                R = cSort(R, C);
            }
            if(A[r][c] == k){
                ret = i;
                break;
            }
        }
        return ret;
    }

    static int rSort(int R, int C){
        int col = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[1] == o2[1])  return o1[0] - o2[0];
                else                return o1[1] - o2[1];
            }
        });
        for(int i=1; i<=R; i++){
            int[] num = new int[101];
            for(int j=1; j<=C; j++){
                if(A[i][j] == 0)    continue;
                num[A[i][j]]++;
                A[i][j] = 0;
            }
            for(int j=1; j<=100; j++){
                if(num[j] != 0)
                    pq.offer(new int[]{j, num[j]});
            }
            int idx = 1;
            while(!pq.isEmpty()){
                int[] x = pq.poll();
                A[i][idx++] = x[0];
                A[i][idx++] = x[1];
            }
            col = Math.max(idx-1, col);
        }
        return col;
    }
    static int cSort(int R, int C){
        int row = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[1] == o2[1])  return o1[0] - o2[0];
                else                return o1[1] - o2[1];
            }
        });
        for(int i=1; i<=C; i++){
            int num[] = new int[101];
            for(int j=1; j<=R; j++){
                if(A[j][i] == 0)    continue;
                num[A[j][i]]++;
                A[j][i] = 0;
            }
            for(int j=1; j<=100; j++){
                if(num[j] != 0)
                    pq.offer(new int[]{j, num[j]});
            }
            int idx = 1;
            while(!pq.isEmpty()){
                int[] x = pq.poll();
                A[idx++][i] = x[0];
                A[idx++][i] = x[1];
            }
            row = Math.max(idx-1, row);
        }
        return row;
    }


}
