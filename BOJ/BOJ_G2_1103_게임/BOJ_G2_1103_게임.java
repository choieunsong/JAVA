package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class BOJ_G2_1103_게임 {
    static int N, M;
    static char[][] map;
    static int[][] dp;
    static boolean[][] visited;

    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++)
            map[i] = in.readLine().toCharArray();

        System.out.println(dfs(0,0));
    }
    static int dfs(int r, int c){
        if(r < 0 || r >= N || c < 0 || c >= M || map[r][c] == 'H')  return 0;
        if(visited[r][c]){
            System.out.println("-1");
            exit(0);
        }
        if(dp[r][c] != 0)   return dp[r][c];
        visited[r][c] = true;
        for(int d=0; d<4; d++){
            int move = map[r][c] - '0';
            int nr = r + dr[d] * move;
            int nc = c + dc[d] * move;
            dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
        }
        visited[r][c] = false;
        return dp[r][c];
    }
}
