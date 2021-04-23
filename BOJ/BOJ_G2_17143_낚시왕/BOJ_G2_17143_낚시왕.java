package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G2_17143_낚시왕 {
	static int R, C, M, king, result, map[][][];
	static Shark[] sharks;
	static int[] dr = {0,-1,1,0,0};
	static int[] dc = {0,0,0,1,-1};
	static class Shark{
		public int r, c, s, d, z, idx;
		public Shark(int r, int c, int s, int d, int z, int idx) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
			this.idx = idx;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M  = Integer.parseInt(st.nextToken());
		
		king = 0;
		result = 0;
		map = new int[R+1][C+1][2];
		sharks = new Shark[M+1];
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			sharks[i] = new Shark(r,c,s,d,z,i);
			map[r][c][0] = i;
			map[r][c][1] = z;
		}
		fishing();
		System.out.println(result);
	}
	static void fishing() {
		while(king++ < C) {
			// 상어 중 낚시왕과 가장 가까운 상어
			int closeIdx = -1, minDist = R+1;
			for(int i = 1; i < sharks.length; i++) {
				if(sharks[i].idx != -1 && sharks[i].c == king) {
					if(sharks[i].r <= minDist) {
						minDist = sharks[i].r;
						closeIdx = i;
					}
				}
			}
			if(closeIdx != -1) {
				sharks[closeIdx].idx = -1;	//잡아먹힘 
				result += sharks[closeIdx].z;
				map[sharks[closeIdx].r][sharks[closeIdx].c][0] = 0;
				map[sharks[closeIdx].r][sharks[closeIdx].c][1] = 0;
			}
			// 상어 이동 
			for(int i=1; i< sharks.length; i++) {
				if(sharks[i].idx == -1)continue;	// 이미 잡은 애거나 먹힌 해 
				int r = sharks[i].r;
				int c = sharks[i].c;
				int speed = sharks[i].s;
				int d = sharks[i].d;
				int size = sharks[i].z;
				
				map[r][c][0] = 0;
				map[r][c][1] = 0;
				int mod = (d == 1 || d == 2) ? R : C;
				speed %= (2 * mod - 2);
				
				for(int j=0; j<speed; j++) {
					if(d == 1 || d == 2) {
						int next = r + dr[d];
						if(next <= 0 || next > R)	d = d == 1 ? 2 : 1;
						r += dr[d];
					}else {
						int next = c + dc[d];
						if(next <= 0 || next > C) d = d == 3? 4 : 3;
						c += dc[d];
					}
				}
				sharks[i] = new Shark(r,c,speed,d,size, i);
			}
			// 이미 해당칸에 상어가 있으면 
			for(int i=1; i< sharks.length; i++) {
				if(sharks[i].idx == -1) continue;
				int r = sharks[i].r;
				int c = sharks[i].c;
				int size = sharks[i].z;
				
				if(map[r][c][1] < size) {
					map[r][c][1] = size;
					if(map[r][c][0] != 0) {			//더 큰놈이 같은 칸에 오면 잡아먹힘. 
						int idx = map[r][c][0];
						sharks[idx].idx = -1;
					}
					map[r][c][0] = i;
				}else {
					sharks[i].idx = -1;
				}
			}
		}
	}
}
