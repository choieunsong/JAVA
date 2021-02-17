package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_9229 {
	/**
	 * 한빈이와 Spot Mart
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * */
	static int N;
	static int M;
	static int arr[];
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			max = -1;
			arr = new int[N];
			st = new StringTokenizer(in.readLine(), " ");
			
			for(int i=0; i<N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					if(arr[i] + arr[j] <= M)
						max = Math.max(max, arr[i]+arr[j]);
				}
			}
			System.out.printf("#%d %d\n",tc,max);
		}
	}
	

}
