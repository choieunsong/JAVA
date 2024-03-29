package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_17485_진우의달여행 {
    static int N, M;
    static int[][] map;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M][3];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(in.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(i == 0)  dp[0][j][0] = dp[0][j][1] = dp[0][j][2] = map[0][j];
                else{
                    for(int k=0; k<3; k++)  dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        System.out.println(find());
    }
    public static int find(){
        for(int i=0; i<N-1; i++){
            for(int j=0; j<M; j++){
                if(j == 0){
                    dp[i+1][j][1] = Math.min(dp[i][j][0], dp[i][j][2]) + map[i+1][j];
                    dp[i+1][j][2] = Math.min(dp[i][j+1][0], dp[i][j+1][1]) + map[i+1][j];
                }else if(j == M-1){
                    dp[i+1][j][0] = Math.min(dp[i][j-1][1],dp[i][j-1][2]) + map[i+1][j];
                    dp[i+1][j][1] = Math.min(dp[i][j][0], dp[i][j][2]) + map[i+1][j];
                }else{
                    dp[i+1][j][0] = Math.min(dp[i][j-1][1],dp[i][j-1][2]) + map[i+1][j];
                    dp[i+1][j][1] = Math.min(dp[i][j][0], dp[i][j][2]) + map[i+1][j];
                    dp[i+1][j][2] = Math.min(dp[i][j+1][0], dp[i][j+1][1]) + map[i+1][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<M; i++){
            for(int j=0; j<3; j++)
                min = Math.min(min, dp[N-1][i][j]);
        }
        return min;
    }
}
