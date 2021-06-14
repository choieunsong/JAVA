package boj;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S4_10815_숫자카드 {
    static int N, cards[], M;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine().trim());
        cards = new int[N+1];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 1; i <= N; i++)
            cards[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            System.out.printf("%d ", binarySearch(num));
        }

    }

    static int binarySearch(int num){
        int low = 1, high = N;
        while(low <= high){
            int mid = (low + high) / 2;
            if(cards[mid] == num)
                return 1;
            else if(cards[mid] < num)
                low = mid+1;
            else
                high = mid-1;
        }
        return 0;
    }
}
