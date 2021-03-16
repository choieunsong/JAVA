package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 모의역량테스트 요리사 
 * 조합, 재귀?
 * */

public class SWEA_모의역량테스트_요리사 {
	static int[][] table;
	static int N;
	static int div;
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<= T; tc++) {
			N = Integer.parseInt(in.readLine());
			div = N/2;
			table = new int[N][N];
			min = Integer.MAX_VALUE;
			StringTokenizer st;
			for(int i=0; i < N; i++) {
				st = new StringTokenizer(in.readLine().trim(), " ");
				for(int j=0, end=st.countTokens(); j<end; j++)
					table[i][j] = Integer.parseInt(st.nextToken());
			}
			combi(0,0,0);
			System.out.printf("#%d %d\n",tc,min);
		}
	}
	
	public static void combi(int cnt, int start, int flag) {
		if(cnt == div) {
			int sumA = 0, sumB = 0, idx1 = 0, idx2 = 0;
			int[] A = new int[div];
			int[] B = new int[div];
			for(int i=0; i<N; i++) {
				if((flag & 1<<i) != 0) 
					A[idx1++] = i;
				else
					B[idx2++] = i;
			}
			for(int i=1; i<div; i++) {
				for(int j=0; j<i; j++) {
					sumA += table[A[i]][A[j]];
					sumA += table[A[j]][A[i]];
					sumB += table[B[i]][B[j]];
					sumB += table[B[j]][B[i]];
				}
			}
			int diff = Math.abs(sumA - sumB);
			min = Math.min(diff, min);
			return;
		}
		for(int i=start; i<N; i++) {
			if((flag & 1<<i) != 0)	continue;
			combi(cnt+1, i+1, flag | 1<<i);
		}
	}
}

/**
 * public static void combi(int idx,int start,int flag) {
		if(idx==N/2) {
			int sum1=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(j==i) continue;
					if((flag&1<<i)!=0&&(flag&1<<j)!=0) sum1+=ingredients[i][j];
					else if((flag&1<<i)==0&&(flag&1<<j)==0) sum1-=ingredients[i][j];
				}
			}
			sum1=Math.abs(sum1);
			min=min<sum1?min:sum1;
			return;
		}
		
		for(int n=start;n<N;n++) {
			if((flag&1<<n)!=0) continue;
			combi(idx+1,n+1,flag|1<<n);
		}
	}
 * */
