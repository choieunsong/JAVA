package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S5_10158_개미 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine(), " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		if(((x+t) / w) % 2 == 0)
			sb.append((x+t) % w);
		else
			sb.append(w - (x+t) % w);
		sb.append(" ");
		
		if(((y + t) / h) % 2 == 0)
			sb.append((y+t) % h);
		else
			sb.append(h - (y+t) % h);
		System.out.println(sb.toString());
	}

}
