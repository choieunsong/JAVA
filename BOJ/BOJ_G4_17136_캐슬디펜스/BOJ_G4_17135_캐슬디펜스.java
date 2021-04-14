package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G4_17135_캐슬디펜스 {
	static int R, C, D;
	static final int NUM = 3;
	static int[][] map;
	static int max = Integer.MIN_VALUE;
	static Archer[] archers;
	static class Archer{
		public int r, c;
		public Archer(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static class Enemy implements Comparable<Enemy>{
		public int r, c, dist;
		public Enemy(int r, int c) {
			this.r = r;
			this.c = c;
		}
		public Enemy(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
		@Override
		public int compareTo(Enemy o) {
			return this.dist == o.dist ? Integer.compare(this.c, o.c) : Integer.compare(this.dist,  o.dist);
		}
	}
	public static void main(String[] args) throws IOException{
		init();
		combi(0,0);
		System.out.println(max);
	}
	
	static void combi(int cnt, int start) {
		if(cnt == NUM) {
			//게임, 최소값 갱신
			int enemyCnt = game();
			max = Math.max(max, enemyCnt);
			return;
		}
		for(int i=start; i<C; i++) {
			archers[cnt] = new Archer(R, i);
			combi(cnt+1, i+1);
		}
	}
	static int game() {
		int enemyCnt = 0;
		// 임시 map 
		int[][] tmap = new int[R][C];
		for(int i=0; i<R; i++)
			System.arraycopy(map[i], 0, tmap[i], 0, C);
		while(true) {
			// map에서 적들 저장하기 
			ArrayList<Enemy> enemies = new ArrayList<Enemy>();
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(tmap[i][j] == 1)
						enemies.add(new Enemy(i,j));
				}
			}
			// 적이 없으면 종료 
			if(enemies.size() == 0) {
				break;
			}
			// 각 궁수별로 가장 가까운 적 가져오기
			ArrayList<Enemy> targets = new ArrayList<Enemy>();
			for(int i = 0; i < NUM; i++) {
				Enemy target = findEnemy(archers[i], enemies);
				if(target != null) {
					targets.add(target);
				}
			}
			// map에서 target 지우기 
			for(int i=0; i<targets.size(); i++) {
				Enemy target = targets.get(i);
				if(tmap[target.r][target.c] == 1) {
					tmap[target.r][target.c] = 0;
					enemyCnt++;
				}
			}
			// map에서 적들 한칸씩 이동 
			int[][] temp = new int[R][C];
			Arrays.fill(temp[0], 0);
			for(int i = 0; i < R-1; i++) {
				System.arraycopy(tmap[i], 0, temp[i+1], 0, C);
			}
			
			for(int i=0; i<R; i++)
				System.arraycopy(temp[i], 0, tmap[i], 0, C);
		}
		return enemyCnt;
	}
	static Enemy findEnemy(Archer archer, ArrayList<Enemy> enemies) {
		PriorityQueue<Enemy> pq = new PriorityQueue<Enemy>();
		for(int i=0; i<enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			int dist = Math.abs(archer.r - enemy.r) + Math.abs(archer.c - enemy.c);
			if(dist <= D) {
				pq.offer(new Enemy(enemy.r, enemy.c, dist));
			}
		}
		return pq.poll();
	}
	static void init() throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		archers = new Archer[NUM];
		map = new int[R][C];
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(in.readLine());
			for(int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
