package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * SWEA 1218 괄호 맞추기 
 * 스택 
 * */

public class Solution_D4_1218_최은송 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/swea/1218/1218.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		
		for(int testCase = 1; testCase <= 10; testCase++) {
			int N = Integer.parseInt(in.readLine());
			Stack<Character> stack = new Stack<Character>(); 
			String line = in.readLine();
			
			for(int i=0; i<N; i++) {
				char c = line.charAt(i);
				if(c ==')' && !stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				}else if(c ==']' && !stack.isEmpty() && stack.peek() == '[') {
					stack.pop();
				}else if(c == '}' && !stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
				}else if(c == '>' && !stack.isEmpty() && stack.peek() == '<') {
					stack.pop();
				}else {
					stack.push(c);
				}
			}
			
			System.out.printf("#%d %d\n", testCase, stack.isEmpty() ? 1 : 0);
		}

	}
}

