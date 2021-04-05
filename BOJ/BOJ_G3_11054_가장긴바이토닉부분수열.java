package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_G3_11054_가장긴바이토닉부분수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] up = new int[N];
		int[] down = new int[N];
		for(int i=0; i<N; i++)	arr[i] = sc.nextInt();
		
		Arrays.fill(up, 1);
		Arrays.fill(down, 1);
		int max;
		for(int i=1; i<N; i++) {
			max = 0;
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j] && up[j] > max) {
					up[i] = up[j] + 1;
					max = up[j];
				}
			}
		}
		for(int i=N-2; i>0; i--) {
			max = 0;
			for(int j=N-1; j>i; j--) {
				if(arr[i] > arr[j] && down[j] > max) {
					down[i] = down[j] + 1;
					max = down[j];
				}
			}
		}
		
		max = 0;
		for(int i=0; i<N; i++) {
			if(up[i] + down[i] > max) {
				max = up[i] + down[i];
			}
		}
		System.out.println(max-1);
	}

}
