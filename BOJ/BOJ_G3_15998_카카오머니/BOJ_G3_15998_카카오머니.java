package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class BOJ_G3_15998_카카오머니 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        long a, b;
        long balance = 0;   // 현재 잔액
        long M = 0; //최소충전금액
        long minB = (long) 10e18;   //최소잔액 => M이 최소잔액보다 커야 함
        boolean valid = true;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());

            // 출금액: 잔액 초과일 경우
            if(balance + a < 0){
                //minB 갱신
                if(b != 0 && b < minB){
                    minB = b;
                }
                // M 구하기
                if(M == 0) {
                    M = b - balance - a;
                } else{
                    // M의 최대공약수 구하기
                    long x = b - balance - a;
                    M = gcd(M, x);
                }
                //유효성검사. 최소충전금액이 minB(잔액)보다 작으면 -1
                if(M <= minB && minB != (long)10e18){
                    valid = false;
                    break;
                }
            }else{
                if(balance + a != b){
                    valid = false;
                    break;
                }
            }
            balance = b;
        }
        if(valid && M != 0) System.out.println(M);
        else if(valid && M == 0) System.out.println(1);
        else System.out.println(-1);
    }
    // 유클리드 호제법
    static long gcd(long a, long b) {
        while (b > 0) {
            long tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
}
