package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution_D4_1486_장훈이의높은선반 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		int T = Integer.parseInt(in.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			
			int[] h = new int[N];
			st = new StringTokenizer(in.readLine(), " ");
			for(int i=0; i<N; i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}
			
			int min = Integer.MAX_VALUE;
			for(int i=1, end=1<<N; i<end; i++) {
				int sum = 0;
				for(int flag=0; flag < N; flag++) {
					if((1<<flag & i) != 0) {
						sum += h[flag];
					}
				}
				if(sum >= H) {
					min = Math.min(min, sum-H);
				}
			}
			System.out.printf("#%d %d\n",t, min);
		}
	}
	static String input = "1\n" + 
			"5 16\n" + 
			"1 3 3 5 6";
}
