package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_G2_12015_가장긴증가하는부분수열2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] LIS = new int[N];
		for(int i=0; i<N; i++) 	arr[i] = sc.nextInt();
		
		
		int size = 0;
		LIS[size++] = arr[0];
		for(int i=1; i<N; i++) {
			
			int insertionPoint = Arrays.binarySearch(LIS, 0, size, arr[i]);
			if(insertionPoint < 0) 
				insertionPoint = Math.abs(insertionPoint) - 1;

			LIS[insertionPoint] = arr[i];
			
			if(insertionPoint == size) {
				size++;
			}
		}
		System.out.println(size);
	}

}
