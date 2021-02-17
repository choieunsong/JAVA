package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준 Main_등급_문제번호_이름 
 * 요세푸스 문제 
 * */

public class Main_S5_1158_최은송 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int data=0;
		while(!q.isEmpty()) {
			for(int k=0; k < K-1; k++) {
				data = q.poll();
				q.offer(data);
			}
			data = q.poll();
			sb.append(data + ", ");
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb.toString());
	}	

}
