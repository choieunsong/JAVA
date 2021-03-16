package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*public class Solution_D3_1244_최대상금 {
	static char[] num;
	static int cnt;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(in.readLine().trim());
		for(int tc=1; tc<=C; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine().trim(), " ");
			num = st.nextToken().toCharArray();
			cnt = Integer.parseInt(st.nextToken());
			max = Integer.MIN_VALUE;
			dfs(0, 0);
			System.out.printf("#%d %d\n",tc,max);
		}
	}
	
	private static void dfs(int count, int start) {
		if(count == cnt) {
			String snum = new String(num);
			int result = Integer.parseInt(snum);
			max = Math.max(max, result);
			return;
		}
		int size = num.length;
		for(int i = start; i < size; i++) {
			for(int j = i+1; j < size; j++) {
				if(num[i] <= num[j]) {
					char temp = num[i]; num[i] = num[j]; num[j] = temp;
					dfs(count+1, i);
					temp = num[i]; num[i] = num[j]; num[j] = temp;
				}
			}
		}
	}
}*/

public class Solution_D3_1244_최대상금 {
	static int input[];
	static int N, max;
	static Set<Integer> used = new HashSet<Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(in.readLine().trim());
		for(int tc=1; tc<=C; tc++) {
			max = Integer.MIN_VALUE;
			used.clear();
			
			String[] line = in.readLine().split(" ");
	         
            input = new int[line[0].length()];
             
            for (int i = 0; i < input.length; i++) {
                input[i] = line[0].charAt(i) - '0';
            }
 
            N = Integer.parseInt(line[1]);			
			dfs(0);
			System.out.println("#" + tc + " " + max);
		}
	}
	
	public static void dfs(int cnt) {
		if(cnt == N) {
			int num = calc();
			max = Math.max(num, max);
			return;
		}
		for(int i = 0; i < input.length; i++) {
			for(int j = i+1; j < input.length; j++) {
				if(input[i] <= input[j]) {
					swap(input, i, j);
					
					int num = calc() * (-1) * (cnt+1);
					if(!used.contains(num)) {
						dfs(cnt+1);
						used.add(num);
					}
					swap(input, i, j);
				}
			}
		}
	}
	
	static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
        array[b] = temp;
	}
	
	static int calc() {
		int n=0;
		for(int i=0; i<input.length; i++)
			n = n*10 + input[i];
		return n;
	}
	
}