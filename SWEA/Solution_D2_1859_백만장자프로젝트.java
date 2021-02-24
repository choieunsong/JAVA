package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_D2_1859_백만장자프로젝트 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine().trim());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(in.readLine().trim());
			int num[] = new int[N];
			StringTokenizer st = new StringTokenizer(in.readLine().trim(), " ");
			for(int i=0; i<N; i++)
				num[i] = Integer.parseInt(st.nextToken());
			
			int max = num[N-1];
			long cost = 0;
			for(int i = N-2; i>=0; i--) {
				if(num[i] > max)
					max = num[i];
				else if(num[i] < max)
					cost += max - num[i];
			}
			System.out.printf("#%d %d\n",tc, cost);
		}
	}
}
