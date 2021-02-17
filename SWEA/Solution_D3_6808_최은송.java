package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 6808 규영이와 인영이의 카드게임 
 * 순열 
 * */
public class Solution_D3_6808_최은송 {
	static int[] kyuyoung;
	static int[] inyoung;
	static int[] inyoung_choice;
	static int win = 0;
	static int lose = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));

		int T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			kyuyoung = new int[9];
			inyoung = new int[9];
			inyoung_choice = new int[9];
			boolean[] used = new boolean[19];
			win = 0; 
			lose = 0;
			
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int i=0; i<9; i++) {
				kyuyoung[i] = Integer.parseInt(st.nextToken());
				used[kyuyoung[i]] = true;
			}
			for(int i=1, cnt=0; i<19; i++) {
				if(!used[i])
					inyoung[cnt++] = i;
			}
			game(0,0);
			System.out.printf("#%d %d %d\n",tc,win,lose);
		}
	}
	
	private static void game(int cnt , int flag) {
		if(cnt == 9) {
			int k_sum = 0, i_sum = 0;
			for(int i=0; i<9; i++) {
				if(kyuyoung[i] > inyoung_choice[i])
					k_sum += kyuyoung[i] + inyoung_choice[i];
				else
					i_sum += kyuyoung[i] + inyoung_choice[i];
			}
			if(k_sum > i_sum)
				win++;
			else if(k_sum < i_sum)
				lose++;
			return;
		}
		for(int i=0; i<9; i++) {
			if((flag & 1<<i) == 0) {
				inyoung_choice[cnt] = inyoung[i];
				game(cnt+1, flag | 1<<i);
			}
		}
	}
	
	
	static String input = "4\n" + 
			"1 3 5 7 9 11 13 15 17\n" + 
			"18 16 14 12 10 8 6 4 2\n" + 
			"13 17 9 5 18 7 11 1 15\n" + 
			"1 6 7 9 12 13 15 17 18";
}
