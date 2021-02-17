package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수의 새로운 연산
 * 그래프 대각선 줄 계차수열로 연산하는거 
 * */

public class Solution_D3_1493_최은송2 {
	static int N = 300;
	static int[][] arr = new int[N+1][N+1]; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		initArr();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		int p, q, x=0, y=0, z=0, w=0, result = 0;
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			
			for(int r=1; r<=N; r++) {
				for(int c=1; c<=N; c++) {
					if(arr[r][c] == p) {
						x = r;
						y = c;
					}
					if(arr[r][c] == q) {
						z = r;
						w = c;
					}
				}
			}
			result = arr[x+z][y+w];
			System.out.printf("#%d %d\n",tc,result);
		}

	}
	
	private static void initArr() {
		int num = 1;
		for(int r=1; r<=N; r++) {
			arr[r][1] = num;
			for(int c=2; c<=N; c++) {
				arr[r][c] = arr[r][c-1] + r + c - 1;
			}
			num += r;
		}
		
		
	}

}
