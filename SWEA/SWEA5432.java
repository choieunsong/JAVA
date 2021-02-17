package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * SWEA 5432 쇠막대기 자르기 
 * 스택 
 * */

public class SWEA5432 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		char[] c; 
		
		for(int tc=1; tc<=T; tc++) {
			Stack<Character> stack = new Stack<Character>();
			String line = in.readLine();
			c = new char[line.length()];
			for(int i=0; i<line.length(); i++)
				c[i] = line.charAt(i);
			int cnt=0;
			
			for(int i=0; i<line.length(); i++) {
				if(c[i] == '(') {
					stack.push(c[i]);
				}else if(c[i] == ')' && c[i-1] == '('){		//레이저일때 
					stack.pop();
					cnt += stack.size(); 
				}else if(c[i] == ')' && c[i-1] == ')'){ 	//레이저가 아닐때 
					stack.pop();
					cnt++;
				}
			}
			System.out.printf("#%d %d\n",tc, cnt);
		}
	}

}
