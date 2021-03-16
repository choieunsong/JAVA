package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S3_18310_안테나 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(input));
		
		int N = Integer.parseInt(in.readLine());
		int[] h = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for(int i=0; i<N; i++)
			h[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(h);
		if(N % 2 == 1) {
			System.out.println(h[N/2]);
		}else {
			int sum1 = 0, sum2 = 0;
			int mid1 = N/2-1, mid2 = N/2;
			for(int i=0; i< N; i++) {
				sum1 += Math.abs(h[mid1] - h[i]);
				sum2 += Math.abs(h[mid2] - h[i]);
			}
			System.out.printf("%d\n", sum1 <= sum2 ? h[mid1] : h[mid2]);
			
		}
	}
	static String input = "4\n" + 
			"5 1 7 9";
}
