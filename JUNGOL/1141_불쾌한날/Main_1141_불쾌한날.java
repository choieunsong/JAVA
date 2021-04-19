package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1141_불쾌한날 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long cnt = 0;
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(in.readLine());
		for(int i=0; i<N; i++) {
			int c = Integer.parseInt(in.readLine());
			while(!stack.isEmpty() && stack.peek() <= c) {
				stack.pop();
			}
			cnt += stack.size();
			stack.add(c);
		}
		System.out.println(cnt);
	}

}
