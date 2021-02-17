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
 * 1661 미로 탈출 로봇 dfs로 풀기 
 * */

public class Main_1661_최은송2 {
	static int map[][];
	static int x, y, startX, startY, destX, destY;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in  = new BufferedReader(new StringReader(inputData));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		x = Integer.parseInt(st.nextToken().trim());
		y = Integer.parseInt(st.nextToken().trim());
		map = new int[y+1][x+1];
		
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
		
		map[startY][startX] = 1;
		dfs(startY, startX);
		System.out.println(map[destY][destX] - 1);
		
		
	}
	
	private static void dfs(int r, int c) {
		//만약 도착지점에 도달하면 return
		if(r == destY && c == destX) {
			return;
		}
		int nr, nc=0;
		int dist = map[r][c];
		//사방탐색하다 0인데가 나오면 다시 dfs
		for(int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			//1이 아니고 방문한 적 없는 경로 
			if(0 < nr && nr <= y && 0 < nc && nc <= x && map[nr][nc] == 0 || map[nr][nc] > dist+1) {
				map[nr][nc] = dist+1;
				dfs(nr, nc);
			}
		}
		
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


