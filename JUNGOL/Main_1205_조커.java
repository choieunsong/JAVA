package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1205_조커 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine().trim());
		List<Integer> arr = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(in.readLine().trim(), " ");
		int cnt0 = 0;
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num == 0) {
				cnt0++;
			}
			else
				arr.add(num);
		}
		Collections.sort(arr);
//		for(Integer a : arr)
//			System.out.println(a);
		System.out.println("cnt0: "+cnt0);
		if(cnt0 == N) {
			System.out.println(N);
			return;
		}
			
		int max = 0,len = 0, joker, next;
		for(int i=0; i<arr.size()-1; i++) {
			int curr = arr.get(i);
			len = 1;
			joker = cnt0; 
			for(int j=i+1; j<arr.size(); j++) {
				next = arr.get(j);
				if(curr == next) {
					curr = next;
				}
				if(next-curr == 1) {
					len++;
					curr = next;
				}else if(next-curr-1 <= joker) {
					joker -= next-curr-1;
					len += next-curr;
					curr = next;
				}
				else if(next-curr-1 > joker) {
					if(joker != 0) {
						len += joker;
					}
					break;
				}
				if(j==arr.size()-1 && joker > 0) {
					if(joker != 0) {
						len += joker;
					}
					break;
				}
			}
			max = Math.max(max, len);
		}
		System.out.println(max);
	}

}
