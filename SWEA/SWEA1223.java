package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 0205
 * SWEA 1223 계산기2
 * */

public class SWEA1223 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(in.readLine());
			Stack<Character> op = new Stack<>();
			String line = in.readLine();
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<N; i++) {
				char c = line.charAt(i);
				if(0 <= c-'0' && c-'0' < 10) {
					sb.append(c);
				}else {
					if(op.isEmpty()) {
						op.push(c);
					}
					else if(op.peek() <= c) {		//*: 42  +:43 현재값과 peek이 같거나 작다면 pop 후에 현재값 push
						sb.append(op.pop());
						op.push(c);
					}else {							// 현재가 *이인데 peek이 + 그냥 push 
						op.push(c);
					}
				}
			}
			while(!op.isEmpty())
				sb.append(op.pop());
			System.out.println(sb.toString());
			
			Stack<Integer> nums = new Stack<>();
			for(int i=0; i<sb.length(); i++) {
				char c = sb.charAt(i);
				if(0 <= c-'0' && c-'0' < 10)
					nums.push(c-'0');
				else {
					int temp1 = nums.pop();
					int temp2 = nums.pop();
					if(c == '+')		nums.push(temp1 + temp2);
					else if(c == '*')	nums.push(temp1 * temp2);
				}
			}
			
			System.out.printf("#%d %d\n",tc,nums.pop());
		}
	}
}
