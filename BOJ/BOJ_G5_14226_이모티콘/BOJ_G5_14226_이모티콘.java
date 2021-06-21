package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_G5_14226_이모티콘 {
    static int S;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(in.readLine());
        System.out.println(bfs());
    }
    static int bfs(){
        Queue<int[]> q = new LinkedList<int[]>();
        boolean visited[][] = new boolean[1001][1001];

        int ret = 0, cur[];
        q.offer(new int[]{1, 0, 0});    //이모티콘 수, 클립보드, 시간
        visited[1][0] = true;
        while(!q.isEmpty()){
            cur = q.poll();
           if(cur[0] == S){
               ret =  cur[2];
               break;
           }
            //1. 클립보드에 복사
            if(!visited[cur[0]][cur[0]]) {
                q.offer(new int[]{cur[0], cur[0], cur[2] + 1});
                visited[cur[0]][cur[0]] = true;
            }
            //2. 화면에 붙여넣기
            if(cur[0]+cur[1] <= 1000 && !visited[cur[0] + cur[1]][cur[1]]) {
                q.offer(new int[]{cur[0] + cur[1], cur[1], cur[2] + 1});
                visited[cur[0]+cur[1]][cur[1]] = true;
            }
            //3. 1개 삭제하기
            if(cur[0]-1 > 0 && !visited[cur[0]-1][cur[1]]) {
                q.offer(new int[]{cur[0] - 1, cur[1], cur[2] + 1});
                visited[cur[0]-1][cur[1]] = true;
            }
        }
        return ret;
    }
}
