package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_S4_9012_괄호 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine().trim());
		Stack<Character> stack;
		String line;
		Character c;
		
		loop: for(int i=0; i<T; i++) {
			line = in.readLine().trim();
			stack = new Stack<Character>();
			int len = line.length();
			
			for(int j=0; j<len; j++) {
				c = line.charAt(j);
				if(c == '(') stack.push(c);
				else {
					if(!stack.isEmpty())	stack.pop();
					else {
						System.out.println("NO");
						continue loop;
					}
				}
			}
			if(stack.isEmpty())
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	
}
