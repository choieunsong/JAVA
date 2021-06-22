package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G2_17387_선분교차2 {
    static class Pos{
        public long x, y;
        public Pos(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
    static Pos A, B, C, D;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // L1
        StringTokenizer st = new StringTokenizer(in.readLine());
        A = new Pos(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
        B = new Pos(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
        //L2
        st = new StringTokenizer(in.readLine());
        C = new Pos(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
        D = new Pos(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));

        System.out.println(solve());
    }
    static int solve(){
        int exL1 = ccw(A, B, C) * ccw(A, B, D);
        int exL2 = ccw(C, D, A) * ccw(C, D, B);
        if(exL1 == 0 && exL2 ==0){
            if(A.x > B.x || A.y > B.y)  swap(A, B);
            if(C.x > D.x || C.y > D.y)  swap(C, D);
            if((A.x <= D.x && B.x >= C.x) || ( A.y <= D.y && B.y >= C.y))   return 1;
            else    return 0;
        } else if(exL1 <= 0 && exL2 <= 0){
            return 1;
        } else{
            return 0;
        }
    }
    static int ccw(Pos a, Pos b, Pos c){
        long exp = a.x * b.y + b.x * c.y + c.x * a.y
                - (b.x * a.y + c.x * b.y + a.x * c.y);
        if(exp > 0)         return 1;   //반시계
        else if(exp < 0)    return -1;  //시계
        else                return 0;   //일직선
    }

    static void swap(Pos a, Pos b){
        Pos temp = new Pos(a.x, a.y);
        a.x = b.x;  a.y = b.y;
        b.x = temp.x; b.y = temp.y;
    }
}
