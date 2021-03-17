package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_14889_스타트와링크 {
	static int N;
	static int arr[][];
	static boolean selected[];
	static int min;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(input));
		
		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		selected = new boolean[N];
		min = Integer.MAX_VALUE;
		
		StringTokenizer st = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<N; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		int sidx[] = new int[N/2];
		combination(0, 0, sidx);
		System.out.println(min);
	}
	
	static void combination(int cnt, int start, int[] sidx) {
		if(cnt == N/2) {
			int[] lidx = new int[N/2];
			for(int i=0, idx = 0; i<N; i++) {
				if(!selected[i]) {
					lidx[idx++] = i;
				}
			}
			int ssum = 0, lsum = 0, from, to;
			for(int i=0; i<N/2 - 1; i++) {
				for(int j=i+1; j < N/2; j++) {
					from = sidx[i];	to = sidx[j];
					ssum += arr[from][to] + arr[to][from];
					from = lidx[i];	to = lidx[j];
					lsum += arr[from][to] + arr[to][from];
				}
			}
			int diff = Math.abs(ssum - lsum);
			min = Math.min(diff, min);
			return;
		}
		for(int i=start; i<N; i++) {
			if(!selected[i]) {
				selected[i] = true;
				sidx[cnt] = i;
				combination(cnt+1, i+1, sidx);
				selected[i] = false;
			}
		}
	}
	
	static String input = "4\n" + 
			"0 1 2 3\n" + 
			"4 0 5 6\n" + 
			"7 1 0 2\n" + 
			"3 4 5 0";
}
