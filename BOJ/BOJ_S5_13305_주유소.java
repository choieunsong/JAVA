package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S5_13305_주유소 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(input));
		
		int N = Integer.parseInt(in.readLine());
		long[] road = new long[N-1];
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for(int i=0; i<N-1; i++)
			road[i] = Integer.parseInt(st.nextToken());
	
		long min = Integer.MAX_VALUE;
		long sum = 0;
		st = new StringTokenizer(in.readLine(), " ");
		for(int i=0; i<N-1; i++) {
			long city = Integer.parseInt(st.nextToken());
			if(city < min) {
				min = city;
			}
			sum += min * road[i];
		}
		System.out.println(sum);
	}
	static String input = "4\n" + 
			"2 3 1\n" + 
			"5 2 4 1";
	
//	static String input = "4\n" + 
//			"3 3 4\n" + 
//			"1 1 1 1";
}
