package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_5607_조합 {
	static final long MOD = 1234567891; 
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			System.out.printf("#%d %d\n",t, nCr(N,R));
		}
	}
	static long nCr(int n, int r) {
		if(r == 0)
			return 1L;
		
		long[] fac = new long[n+1];
		fac[0] = 1;
		for(int i=1; i<=n; i++) 	fac[i] = fac[i-1] * i % MOD;
		
		long bottom = (fac[r] * fac[n-r]) % MOD;
		bottom = power(bottom, MOD-2);
		
		return (fac[n] * bottom) % MOD;
	}
	static long power(long x, long y) {
		long res = 1L;
		x = x % MOD;
		while(y > 0) {
			if(y % 2 == 1)
				res = (res * x) % MOD;
			y = y >> 1;
			x = (x * x) % MOD;
		}
		return res;
	}
}
