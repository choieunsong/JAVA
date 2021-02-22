package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B2_13300_방배정 {
	static int[][] stu = new int[7][2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int sex, ban;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			sex = Integer.parseInt(st.nextToken());
			ban = Integer.parseInt(st.nextToken());
			stu[ban][sex]++;
		}
		
		int cnt = 0;
		for(int i=1; i <= 6; i++) {
			for(int j=0; j<2; j++) {
				cnt += stu[i][j] / K;
				if(stu[i][j] % K != 0)
					cnt++;
			}
		}
		System.out.println(cnt);
	}

}
