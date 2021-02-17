package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 S3 배열 돌리기 3
 * */

public class BOJ_S3_16935 {
	static int[][] arr = new int[100][100];
	static int[][] arr2 = new int[100][100];
	static int N,M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int cmds[] = new int[R];
		
		for(int i = 0; i < N; i++) {
			String line = in.readLine();
			for(int j = 0, idx = 0; j < M; j++,idx += 2 ) {
				arr[i][j] = line.charAt(idx) - '0';
			}
		}
		st = new StringTokenizer(in.readLine(), " ");
		for(int i=0; i<R; i++)
			cmds[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<R; i++) {
			switch(cmds[i]) {
				case 1: 
					one();
					break;
				case 2:
					two();
					break;
				case 3:
					three();
					break;
				case 4:
					four();
					break;
				case 5:
					five();
					break;
				case 6:
					six();
					break;
				default: break;
			}
		}
		print();
	}
	
	
	private static void one() {
		// 상하반전 
		int k = N / 2, temp = 0;
		for(int i = 0; i < k; i++) {
			for(int j=0; j < M; j++) {
				temp = arr[i][j];
				arr[i][j] = arr[N-1-i][j];
				arr[N-1-i][j] = temp; 
			}
		}
	}
	
	private static void two() {
		// 좌우반전 
		int k = M / 2, temp = 0;
		for(int i = 0; i < N; i++) {
			for(int j=0; j < k; j++) {
				temp = arr[i][j];
				arr[i][j] = arr[i][M-1-j];
				arr[i][M-1-j] = temp; 
			}
		}
	}
	
	private static void three() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++)
				arr2[c][N-1-r] = arr[r][c];
		}
		int temp = N;
		N = M;
		M = temp;
		copyArr();
			
	}
	
	private static void four() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++)
				arr2[M-1-c][r] = arr[r][c];
		}
		int temp = N;
		N = M;
		M = temp;
		copyArr();
			
	}
	
	private static void five() {
		int halfN = N / 2;
		int halfM = M / 2;
		// 1->2
		for(int r=0; r<halfN; r++)
			for(int c=0; c<halfM; c++)
				arr2[r][c + halfM] = arr[r][c];
		//2->3
		for(int r=0; r<halfN; r++)
			for(int c=halfM; c<M; c++)
				arr2[r + halfN][c] = arr[r][c];
		//3->4
		for(int r=halfN; r<N; r++)
			for(int c=halfM; c<M; c++)
				arr2[r][c-halfM] = arr[r][c];
		//4->1
		for(int r=halfN; r<N; r++)
			for(int c=0; c<halfM; c++)
				arr2[r-halfN][c] = arr[r][c];
		copyArr();
	}
	
	private static void six() {
		int halfN = N / 2;
		int halfM = M / 2;
		//1->4
		for(int r=0; r<halfN; r++)
			for(int c=0; c<halfM; c++)
				arr2[r+halfN][c] = arr[r][c];
		//4->3
		for(int r=halfN; r<N; r++)
			for(int c=0; c<halfM; c++)
				arr2[r][c+halfM] = arr[r][c];
		//3->2
		for(int r=halfN; r<N; r++)
			for(int c=halfM; c<M; c++)
				arr2[r-halfN][c] = arr[r][c];
		//2->1
		for(int r=0; r<halfN; r++)
			for(int c=halfM; c<M; c++)
				arr2[r][c-halfM] = arr[r][c];
		copyArr();
	}
	
	private static void print() {
		for(int i=0; i<N; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<M; j++)
				sb.append(arr[i][j]+" ");
			sb.setLength(sb.length()-1);
			System.out.println(sb.toString());
		}
	}
	
	private static void copyArr() {
		for(int r=0; r<N; r++)
			for(int c=0; c<M; c++)
				arr[r][c] = arr2[r][c];
	}
	
}
