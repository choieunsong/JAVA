package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S2_4307_개미 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(input));
		int T = Integer.parseInt(in.readLine());
		int[] input;
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine().trim(), " ");
			int L =  Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			input = new int[num];
			for(int i=0; i < num; i++) {
				input[i] = Integer.parseInt(in.readLine());
			}
			int min = Integer.MIN_VALUE;
			int max = Integer.MIN_VALUE;
			int left = 0, right = 0, tmin = 0, tmax = 0;
			for(int i = 0; i < num; i++) {
				left = input[i];
				right = L - input[i];
				tmin = left < right ? left : right;
				tmax = left <= right ? right: left; 
				min = Math.max(min, tmin);
				max = Math.max(max,tmax);
			}
			System.out.printf("%d %d\n", min, max);
		}
				
	}
	static String input = "2\n" + 
			"10 3\n" + 
			"2\n" + 
			"6\n" + 
			"7\n" + 
			"214 7\n" + 
			"11\n" + 
			"12\n" + 
			"7\n" + 
			"13\n" + 
			"176\n" + 
			"23\n" + 
			"191";
}
