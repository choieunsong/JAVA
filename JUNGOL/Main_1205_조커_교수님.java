package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1205_조커_교수님 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] data = new int[N];
		int zero = 0;
		for(int i=0; i<N; i++) {
			data[i] = sc.nextInt();
			if(data[i] == 0) zero++;
		}
		// 입력되는게 전부 0일때
		if(zero == N) {
			System.out.println(N);
			return;
		}
		Arrays.sort(data);
		int ans = 0;  // 모든 위치에서 가장 큰 값을 저장할 변수 
		for(int i = zero; i < N; i++) {
			int joker = zero;		//0의 개수 
			int prev = data[i]; 	// 처음 시작 데이터 
			int cnt = 1; 			// 연속 숫자 카운트 
			boolean first = true; 	// 연속되지 않은 첫번째 위치 찾기 
			int k = i+1;			// 비교할 첫번째 위치 
			while(k < N) {
				int curr = data[k];
				if(prev == curr) {	// 값이 같다 
					k++;
				}else if(prev + 1 == curr) { //하나 크다 
					cnt++;
					k++;
					prev = curr;
				}else {		//연속된 수가 아닐 경우에 
					if(first) {
						i = k - 1;
						first = false;
					}
					if(joker == 0 )break;
					joker--;
					cnt++;
					prev++;
				}
			}
			ans = Math.max(ans, cnt + joker);
			if(k == N) break;
		}
		System.out.println(ans);
	}

}
