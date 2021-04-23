package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G2_1208_부분수열의합 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
				
		int half = N/2;
		int[] left = new int[1<<half];
		int[] right = new int[1<<(N-half)];

		// 왼쪽 배열 만들기 
		for(int i=0, end = 1<<half; i<end; i++) {
			for(int j = 0; j < half; j++) {
				if((i & 1 << j) != 0) {
					left[i] += new Integer(arr[j]);
				}
			}
		}
		// 오른쪽 배열 만들기 
		for(int i=0, end=1<<(N-half); i<end; i++) {
			for(int j=0; j<N-half; j++) {
				if((i & 1<<j) != 0) {
					right[i] += new Integer(arr[half+j]);
				}
			}
		}
		Arrays.sort(left);
		Arrays.sort(right);
		// leftArr[i] + rightArr[j] = S가 되는 개수 세기 
		long result = 0;
		int l = 0, r = right.length-1, llen = left.length;
		while(l < llen && r > 0) {
			int sum = left[l] + right[r];
			if(sum == S) {
				long lcnt = 1, rcnt= 1;
				l++; r--;
				
				while(l < llen && left[l-1] == left[l]) {
					lcnt++;
					l++;
				}
				while(r > -1 && right[r+1] == right[r]) {
					rcnt++;
					r--;
				}
				result += lcnt * rcnt;
			}
			if(sum < S) {	// 합이 S보다 작으면 작은쪽을 하나 늘려준다. 
				l++;
			}
			if(sum > S){				// 합이 S보다 크면 큰쪽을 하나 줄여준다. 
				r--;
			}
		}
		if(S == 0) result--;
		System.out.println(result);
	}
}
/**
7 3
-4 -1 0 1 2 3 4
**/
 
 