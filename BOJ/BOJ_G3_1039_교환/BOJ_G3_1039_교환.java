package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G3_1039_교환 {
    static int K;
    static Queue<String> q = new LinkedList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        String num = st.nextToken();
        K = Integer.parseInt(st.nextToken());

        int result = bfs(num);
        System.out.println(result);
    }
    public static int bfs(String num){
        q.offer(num);

        for(int k=1; k<=K; k++){
            int size = q.size();
            boolean[] visited = new boolean[1000001];
            for(int s=0; s < size; s++){
                String str = q.poll();
                if(visited[Integer.parseInt(str)]){
                    continue;
                }
                visited[Integer.parseInt(str)] = true;
                char[] cstr = str.toCharArray();
                for(int i=0; i<cstr.length-1; i++){
                    for(int j=i+1; j<cstr.length; j++){
                        if(i == 0 && cstr[j] == '0') continue;
                        char temp = cstr[i];
                        cstr[i] = cstr[j];
                        cstr[j] = temp;
                        str = new String(cstr);
                        q.offer(str);
                        temp = cstr[i];
                        cstr[i] = cstr[j];
                        cstr[j] = temp;
                    }
                }
            }
        }
        int max = -1;
        while(!q.isEmpty()){
            String str = q.poll();
            max = Math.max(max, Integer.parseInt(str));
        }
        return max;
    }
}
