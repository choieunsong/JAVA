package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_B2_3040 {
	
	/**
	 *백설공주와 일곱 난쟁이 
	 * */
	
	static int[] input = new int[9];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<9; i++)
			input[i] = sc.nextInt();
		
		find(0, 0, 0, 0);
	}
	
	private static void find(int idx, int start, int flag, int sum) {
		if(idx == 7) {
			if(sum == 100) {
				for(int i=0; i<9; i++) {
					if((flag & 1<<i) != 0) 
						System.out.println(input[i]);
				}
			}
			return;
		}
		for(int i=start; i<9; i++) {
			if((flag & 1<<i) != 0)
				continue;
			find(idx+1, i+1, flag | 1<<i, sum + input[i]);
		}
	}

}
