package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_5604_구간합 {
	static long digit[], start, end, multi;
	
	static void plusDigit(long num) {
		for(long i = num; i > 0; i /= 10) {
			String str = Long.toString(i);
			int n = str.charAt(str.length()-1) - '0';
			digit[n] += multi;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			start = Long.parseLong(st.nextToken());
			end = Long.parseLong(st.nextToken());
			multi = 1;
			digit = new long[10];
			
			start = start == 0 ? 1 : start;
			while(start <= end) {
//				1. start 일의 자리 0으로 맞추기 
				while(start % 10 != 0 && start <= end) {
					plusDigit(start);
					start++;
				}
				if(start>end) break;
//				2. end 일의 자리 0으로 맞추기 
				while(end % 10 != 9 && start <= end) {
					plusDigit(end);
					end--;
				}
//				3. end / 10 - start / 10 + 1만큼 자리수에 더해주기 
				long diff = end/10 - start/10 + 1;
				for(int i=0; i<10; i++)
					digit[i] += diff * multi;
				multi *= 10;
				start /= 10;
				end /= 10;
			}
			long result = 0;
			for(int i=1; i<10; i++)
				result += i*digit[i];
			System.out.printf("#%d %d\n",t,result);
		}

	}

}
