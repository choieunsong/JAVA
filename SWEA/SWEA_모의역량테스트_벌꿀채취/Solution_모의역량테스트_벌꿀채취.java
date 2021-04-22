package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_모의역량테스트_벌꿀채취 {
	static int N, M, C, map[][], maxCost;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			maxCost = 0;
			findWorker1();
			System.out.printf("#%d %d\n",t,maxCost);
		}
	}
	
	static void findWorker1() {
		boolean[][] visited = new boolean[N][N];
		for(int r = 0; r <N; r++) {
			for(int c = 0; c <= N-M; c++) {
				// 방문체크 
				for(int i = 0; i<M; i++)
					visited[r][c+i] = true;
				// 일꾼1의 최대 수익 구하기 
				int value1 = cal(r, c);
				// 일꾼2의 최대 수익 구하기 
				int value2 = findWorker2(visited);
				maxCost = Math.max(maxCost, value1 + value2);
				for(int i = 0; i<M; i++)
					visited[r][c+i] = false;
			}
		}
	}
	static int findWorker2(boolean[][] visited) {
		int ret = 0;
		for(int r=0; r<N; r++) {
			loop: for(int c=0; c<N; c++) {
				if(c+M-1 >= N)	continue;
				for(int i=0; i<M; i++)
					if(visited[r][c+i]) continue loop;
				int value = cal(r, c);
				ret = Math.max(ret, value);
			}
		}
		return ret;
	}
	static int cal(int r, int c) {
		int maxHoney = 0, maxValue = 0, flag = 0;
		for(int i = 0, end = 1 << M; i < end; i++) {
			int honey = 0;
			flag = 0;
			for(int j=0; j<M; j++) {
				if((i & 1 << j) != 0) {
					honey += map[r][c+j];
					flag |= 1 << j;
				}
			}
			if(honey <= C && honey >= maxHoney) {
				maxHoney = honey;
				int val = 0;
				for(int k=0; k<M; k++) {
					if((flag & 1<<k) != 0)
						val += Math.pow(map[r][c+k], 2);
				}
				maxValue = Math.max(maxValue, val);
			}
		}
		return maxValue;
	}
}
