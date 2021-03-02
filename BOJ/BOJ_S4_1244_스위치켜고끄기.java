package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S4_1244_스위치켜고끄기 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int arr[] = new int[N+1];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for(int i=1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int T = Integer.parseInt(in.readLine());
		int sex, num;
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(in.readLine(), " ");
			sex = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			
			if(sex == 1) {
				for(int i=num; i <=N; i+=num) {
					arr[i] = arr[i] == 1 ? 0 : 1;
				}
			}else {
				arr[num] = arr[num] == 1 ? 0 : 1 ;
				int i = 1;
				while(num-i > 0 && num+i <= N) {
					if(arr[num-i] == arr[num+i]) {
						arr[num-i] = arr[num-i] == 1 ? 0 :1;
						arr[num+i] = arr[num+i] == 1 ? 0 :1;
						i++;
					}else {
						break;
					}
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			System.out.print(arr[i]+" ");
			if(i % 20 == 0)
				System.out.println();
		}
	}

}
