package swea;

import java.util.Scanner;


public class Solution_연습문제_4317_칩생산 {
    static int map[][], R, C, ans;
    static int dp[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            R = sc.nextInt();
            C = sc.nextInt();

            dp = new int[1 << R][C];    // 백트래킹
            map = new int[R][C];
            for (int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            ans = 0;
            dfs(0, 0, 1);
            System.out.printf("#%d %d\n", t, ans-1);
        }
    }
    // 위에서 아래로 탐색
    static void dfs(int r, int c, int cnt){
        if(r >= R-1){
            c++;
            r = 0;
        }
        if(c == C-1){
            if(cnt > ans)
                ans = cnt;
            return;
        }
        // 백트래킹
        if(r == 0){
            int flag = 0;
            for(int i = 0; i < R; i++){
                flag |= (map[i][c] << i);
            }
            if(dp[flag][c] >= cnt)  return;
            dp[flag][c] = cnt;
        }
        if(check(r, c)){
            map[r][c] = map[r][c+1] = map[r+1][c] = map[r+1][c+1] = 1;
            dfs(r + 2, c, cnt+1);
            map[r][c] = map[r][c+1] = map[r+1][c] = map[r+1][c+1] = 0;
        }
        dfs(r + 1, c, cnt);
    }

    static boolean check(int r, int c){
        if(r + 1>= R || c+1 >= C)   return false;
        if(map[r][c] == 1 || map[r][c+1] == 1 || map[r+1][c] == 1 || map[r+1][c+1] == 1) return false;
        return true;
    }
}
