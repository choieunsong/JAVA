package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * S2 외계인의 기타 연주 
 * */

public class BOJ_S2_2841 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer>[] line = new Stack[7];
		
		String[] input = in.readLine().trim().split(" ");
		int N = Integer.parseInt(input[0]);
		int P = Integer.parseInt(input[1]);
		
		for(int i=1; i<7; i++)
			line[i] = new Stack<Integer>();
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			String[] play = in.readLine().trim().split(" ");
			int ln = Integer.parseInt(play[0]);
			int prat = Integer.parseInt(play[1]);
			
			// 멜로디가 비었을 때 
			if(line[ln].isEmpty()) {
				cnt++;
				line[ln].push(prat);
				
			}else {
				// 이전 프랫 > 현재 프랫
				while(!line[ln].isEmpty() && line[ln].peek() > prat) {
					cnt++;
					line[ln].pop();
				}
				// 이전 프랫 < 현재 프랫. 4 5 7 4 에서 5,7을 pop했을 때 peek()이 현재 프랫과 같을 수 있음. 그러면 cnt++ 하면 안됨. 그렇기 때문에 if로 조건을 걸어줘야 함 
				if(line[ln].isEmpty() || line[ln].peek() < prat) {
					line[ln].push(prat);
					cnt++;
				}
				// 이전프랫 == 현재 프랫
				if(line[ln].peek() == prat)	continue;
			}
		}
		System.out.println(cnt);
	}

}
