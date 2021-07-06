package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_G1_1135_뉴스전하기 {
    static LinkedList<Integer> adj[];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        adj = new LinkedList[N];
        for(int i=0; i<N; i++)
            adj[i] = new LinkedList<Integer>();

        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i=0; i<N; i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) continue;
            adj[parent].add(i);
        }

        System.out.println(dfs(0));
    }
    static int dfs(int cur){
        //만약 자식노드가 없다면 return 0
        if(adj[cur].size() == 0)
            return 0;
        ArrayList<Integer> time = new ArrayList<Integer>();
        for(int i=0; i<adj[cur].size(); i++){
            int child = adj[cur].get(i);
            time.add(dfs(child));
        }
        // 자식 노드가 많은 애들부터 전파해야 한다
        Collections.sort(time, Collections.reverseOrder());
        int ret = 0, cnt = 0;
        for(int i=0; i<time.size(); i++){
            // 직접 자식 호출 순서
            cnt++;
            ret = Math.max(ret, cnt + time.get(i));
        }
        return ret;
    }
}
