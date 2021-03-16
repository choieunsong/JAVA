package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1206_View {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(in.readLine());
			int building[] = new int[N+4];
			StringTokenizer st = new StringTokenizer(in.readLine().trim(), " ");
			for(int i=0; i < N; i++)
				building[i] = Integer.parseInt(st.nextToken());
			
			int sum = 0, max = 0;
			for(int i = 2; i < N-2; i++) {
				int curr = building[i];
				if(building[i-1] >= curr || building[i+1] >= curr) {
					continue;
				}else {
					max = Math.max(building[i-1], building[i+1]);
				}
				if(curr > building[i-2] && curr >building[i+2]) {
					int tmax = Math.max(building[i-2], building[i+2]);
					max = Math.max(max, tmax);
					sum += curr - max;
				}
			}
			System.out.printf("#%d %d\n",tc,sum);
		}

	}

}
 