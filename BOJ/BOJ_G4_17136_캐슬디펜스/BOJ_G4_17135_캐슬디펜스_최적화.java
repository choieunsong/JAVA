package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_G4_17135_캐슬디펜스_최적화 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, D, answer;
	static int[][] map;
	
	private static boolean canMove(int X, int Y) {
		if(X < 0 || Y < 0 || X >=N || Y >= M) {
			return false;
		}
		return true;
	}

	
	private static void implement(int[] arrow) {
		Set<List<Integer>> totaltarget = new HashSet<>();
		
		// 맨 아래부터 공격 시작
		for(int level = N - 1; level >= 0; level--) {
			Set<List<Integer>> nowtarget = new HashSet<>();
			
			// 모든 궁수에 대해서 공격
			nextArrow:
			for(int arr = 0; arr < 3; arr++) {
				// 가까운 거리부터 공격 시작
				for(int dist = 0; dist < D; dist++) {
					// 왼쪽 부터 시작
					for(int loc = - dist; loc <= dist; loc++) {
						int r = level - (dist - Math.abs(loc));
						int c = loc + arrow[arr];
						
						// 맵 밖 / 궁 수가 없는 경우 / 전에 이미 처리한 경우 -> 제외
						if(!canMove(r, c) || map[r][c] != 1 || totaltarget.contains(Arrays.asList(r, c))) continue;
						
						// 현재 target으로 추가
						nowtarget.add(Arrays.asList(r, c));
						continue nextArrow;
					}
				}
			}
			
			// 현재 타겟이 된 모든 적을 전체 적에 추가
			for(List<Integer> tgt : nowtarget) {
				totaltarget.add(tgt);
			}
		}
		
		// 최대값을 갱신
		answer = totaltarget.size() > answer ? totaltarget.size() : answer;
	}

	private static void makeCombination(int idx, int cnt, int[] flag) {
		if(cnt == 3) {
			implement(flag);
			return;
		}

		if(idx == M) {
			return;
		}
		

		flag[cnt] = idx;
		makeCombination(idx + 1, cnt + 1, flag);
		makeCombination(idx + 1, cnt, flag);
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 조합 생성
		makeCombination(0, 0, new int[3]);
		
		System.out.println(answer);
	}
}
