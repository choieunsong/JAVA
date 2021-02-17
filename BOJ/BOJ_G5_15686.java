package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 G5 15686 치킨 배달 
 * */
public class BOJ_G5_15686 {
	static int N;
	static int M;
	static List<int[]> home = new ArrayList<>();
	static List<int[]> chick = new ArrayList<>();
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) 
					home.add(new int[] {i+1, j+1});
				else if(num == 2) 
					chick.add(new int[] {i+1,j+1});
			}
		}
		combi(0,0,0);
		System.out.println(min);
		
	}
	
	private static void combi(int cnt, int start, int flag) {
		if(cnt == M) {
			int sum=0;
			for(int i=0, end=home.size(); i<end; i++) {
				int dist= 100;		// 집과 치킨집 사이 최소거리 
				for(int j=0, cend=chick.size(); j<cend; j++) {
					if((flag & 1<<j) != 0) {
						int temp = Math.abs(home.get(i)[0]-chick.get(j)[0]) + Math.abs(home.get(i)[1]-chick.get(j)[1]);
						dist = Math.min(dist, temp);
					}
				}
				sum += dist;
			}
			min = Math.min(sum, min);
			return;
		}
		for(int i=start, end=chick.size(); i<end; i++) {
			if((flag & 1<<i) != 0)	continue;
			combi(cnt+1, i+1, flag | 1<<i);
		}
	}

}
