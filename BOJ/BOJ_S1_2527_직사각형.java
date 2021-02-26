package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S1_2527_직사각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(input));
		int x1, y1, x2, y2, tx1, ty1, tx2, ty2;
		for(int t=0; t<4; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            tx1 = Integer.parseInt(st.nextToken());
            ty1 = Integer.parseInt(st.nextToken());
            tx2 = Integer.parseInt(st.nextToken());
            ty2 = Integer.parseInt(st.nextToken());

           if((x1 == tx2 && y1 == ty2) || (x2 == tx1 && y1 == ty2) || (x2 == tx1 && y2 ==ty1) || (x1 ==  tx2 && y2 == ty1))
        	   System.out.println("c");
           else if((x1 == tx2 && y2 != ty1) || (x2 == tx1 && y2 != ty1) || (y1 == ty2 && x2 != tx1) || ((y2 == ty1 && x1 != tx2)))
        	   System.out.println("b");
           else if(x1 > tx2 || x2 < tx1 || y1 > ty2 || y2 < ty1)
        	   System.out.println("d");
           else
        	   System.out.println("a");
		}

	}
	static String input = "3 10 50 60 100 100 200 300\n" + 
			"45 50 600 600 400 450 500 543\n" + 
			"11 120 120 230 50 40 60 440\n" + 
			"35 56 67 90 67 80 500 600";
}
