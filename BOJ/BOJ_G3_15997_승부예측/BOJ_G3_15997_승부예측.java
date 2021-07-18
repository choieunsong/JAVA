package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_G3_15997_승부예측 {
    static HashMap<String, Integer> map = new HashMap<String, Integer>();
    static Game[] games = new Game[6];
    static int[][] score;
    static double[] probability;
    static class Game{
        public int a, b;
        public double win, draw, lose;
        public Game(){}
        public Game(int a, int b, double win, double draw, double lose) {
            this.a = a;
            this.b = b;
            this.win = win;
            this.draw = draw;
            this.lose = lose;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        score = new int[4][2];  //각 국가별 최종 점수. [][0]: idx, [][1]: 점수
        probability = new double[4];    //각 국가별 최종 확률 저장

        for(int i=0; i<4; i++) {
            map.put(st.nextToken(), i);
            score[i][0] = i;
        }
        for(int i=0; i<6; i++){
            st = new StringTokenizer(in.readLine());
            Game game = new Game(map.get(st.nextToken()), map.get(st.nextToken()),
                    Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
            games[i] = new Game();
            games[i] = game;
        }
        dfs(0, 1.0);
        for(int i=0; i<4; i++)
            System.out.println(probability[i]);
    }
    //인덱스, idx==6일때 최종진출팀이 갖는 확률
    static void dfs(int idx, double prob){
        if(idx == 6){
            if(prob == 0)   return;
            int[][] sort_score = new int[4][2];
            for(int i=0; i<4; i++){
                sort_score[i][0] = score[i][0];
                sort_score[i][1] = score[i][1];
            }

            // 점수를 가지고 내림차순 정렬
            Arrays.sort(sort_score, (o1, o2) -> {
                if(o1[1] == o2[1]){
                    return Integer.compare(o1[0], o2[0]);
                }else{
                    return Integer.compare(o2[1], o1[1]);
                }
            });
            /*
            * if.b!=c -> a,b진출
            * else if.a=b && c=d -> 4명동점 abcd 중 2을 뽑는 경우. p/2확률로 진출
            * else if.a=b -> a=b=c>d -> 3명동점 abc중 2를 뽑는 경우. p*2/3확률로 진출
            * else if.c=d -> a>b=c=d -> 3명동점 bcd중 2를 뽑는 경우. p/3확률로 진출
            * else -> b=c -> a>b=c>d -> bc중 1을 뽑는 경우. p/2확률로 진출
             */
            if(sort_score[1][1] != sort_score[2][1]){
                probability[sort_score[0][0]] += prob;
                probability[sort_score[1][0]] += prob;
            }else if(sort_score[0][1] == sort_score[1][1] && sort_score[2][1] == sort_score[3][1]){
                probability[sort_score[0][0]] += prob/2;
                probability[sort_score[1][0]] += prob/2;
                probability[sort_score[2][0]] += prob/2;
                probability[sort_score[3][0]] += prob/2;
            }else if(sort_score[0][1] == sort_score[1][1]){
                probability[sort_score[0][0]] += prob* 2/3;
                probability[sort_score[1][0]] += prob* 2/3;
                probability[sort_score[2][0]] += prob* 2/3;
            }else if(sort_score[2][1] == sort_score[3][1]){
                probability[sort_score[0][0]] += prob;
                probability[sort_score[1][0]] += prob/3;
                probability[sort_score[2][0]] += prob/3;
                probability[sort_score[3][0]] += prob/3;
            }else{
                probability[sort_score[0][0]] += prob;
                probability[sort_score[1][0]] += prob/2;
                probability[sort_score[2][0]] += prob/2;
            }
            return;
        }
        //a가 이겼을 때
        Game game = games[idx];
        score[game.a][1] += 3;
        dfs(idx+1, prob * game.win);
        score[game.a][1] -= 3;

        //a, b 무승부일 때
        score[game.a][1] += 1;
        score[game.b][1] += 1;
        dfs(idx+1, prob * game.draw);
        score[game.a][1] -= 1;
        score[game.b][1] -= 1;

        // b가 이겼을 때
        score[game.b][1] += 3;
        dfs(idx+1, prob*game.lose);
        score[game.b][1] -= 3;
    }
}
