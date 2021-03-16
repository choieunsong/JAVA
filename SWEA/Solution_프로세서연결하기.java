package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/**
 * 중복순열 , 부분집합(코어를 최대한 많이니까 코어를 선택, 비선택 해야함) 
 * */

public class Solution_프로세서연결하기 {
	static int N;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static List<int[]> pos;
	static int[][] map;
	static int min;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(in.readLine());
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			map = new int[N][N];
			pos = new ArrayList<int[]>();
			
			for(int i=0; i<N; i++) {
				String line = in.readLine();
				for(int j=0, k=0; j<N; j++, k+=2) {
					map[i][j] = line.charAt(k) - 48;
					if(map[i][j] == 1) {
						if(i != 0 && j != 0 && i != N-1 && j != N-1) {
							pos.add(new int[] {i,j});							
						}
					}
				}
			}
			permu(0, 0, 0);
			System.out.printf("#%d %d\n",tc, min);
		}		
		}
		// 중복 순열 .core가 최대한 많이 연결되어야 함. 그 중 distance가 가장 짧아야 함 
		private static void permu(int cnt, int core, int dist) {
//			가지치기 N - cnt: 남은 코어수
//			core+남은 코어수 < max => 더 가볼 필요가 없다. 
			if(N - cnt + core < max)	return;
			if(cnt == pos.size()) {
				if(max < core) {
					max = core;
					min = dist;
				}
				else if(max == core) {
					min = Math.min(min, dist);
				}
				return;
			}
			int r = pos.get(cnt)[0];
			int c = pos.get(cnt)[1];
			for(int i=0; i<4; i++) { 
				int len = isPossible(i, r, c);
				paint(i, r, c, len, true);
				if(len == 0)	// 연결 불가능한 애들은 core수를 그대로 permu 호출 
					permu(cnt+1, core, dist);
				else 			// 연결 가능한 애들은 core수를 늘리고, dist+len해서 호출 
					permu(cnt+1, core+1, dist+len);
				paint(i,r,c,len, false);
				
			}
		}
		// 가다가 중간에 전선이 교차하면 연결 불가. 불가한 애들은 len를 0으로 보냄. 
		private static int isPossible(int dir, int r, int c) {
			int len = 0;
			int nr = r;
			int nc = c;
			while(true) {
				nr += dr[dir];
				nc += dc[dir];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N)
					break;
				if(map[nr][nc] == 1) {	//전선을 만나면 len=0
					len = 0;
					break;
				}
				len++;	
			}
			return len;
		}
		private static void paint(int dir, int r, int c, int len, boolean flag) {
			for(int i=0; i<len; i++) {
				r += dr[dir];
				c += dc[dir];
				map[r][c] = flag ? 1 : 0;
			}
		}
	}