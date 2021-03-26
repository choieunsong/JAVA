package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_G5_17070_파이프옮기기1 {
	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String line = in.readLine();
			for(int j=0, k=0; j<N; j++, k+=2) {
				map[i][j] = line.charAt(k) - 48;
			}
		}

		if(map[N-1][N-1] == 1) {
			System.out.println(0);
			return;
		}
		Node start = new Node(0,1,1);
//		System.out.println(bfs(start));	// r좌표, c좌표, 방향(가로: 1, 세로: 2, 대각선: 3)
		System.out.println(dfs(start));	
	}
	
	static int bfs(Node start) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(start);	
		
		int cnt = 0; 
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int r = cur.r, c = cur.c;
			
			if(r == N-1 && c == N-1) {
				cnt++;
				continue;
			}
			
			switch(cur.dir) {
				case 1: 
					if(r < N && c+1 <N && map[r][c+1] == 0)
						q.offer(new Node(r, c+1, 1));
					if(moveDiagonal(r, c))
						q.offer(new Node(r+1, c+1, 3));
					break;
				case 2:
					if(r+1 < N && c <N && map[r+1][c] == 0)
						q.offer(new Node(r+1, c, 2));
					if(moveDiagonal(r, c))
						q.offer(new Node(r+1, c+1, 3));
					break;
				case 3:
					if(r < N && c+1 <N && map[r][c+1] == 0)
						q.offer(new Node(r, c+1, 1));
					if(r+1 < N && c <N && map[r+1][c] == 0)
						q.offer(new Node(r+1, c, 2));
					if(moveDiagonal(r, c))
						q.offer(new Node(r+1, c+1, 3));
					break;
			}	
		}
		return cnt;
	}
	
	static int dfs(Node node) {
		int cnt = 0;
		
		if(node.r == N-1 && node.c == N-1) {
			return 1;
		}
		if(node.dir == 1) { 
			if(node.r < N && node.c+1 <N && map[node.r][node.c+1] == 0) 
				cnt += dfs(new Node(node.r, node.c+1, 1));
			if(moveDiagonal(node.r, node.c))
				cnt += dfs(new Node(node.r+1, node.c+1, 3));
		}
		else if(node.dir == 2) {
			if(node.r+1 < N && node.c <N && map[node.r+1][node.c] == 0)
				cnt += dfs(new Node(node.r+1, node.c, 2));
			if(moveDiagonal(node.r, node.c))
				cnt += dfs(new Node(node.r+1, node.c+1, 3));
		}
		else {
			if(node.r < N && node.c+1 <N && map[node.r][node.c+1] == 0)
				cnt += dfs(new Node(node.r, node.c+1, 1));
			if(node.r+1 < N && node.c <N && map[node.r+1][node.c] == 0)
				cnt += dfs(new Node(node.r+1, node.c, 2));
			if(moveDiagonal(node.r, node.c))
				cnt += dfs(new Node(node.r+1, node.c+1, 3));
		}
		return cnt;
	}
	
	static boolean moveDiagonal(int r, int c) {
		if(r < N && c+1 <N && r+1 < N && c+1 <N && r+1 < N && c <N && map[r][c+1] == 0 && map[r+1][c+1] == 0 && map[r+1][c] == 0)
			return true;
		return false;
	}
	static class Node{
		int r, c, dir;
		public Node(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
}
