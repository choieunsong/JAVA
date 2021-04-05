package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_P5_14003_가장긴증가하는부분수열5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++)	arr[i] = sc.nextInt();
		
		int[] LIS = new int[N];
		int[] index = new int[N];
		int size = 0;
		LIS[size] = arr[0];
		index[0] = size++;
		
		for(int i=1; i<N; i++) {
			int pos = Arrays.binarySearch(LIS, 0, size, arr[i]);
			if(pos < 0)
				pos = Math.abs(pos) - 1;
			LIS[pos] = arr[i];
			index[i] = pos;
			if(pos == size) 
				size++;
		}
		
		System.out.println(size);
		
		ArrayList<Integer> answer = new ArrayList<Integer>();
		for(int i=N-1; i>-1; i--) {
			if(index[i] == size-1) {
				size--;
				answer.add(arr[i]);
			}
			if(size == -1)
				break;
		}
		int len = answer.size()-1;
		for(int i=len; i>=0; i--)
			System.out.printf("%d ",answer.get(i));
	}
}
