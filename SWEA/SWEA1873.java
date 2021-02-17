package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * SWEA 1873 상호의 배틀필드 
 * 0203 
 * */

public class SWEA1873 {
	
	static int r = 0, c = 0;
	static int dir;
	//				   ^, v, <, >
	static int dr[] = {-1,1, 0,0};
	static int dc[] = {0, 0,-1,1};
	static int R, C;
	static char map[][];
	
	private static int find(char location) {
		switch(location) {
			case '^': return 0; 
			case 'v': return 1; 
			case '<': return 2; 
			case '>': return 3; 
			default: return -1;
		}
	}
	
	private static boolean isInside(int _r, int _c) {
		if(-1 < _r && _r < R && -1 < _c && _c < C) {
			return true;
		}
		return false;
	}
	
	private static void game(String cmds, int cmdLength) {
		for(int i = 0; i < cmdLength ; i++) {
			char cmd = cmds.charAt(i);
			switch(cmd) {
				case 'U': 
					dir = 0;
					int nr = r + dr[dir];
					int nc = c + dc[dir];
					if(isInside(nr, nc)) {
						if(map[nr][nc] == '.') {
							map[r][c] = '.';
							r--;
						}
					}
					map[r][c] = '^';
					break;
				case 'D':
					dir = 1;
					nr = r + dr[dir];
					nc = c + dc[dir];
					if(isInside(nr, nc)) {
						if(map[nr][nc] == '.') {
							map[r][c] = '.';
							r++;
						}
					}
					map[r][c] = 'v';
					break;
				case 'L':
					dir = 2;
					nr = r + dr[dir];
					nc = c + dc[dir];
					if( isInside(nr, nc)) {
						if(map[nr][nc] == '.') {
							map[r][c] = '.';
							c--;
						}
					}
					map[r][c] = '<';
					break;
				case 'R':
					dir = 3;
					nr = r + dr[dir];
					nc = c + dc[dir];
					if(isInside(nr, nc)) {
						if(map[nr][nc] == '.') {
							map[r][c] = '.';
							c++;
						}
					}
					map[r][c] = '>';
					break;
				case 'S':
					int bulletR = r + dr[dir];
					int bulletC = c + dc[dir];
					while(isInside(bulletR, bulletC)) {
						if(map[bulletR][bulletC] == '#') {
							break;
						}else if(map[bulletR][bulletC] == '*') {
							map[bulletR][bulletC] = '.';
							break;
						}
						bulletR += dr[dir];
						bulletC += dc[dir];
					}
					break;
				default: break;
			}
		}
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int testCase = 1; testCase <= T; testCase++) {
			R = sc.nextInt();
			C = sc.nextInt();
						
			map = new char[R][C];
			sc.nextLine();
			for(int i=0; i<R; i++) {
				String line = sc.nextLine();
				for(int j=0; j < C; j++) {
					map[i][j] = line.charAt(j);
					if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>' ) {
						r = i;
						c = j;
						dir = find(map[i][j]);
					}
				}
			}
		
			int cmdLength = sc.nextInt();
			sc.nextLine();
			String cmds = sc.nextLine();
			
			game(cmds, cmdLength);
			
			System.out.printf("#%d ",testCase);
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	
				
	}

}
