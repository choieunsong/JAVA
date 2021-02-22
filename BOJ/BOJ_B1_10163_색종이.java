package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B1_10163_색종이 {
	private static int[][] map = new int[101][101];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int cnt[] =  new int[N+1];
		
		for(int t=1; t<=N; t++) {
			int c, r, w, h;
			StringTokenizer st = new StringTokenizer(in.readLine().trim(), " ");
			c = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			for(int y = r; y < r+h; y++)
				for(int x = c; x < c+w; x++) 
					map[y][x] = t;
				
		}
		for(int i=0; i<101; i++)
			for(int j=0; j<101; j++)
				if(map[i][j]!= 0)
					cnt[map[i][j]] += 1;
		
		for(int i=1; i<=N; i++)
			System.out.println(cnt[i]);
	}

}
