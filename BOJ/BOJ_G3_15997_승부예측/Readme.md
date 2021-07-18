# 문제 정의

1. 4개의 팀이 모든 팀과 3번의 경기를 치러 총 6번의 경기를 치르게 된다
2. 경기의 승자는 3점을 받고, 비기면 각각 1점, 지면 0점을 받는다
3. 조별리그를 전부 치르면 승점으로 순위를 정하며 승점이 같을 시 추첨으로 진행되고 2팀이 다음 라운드에 진출한다.

# 문제 풀이

1. 3^6의 경우를 모두 구해줘야 한다. 총 경기 수가 6가지밖에 안되니 조합으로 풀어준다.
2. aaa bbb 0.428 0.144 0428 → aaa가 이긴 경우, 비긴 경우, 진 경우를 모두 탐색해야 하는 것이다.
3. 각 국가 이름과 인덱스를 연결하기 위해 (이름, 인덱스)로 HashMap으로 저장한다. 
4. idx == 6이 될때까지 a가 이겼을 때, 무승부일때, b가 이겼을 때의 경우를 score배열에 저장하고 확률을 곱해서 dfs 인자로 넘김.

```java
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
```

1. idx == 6이 되면 score에 저장된 점수를 내림차순으로 정렬한다. score 배열은 2차원인데 [][0]에는 각 국가별 인덱스가 저장되어 있고 [][1]에는 국가별 얻은 점수가 저장된다.
2. 나라별로 동점일 때 확률을 계산해서 최종 probability 배열에 저장한다.

```java
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
```

# 정리

처음에 score 배열을 바로 정렬해서 확률을 더해줬더니 정답이 안나왔다. 왜그런가 디버깅을 해보니 score에 국가 인덱스별로 점수를 더해줘야 하는데 앞에서 정렬해버려서 인덱스가 꼬여버린 것이었다. 그래서 sort_score 배열을 만들어서 score를 복사하고 정렬해서 계산해주니 정답이었다.