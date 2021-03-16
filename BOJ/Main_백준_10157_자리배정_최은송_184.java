package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_백준_10157_자리배정_최은송_184{
	static int C;
	static int R;
	static int K;

	static int map[][];
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(in.readLine());
		
		map = new int[R+1][C+1];
		if(K > C*R) {
			System.out.println("0");
		}else {
			find();
		}
	}
	
	static void find() {
		int nr = 0, nc = 0, r = 1, c = 1;
		int d = 0, cnt = 1;
		while(cnt < K) {
			map[r][c] = cnt;
			nr = r + dr[d];
			nc = c + dc[d];
			if(nr <= 0 || nr > R || nc <= 0 || nc > C || map[nr][nc] != 0)  {
				d = (d+1) % 4;
				nr = r + dr[d];
				nc = c + dc[d];
			}
			r = nr;
			c = nc;
			cnt++;
		}
		System.out.println(c + " " + r);
	}
}