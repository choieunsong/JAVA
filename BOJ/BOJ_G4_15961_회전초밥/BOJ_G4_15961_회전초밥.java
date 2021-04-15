package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_15961_회전초밥 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] sushi = new int[N];
		int[] used = new int[d+1];
		used[c] = 1;
		
		for(int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(in.readLine());
		}
		int max = 0, cnt = 1;
		for(int i = 0; i < k; i++) {
			if(sushi[i] == c)	continue;
			if(used[sushi[i]] == 0) cnt++;
			used[sushi[i]]++;
		}
		
		for(int i = 1; i < N; i++) {
			// 앞에거 제거 
			if(sushi[i-1] != c) {
				if(used[sushi[i-1]] == 1)	cnt--;
				used[sushi[i-1]]--;
			}
			// 뒤에거 추가
			int back = (i+k-1) % N;
			if(sushi[back] != c) {
				if(used[sushi[back]] == 0)	cnt++;
				used[sushi[back]]++;
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}

}
