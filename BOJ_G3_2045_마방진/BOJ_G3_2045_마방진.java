package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_G3_2045_마방진 {
    static int[][] map = new int[3][3];
    static int SUM = 0, total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int r=0; r<3; r++){
            st = new StringTokenizer(in.readLine());
            for(int c=0; c<3; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
                total += map[r][c];
            }
        }
        solve();
        for(int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.printf("%d ", map[i][j]);
            if(i != 2) System.out.println();
        }
    }
    public static void solve(){
        if((map[0][0] == 0 && map[1][1] == 0 && map[2][2] == 0) || (map[0][2] == 0 && map[1][1] == 0 && map[2][0] == 0)){
            SUM = total / 2;
        }else{
            findSum();
        }
        // R에 대해 탐색
        for(int r=0; r<3; r++){
            int cnt = 0, sum = 0, C = 0;
            for(int c=0; c<3; c++){
                if(map[r][c] == 0){
                    cnt++;
                    C = c;
                }
                sum += map[r][c];
            }
            if(cnt == 1){
                map[r][C] = SUM - sum;
            }
        }
        // C에 대해 탐색
        for(int c=0; c<3; c++){
            int cnt = 0, sum = 0, R = 0;
            for(int r=0; r<3; r++){
                if(map[r][c] == 0){
                    cnt++;
                    R = r;
                }
                sum += map[r][c];
            }
            if(cnt == 1){
                map[R][c] = SUM - sum;
            }
        }
    }
    public static void findSum(){
        // row, col에서 확인
        for(int r=0; r<3; r++){
            int sum1 = 0, sum2 = 0;
            for(int c=0; c<3; c++){
                sum1 += map[r][c];
                sum2 += map[c][r];
            }
            SUM = Math.max(Math.max(sum1, sum2), SUM);
        }
        // 대각선 확인
        int diagnol1 = map[0][0] + map[1][1] + map[2][2];
        int diagnol2 = map[0][2] + map[1][1] + map[2][0];
        SUM = Math.max(Math.max(diagnol1, diagnol2), SUM);
    }
}