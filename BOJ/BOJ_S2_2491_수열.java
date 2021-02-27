package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ_S2_2491_수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(input));
		int N = Integer.parseInt(in.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine().trim(), " ");
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int max = 1;
		int len = 1;
		// 내림차순 구하기 
		for(int i=1; i<N; i++) {
			if(arr[i-1] >= arr[i]) len++;
			else 	len = 1;
			max = Math.max(max, len);
		}
		len = 1;
		// 오름차순 구하기
		for(int i=1; i<N; i++) {
			if(arr[i-1] <= arr[i])	len++;
			else	len=1;
			max = Math.max(max, len);
		}
		System.out.println(max);
	}
	static String input = "9\n"
			+ "4 1 3 3 2 2 9 2 3";
}
