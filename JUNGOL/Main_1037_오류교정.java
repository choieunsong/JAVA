package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main_1037_오류교정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] check = new int[N][2];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(sc.nextInt() == 1) {
					check[i][0]++;
					check[j][1]++;
				}
			}
		}
		int oddRCnt = 0, oddCCnt = 0;
		int oddR = 0, oddC = 0;
		for(int i=0; i<N; i++) {
			if(check[i][0] % 2 == 1) {		//i행이 홀수 합
				oddRCnt++;
				oddR = i;
			}
			if(check[i][1] % 2 == 1) {		//i열이 홀수 합
				oddCCnt++;
				oddC = i;
			}
			if(oddRCnt > 1 || oddCCnt > 1) {			//홀수인 열이나 행이 1개 초과면 corrupt
				System.out.println("Corrupt");return;
			}
		}
		if(oddRCnt + oddCCnt == 0) {
			System.out.println("OK");
		}else {
			System.out.printf("Change bit (%d %d)\n",oddR+1, oddC+1);
		}
			
	}

}
