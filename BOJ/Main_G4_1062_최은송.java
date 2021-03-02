package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_1062_최은송 {
	/**
	 * 백준 1062 가르침 
	 * */
	static int N, K;
	static String[] words;
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new String[N];
		
		for(int i=0; i<N; i++) {
			words[i] = in.readLine();
		}
		
		int flag = 0;
		flag = 1<<0 | 1<<2 | 1<<8 | 1<<13 | 1<<19;		//a,c,i,n,t
		
		if(K < 5) {
			System.out.println(0);
		}
		else if(K == 26) {
			System.out.println(N);
		}
		else {
			findWord(5, 0, flag);
			System.out.println(max);
		}
			
	}
	
	private static void findWord(int cnt, int start, int flag) {
		if(cnt == K) {
			int result = 0;
			for(int i=0; i<N; i++) {
				String word = words[i];
				int j=4, end = word.length()-4;
				for( ;j<end; j++) {
					if((flag & 1 << (word.charAt(j)-'a')) == 0)
						break;
				}
				if(j == end)
					result++;
			}
			max = Math.max(result, max);
			return;
		}
		for(int i=start; i<26; i++) {
			if((flag & 1<<i) == 1)	continue;
			findWord(cnt+1, i+1, flag | 1<<i);
		}
	}
	
	
	static String input ="9 8\n" + 
			"antabtica\n" + 
			"antaxtica\n" + 
			"antadtica\n" + 
			"antaetica\n" + 
			"antaftica\n" + 
			"antagtica\n" + 
			"antahtica\n" + 
			"antajtica\n" + 
			"antaktica";
}
