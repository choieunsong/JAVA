package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_17144_미세먼지안녕 {
	static ArrayList<int[]> air;
	static int[][] map, tmap;	// 오리지널 맵, 임시맵 
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int R,C,T;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		tmap = new int[R][C];
		
		air = new ArrayList<>();
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					air.add(new int[] {i,j});
				}
			}
		}
		System.out.println(find());
	}
	static int find() {
		int answer = 0;
		
		for(int t=0; t<T; t++) {
			// 1. 미세먼지 칸 찾아서 확산  
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(map[i][j] != 0 && map[i][j] != -1) {
						spread(i, j);
					}
				}
			}
			
			// 2. 위쪽 공기청정기 애들 반시계방향으로 이동 
			int airR = air.get(0)[0];
			int airC = air.get(0)[1];
			// 나머지 
			for(int r = 1; r <=airR-1; r++)
				System.arraycopy(tmap[r], 1, map[r], 1, C-2);
			// 아래칸 복사, 윗칸 복사 
			System.arraycopy(tmap[airR], 1, map[airR], 2, C-2);
			System.arraycopy(tmap[0], 1, map[0], 0, C-1);
			// 맨오른쪽칸 위로 이동 
			for(int r = airR; r > 0; r--)
				map[r-1][C-1] = tmap[r][C-1];
			// 맨 왼쪽칸 아래로 이동
			for(int r = 0; r < airR-1; r++)
				map[r+1][0] = tmap[r][0];
			map[airR][1] = 0;
			map[airR][airC] = -1;
			
			// 3. 아래쪽 공기청정기 애들 시계방향으로 이동 
			// 나머지 
			airR = air.get(1)[0];
			airC = air.get(1)[1];
			for(int r = airR+1; r<R-1; r++)
				System.arraycopy(tmap[r], 1, map[r], 1, C-2);
			// 윗칸, 아래칸 복사 
			System.arraycopy(tmap[airR], 1, map[airR], 2, C-2);
			System.arraycopy(tmap[R-1], 1, map[R-1], 0, C-1);
			// 맨 오른쪽칸 아래로 이동 
			for(int r = airR; r < R-1; r++) {
				map[r+1][C-1] = tmap[r][C-1];
			}
			// 맨 왼쪽칸 위로 이동 
			for(int r = R-1; r > airR+1; r--) {
				map[r-1][0] = tmap[r][0];
			}
			map[airR][1]  = 0;
			map[airR][airC] = -1;
			// 임시 맵 다시 초기화 
			for(int i=0; i<R; i++)
				Arrays.fill(tmap[i], 0);
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] != -1 && map[i][j] != 0)
					answer += map[i][j];
			}
		}
		return answer;
	}
	
	static void spread(int r, int c) {
		int cnt = 0;
		int dust = map[r][c] / 5;
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(0 <= nr && nr < R && 0 <= nc && nc < C && map[nr][nc] != -1) {
				tmap[nr][nc] += dust;
				cnt++;
			}
		}
		tmap[r][c] += map[r][c] - (dust * cnt);
	}
}
