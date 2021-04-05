package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_S2_2469_사다리타기 {
	static int k;
	static int n;
	static int[] up;
	static int[] order;
	static char[][] ladder;
	static String answer = null;
	static int lineIdx;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(in.readLine());
		n = Integer.parseInt(in.readLine());
		
		order = new int[k];
		up = new int[k];
		ladder = new char[n][k-1];
		
		String line = in.readLine();
		for(int i=0; i<k; i++) {
			order[i] = line.charAt(i) - 'A';
			up[i] =  i;
		}
		
		for(int i=0; i<n; i++) {
			line = in.readLine();
			for(int j=0; j<k-1; k++) {
				ladder[i][j] = line.charAt(j);
				if(ladder[i][j] == '?')
					lineIdx = i;
			}
		}
		find();
	}
	static void find() {
		
		int[] down = Arrays.copyOf(order, k);
		
		// 위에서부터 비교 
		for(int r = 0; r < lineIdx; r++) {
			for(int c = 0; c < k-1; c++) {
				
			}
		}
		// 아래에서부터 비교 
	}
}
