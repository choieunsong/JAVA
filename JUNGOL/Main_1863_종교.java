package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1863_종교 {
	static int N;
	static int[] parents;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//in = new BufferedReader(new StringReader(input));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		makeSet();
		int a = 0, b = 0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			if(i == parents[i])
				cnt++;
		}
		System.out.println(cnt);
	}
	
	static void makeSet() {
		parents = new int[N+1];
		for(int i=1; i<= N; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot != bRoot) {
			parents[bRoot] = aRoot;
		}
	}
	static String input = "10 9\n" + 
			"1 1\n" + 
			"2 3\n" + 
			"1 4\n" + 
			"1 5\n" + 
			"1 6\n" + 
			"1 7\n" + 
			"1 8\n" + 
			"1 9\n" + 
			"1 10"; 
}
