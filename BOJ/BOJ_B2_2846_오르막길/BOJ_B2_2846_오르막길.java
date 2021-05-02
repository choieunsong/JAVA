package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B2_2846_오르막길 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int start = 0, prev = 0, len = 0, max = 0;
		len = Integer.parseInt(in.readLine());
	
		StringTokenizer st = new StringTokenizer(in.readLine());
		start = prev = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i < len; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(prev < num) {
				prev = num;
				if(i == len-1) {
					max = Math.max(max, prev-start);
				}
			}else {
				max = Math.max(max,  prev - start);
				start = num;
				prev = num;
			}
		}
		System.out.println(max);
	}

}
