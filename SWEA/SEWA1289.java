package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SEWA1289 {

	public static void main(String[] args) throws Exception{
		//파일로 읽기
//		System.setIn(new FileInputStream("res/swea/d3/test.txt"));
		
		//콘솔로 읽기
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		
		
		for (int testCase = 1; testCase <= T; testCase++) {
			String data = in.readLine();
			int size = data.length();
			int N=0;
			if(data.startsWith("1")){
				N++;
			}
			for(int i=0; i<size-1; i++) {
				if(data.charAt(i) != data.charAt(i+1)) {
					N++;
				}
			}
			
			System.out.printf("#%d %d\n",testCase, N);
		}	
	}
}

