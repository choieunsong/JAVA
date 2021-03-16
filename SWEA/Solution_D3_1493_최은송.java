package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수의 새로운 연산
 * 그래프 대각선 줄 계차수열로 연산하는거 
 * */

public class Solution_D3_1493_최은송 {
	
	public static class Pos{
		int x;
		int y;
		
		Pos(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	private static Pos valueToPos(int value) {
		int level = 0;
		int gap = 0;
		for(; level <= 300; level++) {
			if(value <= 1 + level * (level + 1) / 2 + level) {
				gap = value - (1 + level * (level + 1) / 2);
				break;
			}
		}
		return new Pos(level - gap + 1, 1 + gap);
	}
	
	private static int posToValue(Pos p) {
		int level = p.y + p.x - 1;
		return level * (level-1) / 2 + p.x;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			String[] pq = in.readLine().trim().split(" ");
			Pos p1 = valueToPos(Integer.parseInt(pq[0]));
			Pos p2 = valueToPos(Integer.parseInt(pq[1]));
			
			int result = posToValue(new Pos(p1.y + p2.y, p1.x + p2.x));
			System.out.printf("#%d %d\n",tc,result);
		}
	}
}
