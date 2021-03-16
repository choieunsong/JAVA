package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_8382_방향전환 {
	static int x2;
	static int y2;
	static int x1;
	static int y1;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		
		int T = Integer.parseInt(in.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			x1 = Integer.parseInt(st.nextToken()) + 100;
			y1 = Integer.parseInt(st.nextToken()) + 100;
			x2 = Integer.parseInt(st.nextToken()) + 100;
			y2 = Integer.parseInt(st.nextToken()) + 100;
			

			System.out.printf("#%d %d\n",t, bfs(x1, x2));
//			System.out.printf("#%d %d\n",t,calculate());
		}
	}
	
	static int calculate() {
		int cnt = 0;
		int width = Math.abs(x2 - x1);
		int height = Math.abs(y2 - y1);
		
		int sqr = width < height ? width : height;
		int remain = Math.abs(width - height);
		
		cnt += sqr * 2;
		cnt += 2 * remain - (remain %2);
		
		return cnt;
	}
	
	static int bfs(int x1, int y1) {
		boolean[][][] visited = new boolean[201][201][2];
//				right, down, left, up
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, -1, 0, 1};
		
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(x1, y1, 0));
		q.offer(new Point(x1, y1, 1));
		q.offer(new Point(x1, y1, 2));
		q.offer(new Point(x1, y1, 3));
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int s=0; s<size; s++) {
				Point now = q.poll();
				
				if(now.x == x2 && now.y == y2) {
					return cnt;
				}
				for(int d=0; d<4; d++) {
					if(now.dir % 2 != d % 2) {
						int nx = now.x + dx[d];
						int ny = now.y + dy[d];
						
						if(0 <= nx && nx < 201 && 0 <= ny && ny < 201 && !visited[nx][ny][d%2]) {
							visited[nx][ny][d%2] = true;
							q.offer(new Point(nx, ny, d));
						}
					}
				}
				cnt++;
			}
		}
		return cnt;
	}
	
	static  class Point{
		int x, y, dir;
		
		Point(int x, int y, int dir){
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	
	static String input = "3\n" + 
			"0 0 1 0\n" + 
			"-1 -1 0 0\n" + 
			"0 0 0 2";
}
