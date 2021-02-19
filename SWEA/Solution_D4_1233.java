package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 사칙연산 유효성 검사 
 * */

public class Solution_D4_1233_최은송 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(in.readLine());
			boolean flag = true;
			StringTokenizer st;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				st.nextToken();
				
				if(!flag)	continue;
				String node = st.nextToken();	
				
				if(node.equals("+") || node.equals("-") || node.equals("*") || node.equals("/")) {
					if(!st.hasMoreTokens())
						flag = false;
				}else {
					if(st.hasMoreTokens())
						flag = false;
				}
			}
			System.out.printf("#%d %d\n", tc, flag ? 1 : 0);
		}

	}

}
