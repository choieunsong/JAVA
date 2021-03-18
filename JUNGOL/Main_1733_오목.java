package jungol;
import java.io.*;
import java.util.*;

public class Main_1733_오목{
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(input));
		int[][] om=new int[19][19];
		//0,0 좌표를 기준으로 오목인지 검사하기 위해 4방향을 검사한다.
		//       우상,우,우하, 하
		int[] di={-1, 0, 1, 1};
		int[] dj={ 1, 1, 1, 0};
		for(int i=0; i<19; i++){
			String line = in.readLine();
			for(int j=0, k=0; j<19; j++, k+=2){
				om[i][j]=line.charAt(k)-'0';
			}
		}
		int ans=0, ani=0, anj=0;
		loop:for(int i=0; i<19; i++){
			for(int j=0; j<19; j++){
				if(om[i][j]!=0){
					for(int d=0; d<4; d++){
						int ni=i+di[d];
						int nj=j+dj[d];
						if(ni<0||19<=ni || nj<0||19<=nj || om[i][j]!=om[ni][nj]) continue;						
						
						int pi=i-di[d];
						int pj=j-dj[d];						
						if(0<=pi&&pi<19 && 0<=pj&&pj<19 && om[i][j]==om[pi][pj]) continue; //육목체크

						int len=1;
						while(0<=ni&&ni<19 && 0<=nj&&nj<19 && om[i][j]==om[ni][nj] && len<=5){
							len++;
							ni+=di[d]; 
							nj+=dj[d];
						}
						if(len==5){
							ans=om[i][j];
							ani=i+1; 
							anj=j+1;
							break loop;
						}
					}
				}
			}
		}		
		System.out.println(ans);
		if(ans!=0) System.out.println(ani+" "+anj);
	}
	static String input="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 1 2 0 0 2 2 2 1 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 1 2 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 1 2 2 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 1 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 2 1 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0";
}