package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1940 가랏 RC카! 
 * */

public class Solution_D2_1940_최은송 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(in.readLine());
			int v = 0, distance = 0;
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				int cmd = Integer.parseInt(st.nextToken());
				switch(cmd) {
					case 0: 
						distance += v;
						break;
					case 1: 
						int temp = Integer.parseInt(st.nextToken());
						v += temp;
						distance += v;
						break;
					case 2:
						temp = Integer.parseInt(st.nextToken());
						v = v > temp ? v-temp : 0;
						distance += v;
						break;
					default:
						break;
				}
			}
			
			System.out.printf("#%d %d\n",tc, distance);
		}

	}

}
