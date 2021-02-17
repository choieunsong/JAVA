package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 냉장고 , greedy.
// 최고온도로 정렬(같으면 최저 온도가 낮은순으로) 
public class Main_1828_남준영 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		int N=Integer.parseInt(br.readLine());
		Chemical[] c = new Chemical[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			c[i]= new Chemical(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(c);
		
		
		int cnt=1;
		int endT=c[0].h;
		for(int i=1;i<N;i++) {
			// 기존 끝 온도보다 더 높은 온도가 있다면 끝온도 update.
			if(endT < c[i].l ) {
				endT=c[i].h;
				cnt++;
			}
		}
		
		System.out.println(cnt);
		

	}

}

class Chemical implements Comparable<Chemical>{
	int l,h;

	public Chemical(int l, int h) {
		super();
		this.l = l;
		this.h = h;
	}

	@Override
	public int compareTo(Chemical o) {
		int diff = this.h-o.h;
		if(diff==0) {
			diff=this.l-o.l;
		}
		return diff;
	}
	
}