package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_G2_1208_부분수열의합3 {
	static int N, S, arr[];

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int half = N/2;
		ArrayList<Integer> left = new ArrayList<>();
		ArrayList<Integer> right = new ArrayList<>();
		getSubsetList(0, half, 0, left);
		getSubsetList(half, N, 0, right);
		
		Collections.sort(left);
		Collections.sort(right, Collections.reverseOrder());
		
		long cnt = 0, lsum, rsum, sum;
		int l = 0, r = 0, lsize = left.size(), rsize = right.size();
		while(l < lsize && r < rsize) {
			lsum = left.get(l);
			rsum = right.get(r);
			
			sum = lsum + rsum;
			if(sum > S) {
				r++;
				continue;
			}
			if(sum < S) {
				l++;
				continue;
			}
			if(sum == S) {
				long lcnt = 0, rcnt = 0;
				while(r < rsize && lsum + right.get(r) == sum) {
					r++;
					rcnt++;
				}
				while(l < lsize && rsum + left.get(l) == sum) {
					l++; 
					lcnt++;
				}
				cnt += lcnt * rcnt;
			}
		}
		if(S == 0) cnt--;
		System.out.println(cnt);
	}
	static void getSubsetList(int idx, int end, int sum, ArrayList<Integer> list) {
		if(idx == end) {
			list.add(sum);
			return;
		}
		getSubsetList(idx+1, end, sum, list);
		getSubsetList(idx+1, end, sum + arr[idx], list);
	}
}
/**
7 3
-4 -1 0 1 2 3 4
**/
 
 