package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * SWEA 0204 암호 생성기 
 * 큐 
 * */

public class Solution_D3_0204_최은송 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/swea/0204/0204.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(in.readLine());
			Queue<Integer> q = new LinkedList<Integer>();
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int i=0; i<8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			int num=1;
			while(num != 0) {
				for(int i=1; i<6; i++) {
					num = q.poll() - i;
					if(num <= 0) {
						num = 0;
					}
					q.offer(num);
					if(num == 0)	break;
				}
			}
			
			System.out.printf("#%d ",T);
			for(int i=0; i<8; i++) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();
		}

	}
	

}
