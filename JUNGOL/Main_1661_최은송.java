package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1661 미로 탈출 로봇 
 * */

public class Main_1661_최은송 {
	static int map[][];
	static boolean used[][];
	static int x, y, startX, startY, destX, destY;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in  = new BufferedReader(new StringReader(inputData));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		x = Integer.parseInt(st.nextToken().trim());
		y = Integer.parseInt(st.nextToken().trim());
		map = new int[y+1][x+1];
		used = new boolean[y+1][x+1];
		
		st = new StringTokenizer(in.readLine(), " ");
		startX = Integer.parseInt(st.nextToken().trim());
		startY = Integer.parseInt(st.nextToken().trim());
		destX = Integer.parseInt(st.nextToken().trim());
		destY = Integer.parseInt(st.nextToken().trim());
		for(int i=0; i<y; i++) {
			String line = in.readLine();
			for(int j=0; j<x; j++)
				map[i+1][j+1] = line.charAt(j) - 48;
		}
		
		int sol = bfs();
		System.out.println(sol);
	}
	
	private static int bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		int curX = 0, curY = 0, nc = 0, nr = 0, cnt=0;
		queue.offer(new int[] {startY, startX, cnt});
		used[startY][startX] = true;
		
		while(!queue.isEmpty()) {
			curY = queue.peek()[0];
			curX = queue.peek()[1];
			cnt = queue.peek()[2];
			queue.poll();
			if(curY == destY && curX == destX)	return cnt;
			for(int i=0; i<4; i++) {
				nr = curY + dr[i];
				nc = curX + dc[i];
				if(0 < nr && nr <= y && 0 < nc && nc <= x) {
					if(!used[nr][nc] && map[nr][nc] == 0) {
						queue.offer(new int[] {nr,nc, cnt+1});
						used[nr][nc] = true;
					}
				}
			}
		}
		return -1;
	}
	
	static String inputData = "8 7\n" + 
			"1 2 7 5\n" + 
			"11111111\n" + 
			"00000111\n" + 
			"10110011\n" + 
			"10111001\n" + 
			"10111101\n" + 
			"10000001\n" + 
			"11111111";
}


