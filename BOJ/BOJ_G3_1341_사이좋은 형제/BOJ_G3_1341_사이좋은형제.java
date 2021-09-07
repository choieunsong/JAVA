package boj;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_G3_1341_사이좋은형제 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();

        if(a == 0){
            System.out.println("-");
            return;
        }
        if(b == a){
            System.out.println("*");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<120; i++){
            if(a == 0){
                System.out.println("-1");
                return;
            }
            if(a*2 >= b){
                a = 2*a - b;
                sb.append("*");
            }else{
                a = a*2;
                sb.append("-");
            }
        }
//        System.out.println(sb.toString());
        String str = sb.toString();
        String pattern = "";
        for(int len=1; len<=60; len++){
            pattern = str.substring(0, len);
//            System.out.println(pattern);
            boolean match = true;
            int idx = len;
            while(len + idx <= 120){
//                System.out.printf("idx: %d, len: %d\n", idx, len);
//                System.out.printf("pattern: %s, substring: %s\n", pattern, str.substring(idx, idx+len));
                if(!pattern.equals(str.substring(idx, idx+len))){
                    match = false;
                    break;
                }
                idx += len;
            }
            if(match){
                System.out.println(pattern);
                return;
            }
//            System.out.println("========");
        }
        System.out.println("-1");
    }
}
