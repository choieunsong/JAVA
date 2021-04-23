package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_G2_1208_부분수열의합2 {
	static int N, S, arr[], half, result;
	static HashMap<Integer, Integer> map = new HashMap<>();
	
	static void leftArr(int sum, int idx) {
		if(idx == half) {
			int cnt = map.containsKey(sum) ? map.get(sum) + 1 : 1;
			map.put(sum, cnt);
			return;
		}
		leftArr(sum, idx+1);
		leftArr(sum + arr[idx], idx+1);
	}
	
	static void rightArr(int sum, int idx) {
		if(idx == N) {
			System.out.println(sum);
			int cnt = map.containsKey(S-sum) ? map.get(S-sum) : 0;
			result += cnt;
			return;
		}
		rightArr(sum, idx+1);
		rightArr(sum + arr[idx], idx+1);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		half = N/2;
		result = 0;
		
		arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		leftArr(0, 0);
		rightArr(0, half);
 		if(S == 0)	result -= 1;
		System.out.println(result);
	}
}
 