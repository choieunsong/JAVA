package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_S5_1755_숫자놀이 {
	static int N, M;
	// 각 수에 해당하는 String 배열 선언 
	static String[] dict = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	// 숫자와 해당 String을 저장하는 Node 배열 선언  
	static Node[] nodes;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// M, N 입력받는다. 
		M = sc.nextInt();
		N = sc.nextInt();
		// M 이상 N 이하의 정수 배열을 만들어 준다. 
		nodes = new Node[N-M+1];
		
		// M 이상, N 이하 수와 해당 문자열을 Node 배열에 저장한다.
		for(int i=0; i<N-M+1; i++) {
			nodes[i] = new Node(M+i);
		}
		// 문자열을 기준으로 사전순으로 정렬한다. 
		Arrays.sort(nodes);
		
		for(int i=0; i<N-M+1; i++) {
			// i가 0이 아니고 10번째면 줄을 바꿔라 
			if(i != 0 && i % 10 == 0)
				System.out.println();
			// 문자열로 정렬된 node 배열의 숫자를 출력 
			System.out.printf("%d ",nodes[i].num);
		}
	}
	
	static class Node implements Comparable<Node>{
		public int num;			// 숫자 
		public String str;		// 숫자에 해당하는 영어 문자열 
		
		public Node(int num) {
			this.num = num;
			// num가 한 자리수면 바로 dict에서 문자열 가져옴 
			if(1 <= num && num < 10) {
				this.str = dict[num];
			}
			// num가 두 자리수면 십의 자리 수에 해당하는 문자열, 일의 자리 수에 해당하는 문자열을 concat 
			else {
				this.str = dict[num / 10] + " " + dict[num % 10];
			}
		}
		// str을 기준으로 정렬하기 위해 compareTo 메서드 overriding 
		@Override
		public int compareTo(Node o) {
			// 자기 자신의 str
			String str1 = this.str;
			// 비교할 객체의 str 
			String str2 = o.str;
			// 두 str 중 길이가 작은 문자열의 길이만큼 반복하면 char를 비교 
			int len = str1.length() <= str2.length() ? str1.length() : str2.length();
			for(int i = 0; i < len; i++) {
				// 자기 자신 str이 비교 객체 str보다 작으면 return -1 (정렬할 때 앞으로 가라) 
				if(str1.charAt(i) < str2.charAt(i)) {
					return -1;
				}
				// 자기 자신 str이 비교 객체 str보다 크면 return 1 (정렬할 때 뒤로 가라)
				else if(str1.charAt(i) > str2.charAt(i)){
					return 1;
				}
			}
			// 모든 char를 비교했는데 같다면 return 0
			return 0;
		}
		@Override
		public String toString() {
			return "Node [num=" + num + ", str=" + str + "]";
		}
	}

}
