package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_S4_20551_Sort마스터배지훈의후계자 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[N];
        for(int i=0; i<N; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);

        for(int i=0; i<M; i++){
            int num = sc.nextInt();
            System.out.println(binarySearch(num));
        }
    }

    public static int binarySearch(int num){
        int low = 0;
        int high = arr.length-1;
        int mid = 0;
        while(low < high){
            mid = (low + high) / 2;
            if(num <= arr[mid]){
                high = mid;
            } else{
                low = mid + 1;
            }
        }
        if(arr[low] == num) return low;
        else        return -1;
    }
}
