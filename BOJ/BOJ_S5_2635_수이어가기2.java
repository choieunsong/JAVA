package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 시뮬레이션, 완전탐색 
 * 
 * 최적화: 최대로 만들 수 있는 두번째 숫자를 저장하면 input을 계속 업데이트 안해도 됨! 
 * 
 * 다시 풀어본 버전
 * find()에서 i=N-1 했더니 틀렸다.
 * 이유는 1 1 0이면 3이 가장 크게 되기 때문에
 * */

public class BOJ_S5_2635_수이어가기2 {	
	static int max = 0;
	static List<Integer> input;
	static List<Integer> result;
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		input = new LinkedList<Integer>();
		result = new LinkedList<Integer>();
		find();
		
		System.out.println(max);
		for(int i=0; i<result.size(); i++)
			System.out.print(result.get(i)+" ");
	}
	
	static void find() {
		for(int i=N; i>=N/2; i--) {
			input.add(N);
			dfs(N, i, 1);
			input.clear();
		}
	}
	
	static void dfs(int prev, int curr, int cnt) {
		if(curr < 0) {
			if(cnt > max) {
				max = cnt;
				result.clear();
				for(int i=0; i<input.size(); i++)
					result.add(input.get(i));
			}
			return;
		}
		
		input.add(curr);
		dfs(curr, prev-curr, cnt+1);
	}
}	
