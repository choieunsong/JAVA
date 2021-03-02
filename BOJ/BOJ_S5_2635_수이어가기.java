package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class BOJ_S5_2635_수이어가기 {
	static int max;
	static LinkedList<Integer> result;
	static LinkedList<Integer> arr;
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		result = new LinkedList<Integer>();
		arr = new LinkedList<Integer>();
		max = 0;
		find();
		System.out.println(max);
		for(int i=0; i<result.size(); i++)
			System.out.print(result.get(i) + " ");
	}
	
	static void find() {
		for(int i = N; i>=N/2; i--) {
			arr.add(N);
			dfs(N, i, 1);
			arr.clear();
		}
	}
	static void dfs(int prev, int curr, int cnt) {
		if(curr < 0) {
			if(cnt > max) {
				result.clear();
				for(int i=0; i<arr.size(); i++)
					result.add(arr.get(i));
				max = cnt;
			}
			return;
		}

		arr.add(curr);
		dfs(curr, prev - curr, cnt+1);
	}
}	
