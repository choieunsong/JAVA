package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_G3_2533_사회망서비스 {
	
	static LinkedList<Integer> list[];
	static boolean[] visited;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(input));
		
		N = Integer.parseInt(in.readLine());
		visited = new boolean[N+1];
		list = new LinkedList[N+1];
		
		StringTokenizer st = null;
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			if(list[from] == null)
				list[from] = new LinkedList<Integer>();
			list[from].add(to);
			
			if(list[to] == null)
				list[to] = new LinkedList<Integer>();
			list[to].add(from);
		}
		System.out.println(findMin());
	}
	
	static int findMin() {
		int ans = 0;
		for(int i=1, end = 1<<N; i < end; i++) {
			ans = 0;
			boolean spread = true;
			Arrays.fill(visited, false);
			
			for(int flag = 0; flag < N; flag++) {
				if((i & 1 << flag) != 0) {
					ans++;
					System.out.printf("i: %d, flag: %d, size: %d\n", i, flag, list[flag+1].size());
					for(int v = 0; v < list[flag+1].size(); v++) {
						int adj = list[flag+1].get(v);
						visited[adj] = true;
					}
				}
			}
			System.out.println(Integer.toBinaryString(i));
			for(int j = 1; j < N+1; j++) {
				if(!visited[j]) {
					spread = false;
				}
			}
			if(spread)
				break;
		}
		return ans;
	}
	

}
