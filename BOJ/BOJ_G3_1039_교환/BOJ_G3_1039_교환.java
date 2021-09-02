package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_G3_1039_교환 {
    static int max, K, len;
    static HashSet<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        StringBuilder arr = new StringBuilder(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        set = new HashSet<String>();
        set.add(new String(arr));
        len = arr.length();
        max = -1;
        permutation(0, arr);
        System.out.println(max);
    }
    public static void permutation(int cnt, StringBuilder arr){
        if(cnt != 0 && set.contains(arr.toString())){
            System.out.println(cnt);
            return;
        }
        if(cnt == K){
            int N = Integer.parseInt(new String(arr));
            System.out.printf("N: %d, arr: %s\n", N, new String(arr));
            System.out.println("=======================");
            max = Math.max(Integer.parseInt(new String(arr)), max);
            return;
        }
        for(int i=0; i<len-1; i++){
            for(int j=i+1; j<len; j++){
                if(i == 0 && arr.charAt(j) == '0') continue;
//                System.out.printf("cnt: %d, [i: %d - %c] , [j: %d - %c]\n", cnt, i, arr[i], j, arr[j]);
                char temp = arr.charAt(i);
                arr.setCharAt(i, arr.charAt(j));
                arr.setCharAt(j, temp);
//                System.out.printf("%s\n", new String(arr));
                set.add(arr.toString());
                permutation(cnt+1, arr);
                temp = arr.charAt(i);
                arr.setCharAt(i, arr.charAt(j));
                arr.setCharAt(j, temp);
            }
        }
    }
}
