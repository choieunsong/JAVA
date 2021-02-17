package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 정올 1141 불쾌한 날 
 * 0205
 * 스택 
 * 입력: 8만개. Scanner 쓰면 안됨 
 * */

public class Main_1141_최은송 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int height[] = new int[N];
		for(int i=0; i<N; i++)
			height[i] = Integer.parseInt(in.readLine());
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		for(int i=0; i<N; i++) {
			while(!stack.isEmpty()) {
				if(stack.peek() >  height[i]) {
					break;
				}
				stack.pop();
			}
			sum += stack.size();
			stack.push(height[i]);
		}
		System.out.println(sum);
	}

}
