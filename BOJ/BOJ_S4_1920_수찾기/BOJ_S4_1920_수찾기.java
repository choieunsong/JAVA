package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S4_1920_수찾기 {
	static int N, a[], M, b[];
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		a = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i <N; i++)
			a[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(a);
		
		M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i <M; i++) {
			int key = Integer.parseInt(st.nextToken());
			System.out.println(binarySearch(key));
		}
	}
	
	static int binarySearch(int key) {
		int left = 0;
		int right = N-1;
		int mid = 0;
		
		while(left <= right) {
			mid = (left + right) / 2;
			
			if(key == a[mid]) {
				return 1;
			}
			if(key < a[mid]) {
				right = mid-1;
			}else {
				left = mid+1;
			}
		}
		return 0;
	}
}
