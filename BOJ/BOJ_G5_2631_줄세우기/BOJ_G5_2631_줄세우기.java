package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class BOJ_G5_2631_줄세우기 {
    static int N;
    static int[] arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for(int i=0; i<N; i++)
            arr[i] = sc.nextInt();
        System.out.println(N - LIS());
    }
    static int LIS(){
        int[] dp = new int[N];
        int max = 0;
        for(int i=1; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j] && dp[j] + 1 > dp[i])
                    dp[i] = dp[j] + 1;
            }
            if(dp[i] >= max) max = dp[i];
        }
        return max+1;
    }
}
