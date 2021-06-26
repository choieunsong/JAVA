package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_G5_9251_LCS {
    static String a, b;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        a = in.readLine();
        b = in.readLine();
        dp = new int[1001][1001];
        System.out.println(LCS());
    }

    static int LCS(){
        for(int i=1; i<=a.length(); i++){
            for(int j=1; j<=b.length(); j++){
                if(a.charAt(i-1) == b.charAt(j-1))  dp[i][j] = dp[i-1][j-1] + 1;
                else                            dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[a.length()][b.length()];
    }
}
