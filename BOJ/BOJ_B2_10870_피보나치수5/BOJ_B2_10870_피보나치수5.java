package boj;

import java.util.Scanner;

public class BOJ_B2_10870_피보나치수5 {
    static int[] memo;

    static int fibo(int n){
        if(memo[n] != 0){
            return memo[n];
        }
        if(n == 0)  return 0;
        else if(n == 1) return 1;
        else{
            memo[n] = fibo(n-1) + fibo(n-2);
        }
        return memo[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        memo = new int[21];
        memo[1] = 1;
        fibo(N);
        System.out.println(memo[N]);
    }
}
