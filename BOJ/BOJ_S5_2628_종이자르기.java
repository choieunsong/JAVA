package boj;

import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Collections;

public class BOJ_S5_2628_종이자르기 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//in = new BufferedReader(new StringReader(input));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int T = Integer.parseInt(in.readLine());
		List<Integer> row = new LinkedList<Integer>();
		List<Integer> col = new LinkedList<Integer>();
		row.add(0);
		row.add(R);
		col.add(0);
		col.add(C);
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(in.readLine(), " ");
			int temp = Integer.parseInt(st.nextToken());
			int cur = Integer.parseInt(st.nextToken());
			if(temp == 0) 
				row.add(cur);
			else
				col.add(cur);
		}
		Collections.sort(row);
		Collections.sort(col);
		
		int maxH = 0, maxW = 0;
		for(int i=1; i<row.size(); i++) {
			maxH = Math.max(maxH, row.get(i) - row.get(i-1));
		}
		for(int i=1; i<col.size(); i++) {
			maxW = Math.max(maxW, col.get(i) - col.get(i-1));
		}
		System.out.println(maxH * maxW);
	}
	static String input = "10 8\n" + 
			"3\n" + 
			"0 3\n" + 
			"1 4\n" + 
			"0 2";
}
