package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_모의역량테스트_활주로건설_최적화 {
	static int N, X, map[][], tmap[][];
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		for(int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			tmap = new int[N][N];
			
			for(int i = 0; i <N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<N; j++) {
					tmap[j][i] = map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.printf("#%d %d\n",t, process());
		}
	}
	static int process() {
		int count = 0;
		for(int i=0; i<N; i++) {
			if(makeRoad(map[i])) 	++count;
			if(makeRoad(tmap[i]))	++count;
		}
		return count;
	}
	
	static boolean makeRoad(int[] road) {
		int beforeHeight = road[0], size = 0;
		int j = 0;	//탐색열 위치 
		while(j<N) {
			if(beforeHeight == road[j]) {
				++size;
				++j;
			}
			else if(beforeHeight+1 == road[j]) {	// 오르막 경사로 설치 가능한지 판단 
				if(size <X)	return false; //경사로 설치 불가 
				beforeHeight++;
				size = 1;
				++j;
			}else if(beforeHeight-1 == road[j]) {
				int count = 0;
				for(int k=j; k<N; k++) {
					if(road[k] != beforeHeight-1) break;
					if(++count==X) break;
				}
				if(count < X)	return false; //경사로 설치 불가
				beforeHeight--;
				size=0;
				j += X;
			}else {
				return false;
			}
		}
		return true;
	}
}
