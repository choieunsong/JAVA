package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_G5_15638_감시 {
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int R, C, map[][], copy[][], cctvSize, result, temp[];
	static int[][] type = {{},{1},{1,3},{0,1},{3,0,1},{0,1,2,3}};
	static ArrayList<int[]> list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		copy = new int[R][C];
		list = new ArrayList<int[]>();
		
		for(int i =0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<C; j++) {
				copy[i][j] =map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 6 && map[i][j] != 0) {
					list.add(new int[] {i, j});
				}
			}
		}
		cctvSize = list.size();
		temp = new int[cctvSize];
		result = Integer.MAX_VALUE;
		find(0);
		System.out.println(result);
	}
	
	static void find(int idx) {
		if(idx == cctvSize) {
			// 여기서 칠하기 
			for(int i=0; i<cctvSize; i++) {
				int[] cctv = list.get(i);
				int r = cctv[0];
				int c = cctv[1];
				int ctype = map[r][c];
				paintMap(r, c, ctype, temp[i]);
			}
			int blindSpot = 0;
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(copy[i][j] == 0) blindSpot++;
				}
			}
			result = Math.min(blindSpot, result);

			//copy 원상복귀 
			for(int i=0; i<R; i++)
				System.arraycopy(map[i],0 , copy[i], 0, C);
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			temp[idx] = d;
			find(idx+1);

		}
	}
	
	static void paintMap(int r, int c, int ctype, int d) {
		int[] dirs = type[ctype];
		for(int i = 0; i < dirs.length; i++) {
			int dir = (dirs[i] + d) % 4;
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			while(true) {
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || copy[nr][nc] == 6) break;
				if(copy[nr][nc] == 0)	copy[nr][nc] = -1;
				nr += dr[dir];
				nc += dc[dir];
			}
		}
	}
}
