package boj;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_S4_2847_게임을만든동준이 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for(int i=0; i<N; i++)
            arr[i] = sc.nextInt();

        int cnt = 0;
        int prev = arr[N-1];
        for(int i=N-2; i>=0; i--){
            if(arr[i] >= prev) {
                cnt += arr[i] - (prev-1);
                arr[i] = (prev - 1);
            }
            prev = arr[i];
        }
        System.out.println(cnt);
    }
}
