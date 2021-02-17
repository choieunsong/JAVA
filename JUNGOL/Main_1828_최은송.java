package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 냉장고 
 * greedy 
 * */

public class Main_1828_최은송 {
	
	public static class Chemical implements Comparable<Chemical>{
		int low;
		int high;
		public Chemical(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}
		@Override
		public int compareTo(Chemical o) {
			int diff = this.high - o.high;
			return diff != 0 ? diff : this.low - o.low;
		}
		@Override
		public String toString() {
			return "Chemical [low=" + low + ", high=" + high + "]";
		}
		
	}
	static List<Chemical> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		list = new ArrayList<Chemical>();
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine().trim(), " ");
			int low = Integer.parseInt(st.nextToken());
			int high = Integer.parseInt(st.nextToken());
			list.add(new Chemical(low, high));
		}
		Collections.sort(list);
		
		System.out.println(getRef());
	}
	
	public static int getRef() {
		int cnt = 1;
		int newLow = 0, newHigh = 0;
		for(int i = 0, size = list.size()-1; i < size; i++) {
			//현재물질 최고 온도 <= 다음물질 최저온도. => 다음 물질 최고온도를 현재 물질 최고 온도로 set 
			if(list.get(i).high >= list.get(i+1).low) {	
				newLow = list.get(i+1).low;
				newHigh = list.get(i).high;
				list.set(i+1, new Chemical(newLow, newHigh));
				continue;
			}	// 현재물질 최저온도 >= 다음물질 최저 온도. => 다음 물질 최저 온도, 최고 온도를 현재 물질로 set 
			else if(list.get(i).low >= list.get(i+1).low) {
				newLow = list.get(i).low;
				newHigh = list.get(i).high;
				list.set(i+1, new Chemical(newLow, newHigh));
				continue;
			}
			cnt++;
		}
		return cnt;
	}

}
