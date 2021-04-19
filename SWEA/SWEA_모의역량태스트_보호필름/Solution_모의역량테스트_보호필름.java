package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_모의역량테스트_보호필름 {
	static int D, W, K, map[][],temp[][], min;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[D][W];
			temp = new int[D][W];
			min = Integer.MAX_VALUE;
			
			for(int i = 0; i < D; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < W; j++)
					temp[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
			}
			combination(0, 0);
			System.out.printf("#%d %d\n",t, min);
		}
	}
	static void combination(int idx, int cnt) {
		if(cnt >= min)	return;
		if(idx == D) {
			if(validCheck()) {
				min = Math.min(min, cnt);
			}
			return;
		}
		// 해당 층 내버려두기 
		combination(idx+1, cnt);
		
		// 해당 층 0으로 채우기 
		for(int i=0; i<W; i++) {
			temp[idx][i] = 0;
		}
		combination(idx+1, cnt+1);
		
		// 해당 층 1로 채우기 
		for(int i=0; i<W; i++) {
			temp[idx][i] = 1;
		}
		combination(idx+1, cnt+1);
		
		// 원래대로 돌려놓기 
		for(int i=0; i<W; i++) {
			temp[idx][i] = map[idx][i];
		}
	}
	

	
	static boolean validCheck() {
		loop:
		for(int c = 0; c < W; c++) {
			for(int r = 0; r <= D-K; r++) {
				boolean zeroFlag = true;
				boolean oneFlag = true;
				for(int i = r; i < r+ K; i++) {
					if(temp[i][c] != 0) {
						zeroFlag = false;
					}
					if(temp[i][c] != 1) {
						oneFlag = false;
					}
				}
				if(zeroFlag || oneFlag) {
					continue loop;
				}
			}
			return false;
		}
		return true;
	}
}
