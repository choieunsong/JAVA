package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 암호문1
 * */

public class Solution_D3_1228_최은송 { 
	static Queue<String> q1 = new LinkedList<String>();
	static Queue<String> q2 = new LinkedList<String>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1; tc<=10; tc++) {
			q1.clear();
			q2.clear();
			int N = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int i=0,end=st.countTokens(); i<end; i++) {
				q1.offer(st.nextToken());
			}
			int cmdCnt = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine()," ");
			int cnt = 0;
			while(cnt != cmdCnt) {
				if(st.nextToken().equals("I")) {
					cnt++;
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					//System.out.printf("I: cnt %d, x: %d, y: %d\n", cnt, x, y);
					if(!q1.isEmpty())	insert(x,y,1,st);		// q1에 있던걸 q2에 옮겨라 
					else				insert(x,y,2,st);		// q2에 있던걸 q1에 옮겨라 
				}
			}
			System.out.printf("#%d ",tc);
			if(!q1.isEmpty())	printQ(1);	//q1 출력 
			else				printQ(2);	//q2 출력 
		}
	}
	
	private static void insert(int x, int y, int type, StringTokenizer st) {
		if(type == 1) {
			for(int i = 0; i<x; i++) {
				q2.offer(q1.poll());
			}
			for(int i=0; i<y; i++) {
				q2.offer(st.nextToken());
			}
			while(!q1.isEmpty()) {
				q2.offer(q1.poll());
			}
		}else {
			for(int i = 0; i<x; i++) {
				q1.offer(q2.poll());
			}
			for(int i=0; i<y; i++) {
				q1.offer(st.nextToken());
			}
			while(!q2.isEmpty()) {
				q1.offer(q2.poll());
			}
		}
	}
	
	private static void printQ(int type) {
		// q1 출력 
		if(type == 1) {
			for(int i=0; i<10; i++) {
				System.out.print(q1.poll()+" ");
			}
			System.out.println();
		} // q2 출력 
		else {
			for(int i=0; i<10; i++) {
				System.out.print(q2.poll()+" ");
			}
			System.out.println();
		}
	}

}
