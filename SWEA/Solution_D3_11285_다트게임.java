package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;


public class Solution_D3_11285_다트게임 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(input));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			int sum = 0;
			
			for(int i = 0; i < N; i++) {
				String[] line = in.readLine().split(" ");
				int r = Integer.parseInt(line[0]);
				int c = Integer.parseInt(line[1]);
				double dist = Math.sqrt(r*r + c*c);
//				System.out.printf("%d, r: %d, c: %d, dist: %d\n",i, r, c, dist);
				if( dist > 200.0) continue;
				int score = (int)(11 - Math.ceil(dist) / 20);
				if(score > 10)	score = 10;
				sum += score;
			}
			System.out.printf("#%d %d\n", tc, sum);
		}
		

	}
	static String input = "1\n" + 
			"5\n" + 
			"80 -14\n" + 
			"117 12\n" + 
			"98 -69\n" + 
			"-86 21\n" + 
			"-121 99";
}
