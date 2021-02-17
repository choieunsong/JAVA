package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1954 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/1954.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
//				   우,  하, 좌, 상 				
		int dr[] = {0, 1,  0, -1};
		int dc[] = {1, 0, -1, 0};
		
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(in.readLine());
			int arr[][] = new int[N][N];
			
			int x = 0, y = 0, dir = 0;
			for(int i = 0; i < N*N; i++) {
				arr[x][y] = i+1;
				x += dr[dir];
				y += dc[dir];
				
				// 배열을 벗어났거나, 이미 입력 처리가 끝난 칸일 경우 방향 전환 
				if(x >= N || x < 0 || y >= N || y < 0 || arr[x][y] != 0) {
					x -= dr[dir];
					y -= dc[dir];
					dir = (dir + 1) % 4;
					x += dr[dir];
					y += dc[dir];
				}
				
			}
			
			System.out.printf("#%d\n",testCase);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			
		}
		
	}

}
