package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_G4_2441_아이템먹기 {
    static int N, M;
    static int map[][];
    static int dp[][];
    static ArrayList<int[]> items;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int itemNum = Integer.parseInt(st.nextToken());
        int obsNum = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        items = new ArrayList<int[]>();
        for(int i=0; i<itemNum; i++){
            st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            items.add(new int[]{r-1, c-1});
        }
        for(int i=0; i<obsNum; i++){
            st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r-1][c-1] = -1; // 장애물
        }

        items.add(new int[]{0,0});
        items.add(new int[]{N-1,M-1});
        // 정렬해주기
        Collections.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else{
                    return o1[0] - o2[0];
                }
            }
        });

        int ans = 1;
        for(int i=0; i<items.size()-1; i++){
            ans *= getRoadNum(items.get(i), items.get(i+1));
        }
        System.out.println(ans);
    }
    public static int getRoadNum(int[] start, int[] end){
        dp = new int[N][M];
        int r1 = start[0];
        int c1 = start[1];
        int r2 = end[0];
        int c2 = end[1];

        for(int r=r1; r<=r2; r++){
            if(map[r][c1] == -1) break;
            dp[r][c1] = 1;
        }
        for(int c=c1; c<=c2; c++){
            if(map[r1][c] == -1) break;
            dp[r1][c] = 1;
        }
        for(int r=r1+1; r<=r2; r++){
            for(int c=c1+1; c<=c2; c++){
                if(map[r][c] != -1){
                    dp[r][c] = dp[r-1][c] + dp[r][c-1];
                }
            }
        }
//        System.out.printf("(%d %d) - (%d %d)\n",r1,c1,r2,c2);
//        for(int i=0; i<N; i++)
//            System.out.println(Arrays.toString(dp[i]));
//        System.out.println(dp[r2][c2]);
        return dp[r2][c2];
    }
}
