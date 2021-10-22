package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_G5_20208_진우의민트초코우유 {
    static int N, M, H;
    static int[][] map;
    static boolean[] visited;
    static int[] order;
    static int max = 0, sr, sc;

    static ArrayList<Milk> milk;
    static class Milk{
        public int r, c;
        public Milk(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[]args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        milk = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    sr = i;
                    sc = j;
                }else if(map[i][j] == 2){
                    milk.add(new Milk(i, j));
                }
            }
        }
        order = new int[milk.size()];
        visited = new boolean[milk.size()];
        permu(0);
        System.out.println(max);
    }
    private static void permu(int idx){
        if(idx == order.length){
            findMax();
            return;
        }
        for(int i=0; i<order.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            order[idx] = i;
            permu(idx+1);
            visited[i] = false;
        }
    }

    private static void findMax(){
        int r = sr, c = sc, hp = M;
        int cnt = 0, dist = 0, mr = 0, mc = 0;
        for(int i=0; i<order.length; i++){
            mr = milk.get(order[i]).r;
            mc = milk.get(order[i]).c;
            dist = Math.abs(r - mr) + Math.abs(c - mc);
            if(dist <= hp){
                hp -= dist;
                hp += H;
                cnt++;
                int toHome = Math.abs(mr - sr) + Math.abs(mc - sc);
                if(hp >= toHome){
                    max = Math.max(max, cnt);
                }
                r = mr;
                c = mc;
            }else{
                return;
            }
        }
    }
}
