package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S2_1106_호텔 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] cost = new int[N];
        int[] customer = new int[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(in.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            customer[i] = Integer.parseInt(st.nextToken());
        }
        // idx: 비용, value: 고객수
       int[] dp = new int[100001];
        for(int i=0; i<N; i++){
            for(int j = cost[i]; j <= 100000; j++){
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + customer[i]);
            }
        }
        for(int i=1; i<= 100000; i++){
            if(dp[i] >= C){
                System.out.println(i);
                break;
            }
        }

    }
}
