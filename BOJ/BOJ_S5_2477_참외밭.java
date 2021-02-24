package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S5_2477_참외밭 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(in.readLine());
		
		int lh = 0, lw = 0, sh = 0, sw = 0;
		int map[][] = new int[6][2];
		for(int i=0; i<6; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			map[i][0] = Integer.parseInt(st.nextToken());	// 방향 
			map[i][1] = Integer.parseInt(st.nextToken());	// 길이
		}
		
		for(int i=0; i<6; i++) {
			if(map[i][0] == 1 || map[i][0] == 2)
				lw = Math.max(lw, map[i][1]);
			else
				lh = Math.max(lh, map[i][1]);
		}
		
		for(int i = 0; i < 6; i++) {
			if(map[i][0] == 1 || map[i][0] == 2) {		//동, 서일 인덱스 앞뒤의 변을 체크해서 둘의 합이 lh면 i가 sw 
				if(lh == map[(i+5) % 6][1] + map[(i+1) % 6][1]) { 
					sw = map[i][1]; 
				}
			}else {
				if(lw == map[(i+5) % 6][1] + map[(i+1) % 6][1]) {	//남, 북일때 인덱스 앞뒤의 변을 체크해서 둘의 합이 lw면 i가 sh 
					sh = map[i][1];
				}
			}
		}
		System.out.println((lw * lh - sw * sh) * k);
	}

}
