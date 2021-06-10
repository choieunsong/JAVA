package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S3_2579_계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[300];
        int[] dp = new int[300];
        for(int i=0; i < N; i++)
            arr[i] = Integer.parseInt(in.readLine());

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0] + arr[1], arr[1]);
        dp[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
        for(int n =3; n < N; n++)
            dp[n] = Math.max(dp[n-2] + arr[n], arr[n-1] + dp[n-3] + arr[n]);
        System.out.println(dp[N-1]);
    }
}
