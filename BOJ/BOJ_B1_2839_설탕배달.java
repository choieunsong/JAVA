package boj;

import java.util.Scanner;

/**
 * 백준 B1 2839 설탕배달 
 * */
public class BOJ_B1_2839_설탕배달 {
	static int min = Integer.MAX_VALUE; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
//		int cnt = 0;
//		while(N > 0) {
//			if(N % 5 == 0) {
//				cnt = cnt + (N / 5);
//				break;
//			}
//			N -= 3;
//			cnt++;
//			if(N < 0) {
//				cnt = -1;
//				break;
//			}
//		}
//		System.out.println(cnt);
		
		backtracking(N, 0);
		System.out.printf("%d\n", min == Integer.MAX_VALUE ? -1 : min);
	}
	
	private static void backtracking(int m, int cnt) {
		if(cnt >= min) return;
		
		if(m < 0) {
			return;
		}else if(m == 0) {
			if(min > cnt) {
				min = cnt;
				return;
			}
		}else {
			backtracking(m-5, cnt+1);
			backtracking(m-3, cnt+1);
		}
	}
}
