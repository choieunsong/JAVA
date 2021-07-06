package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G5_1013_Contact {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        String pattern = "(100+1+|01)+";
        for(int i=0; i<N; i++){
            String s = in.readLine().trim();
            System.out.println(s.matches(pattern) ? "YES" : "NO");
        }
    }
}
