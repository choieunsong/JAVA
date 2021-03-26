package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 플로이드-와샬 버전 
public class BOJ_S1_9205_맥주마시면서걸어가기2 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(in.readLine());
			int[][] pos = new int[N+2][2];
			boolean[][] visited = new boolean[N+2][N+2];
			for(int i=0; i<N+2; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				pos[i][0] = Integer.parseInt(st.nextToken());
				pos[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<N+2; i++) {
				for(int j=0; j<N+2; j++) {
					int dist = Math.abs(pos[i][0] - pos[j][0]) + Math.abs(pos[i][1] - pos[j][1]);
					if(dist <= 1000)	visited[i][j] = true;
				}
			}
			
			for(int k=0; k<N+2; k++) {
				for(int i=0; i<N+2; i++) {
					for(int j=0; j<N+2; j++) {
						// i->k, k->j가 되면 i->j도 된다! 
						if(visited[i][k] && visited[k][j]) visited[i][j] = true;
					}
				}
			}
			String ans = visited[0][N+1] ? "happy" : "sad";
			System.out.println(ans);	
		}
	}

}
