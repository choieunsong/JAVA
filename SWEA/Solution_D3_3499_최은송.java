package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * SWEA D3 3499 퍼펙트 셔플 
 * */

public class Solution_D3_3499_최은송 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			Queue<String> left = new LinkedList<>();
			Queue<String> right= new LinkedList<>();
			
			int M = (N+1)/2;
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i=0; i<M; i++) {
				left.offer(st.nextToken());
			}
			for(int i=M; i<N; i++) {
				right.offer(st.nextToken());
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#"+tc+" ");
			while(!left.isEmpty()) {
				sb.append(left.poll()+" ");
				if(right.isEmpty())	continue;
				sb.append(right.poll()+" ");
			}
			
			System.out.println(sb.toString());
		}

	}
}
