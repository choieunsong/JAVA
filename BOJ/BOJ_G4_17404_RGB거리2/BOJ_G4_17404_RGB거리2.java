package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_17404_RGB거리2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        int[][] house = new int[N+1][3];
        int[][] dp = new int[N+1][3];
        for(int i=1; i<N+1; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            house[i][0] = Integer.parseInt(st.nextToken());
            house[i][1] = Integer.parseInt(st.nextToken());
            house[i][2] = Integer.parseInt(st.nextToken());
        }
        int min = Integer.MAX_VALUE;
        for(int start=0; start<3; start++) {
            // 시작점 값 셋팅
            for(int i=0; i<3; i++){
                if(start == i) dp[1][start] = house[1][start];
                else    dp[1][i] = 1000000;
            }
            for (int i = 2; i <= N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + house[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + house[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + house[i][2];
            }
            // 시작점과 도착지가 같으면 계산 뺴주기
            for(int i=0; i<3; i++){
                if(i == start) continue;
                min = Math.min(min, dp[N][i]);
            }
        }
        System.out.println(min);
    }
}
