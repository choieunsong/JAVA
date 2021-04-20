package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G2_1202_보석도둑 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int jewels[][] = new int[N][2];	// 0: 무게, 1: 가격 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			jewels[i][0] = Integer.parseInt(st.nextToken());
			jewels[i][1] = Integer.parseInt(st.nextToken());
		}
		int weight[] = new int[K];
		for(int i=0; i<K; i++)
			weight[i] = Integer.parseInt(in.readLine());
		
		Arrays.sort(weight);
		Arrays.sort(jewels, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		int idx = 0;
		long sum = 0;
		for(int i = 0; i <K; i++) {
			while(idx < N && jewels[idx][0] <= weight[i]) {
				pq.offer(jewels[idx++][1]);
			}
			if(!pq.isEmpty())
				sum += pq.poll();
		}
		System.out.println(sum);
	}
}
