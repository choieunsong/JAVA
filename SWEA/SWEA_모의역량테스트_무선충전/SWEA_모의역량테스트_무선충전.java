package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_모의역량테스트_무선충전 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int M, bcCnt;
	static int[] pathA, pathB, playerA, playerB;
	static BC[] bc;
	static int dr[] = {0,-1,0,1,0};
	static int dc[] = {0,0,1,0,-1};
	
	static class BC{
		int r, c, cover, power;
		public BC(int c, int r, int cover, int power) {
			this.c = c;
			this.r = r;
			this.cover = cover;
			this.power = power;
		}
	}
	
	public static void main(String[] args) throws IOException{
		int TC = Integer.parseInt(in.readLine());
		for(int t=1; t<=TC; t++) {
			init();
			System.out.printf("#%d %d\n",t, move());
		}
	}
	static int move() {
		int power = charge();
		// 움직임
		for(int t = 0; t < M; t++) {
			playerA[0] += dr[pathA[t]];
			playerA[1] += dc[pathA[t]];
			playerB[0] += dr[pathB[t]];
			playerB[1] += dc[pathB[t]];
			power +=  charge();
		}
		// charge 
		return power; 	
	}
	
	static int charge() {
		int maxPower = 0;
		int dist = 0;
		ArrayList<Integer> bcA = new ArrayList<Integer>();
		ArrayList<Integer> bcB = new ArrayList<Integer>();
		for(int i = 0; i < bcCnt; i++) {
			// A의 bc별 충전 가능 
			if(Math.abs(playerA[0] - bc[i].r) + Math.abs(playerA[1] - bc[i].c) <= bc[i].cover)
				bcA.add(i);
			// B의 bc별 충전 가능
			if(Math.abs(playerB[0] - bc[i].r) + Math.abs(playerB[1] - bc[i].c) <= bc[i].cover)
				bcB.add(i);
		}

		if(bcA.size() == 0 && bcB.size() == 0) {
			return 0;
		}else if(bcB.size() == 0) {
			for(Integer a : bcA) {
				maxPower = Math.max(maxPower, bc[a].power);
			}
		}else if(bcA.size() == 0) {
			for(Integer b : bcB) {
				maxPower = Math.max(maxPower, bc[b].power);
			}
		}else {
			for(Integer a : bcA) {
				for(Integer b : bcB) {
					if(a == b) {
						maxPower = Math.max(bc[a].power, maxPower);
					}else {
						maxPower = Math.max(maxPower, bc[a].power + bc[b].power);
					}
				}
			}
		}
		return maxPower;
	}
	
	static void init() throws IOException{
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		bcCnt = Integer.parseInt(st.nextToken());
		
		pathA = new int[M];
		pathB = new int[M];
		st = new StringTokenizer(in.readLine());
		StringTokenizer st2 = new StringTokenizer(in.readLine());
		for(int i=0; i<M; i++) {
			pathA[i] = Integer.parseInt(st.nextToken());
			pathB[i] = Integer.parseInt(st2.nextToken());
		}
		
		bc = new BC[bcCnt];
		for(int i=0; i<bcCnt; i++) {
			st = new StringTokenizer(in.readLine());
			bc[i] = new BC(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		playerA = new int[2];
		playerB = new int[2];
		playerA[0] = playerA[1] = 1;
		playerB[0] = playerB[1] = 10;
	}
}
