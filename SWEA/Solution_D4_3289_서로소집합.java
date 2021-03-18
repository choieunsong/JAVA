package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution_D4_3289_서로소집합 {
	static int[] parents;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		int T = Integer.parseInt(in.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			StringBuilder sb = new StringBuilder();
			sb.append("#"+t+" ");
			
			makeSet();
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int cmd = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				switch (cmd) {
				case 0:
					union(a, b);
					break;
				case 1:
					int aRoot = findSet(a);
					int bRoot = findSet(b);
					int result = aRoot == bRoot ? 1 : 0;
					sb.append(result);
					break;
				}
			}
			System.out.println(sb.toString());
		}
	}
	static void makeSet() {
		parents = new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a] == a)	return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot != bRoot) {
			parents[bRoot] = aRoot;
		}
	}
	static String input = "1\n" + 
			"7 8\n" + 
			"0 1 3\n" + 
			"1 1 7\n" + 
			"0 7 6\n" + 
			"1 7 1\n" + 
			"0 3 7\n" + 
			"0 4 2\n" + 
			"0 1 1\n" + 
			"1 1 1";
}
