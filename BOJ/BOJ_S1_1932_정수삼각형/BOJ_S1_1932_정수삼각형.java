package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_1932_정수삼각형 {
    static int N;
    static int arr[][], dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        arr = new int[N][N+1];
        dp = new int[N][N+1];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j=0; j<i+1; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        System.out.println(dp());
    }
    static int dp(){
        dp[0][0] = arr[0][0];
        for(int i=1; i<N; i++){
            for(int j=0; j<=i; j++){
                if(j == 0)
                    dp[i][j] = dp[i-1][0] + arr[i][j];
                else if(j == i)
                    dp[i][j] = dp[i-1][j-1] + arr[i][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) +arr[i][j];
            }
        }
        int ret = 0;
        for(int i=0; i<N; i++)
            ret = Math.max(ret, dp[N-1][i]);
        return ret;
    }
}
