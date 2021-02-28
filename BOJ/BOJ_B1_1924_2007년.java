package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B1_1924_2007년 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim(), " ");
		int month = Integer.parseInt(st.nextToken());
		int date = Integer.parseInt(st.nextToken());
		int sum=0;
		for(int i=1; i<month; i++) {
			if(i == 4 || i == 6 ||i == 9 || i == 11)
				sum += 30;
			else if(i == 2)
				sum += 28;
			else
				sum += 31;
		}
		sum += date;
		String day = null;
		switch(sum % 7) {
			case 0 : day = "SUN"; break;
			case 1 : day = "MON"; break;
			case 2 : day = "TUE"; break;
			case 3 : day = "WED"; break;
			case 4 : day = "THU"; break;
			case 5 : day = "FRI"; break;
			case 6 : day = "SAT"; break;
		}
		System.out.println(day);
	}

}
