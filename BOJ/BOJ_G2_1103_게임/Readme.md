# 문제 정의

1. 구멍이 있는 직사각형 보드에서 게임을 한다. 보드의 가장 왼쪽 위에 동전을 하나 올리고 시작
2. 동전이 있는 곳에 쓰인 숫자 X를 본다
3. 위,아래,왼,오 방향 중 하나를 골라 X만큼 움직인다. 중간에 있는 구멍은 무시한다
4. 동전이 구멍에 빠지거나 보드 밖으로 나간다면 게임은 종료된다.
5. 동전을 움직일 수 있는 최댓값을 구하시오. 만약 무한히 움직일 수 있으면 -1 출력

# 문제 풀이

## 아이디어1

1. 무한히 움직이는 조건: X칸 이동했는데 그 칸의 수가 X라면 왔다갔다하며 무한반복 가능
2. bfs문제
3. 큐에 (r, c, time)를 넣는다. max값에 최대 이동개수를 기록한다.
4. 만약 r, c가 범위 밖이거나 H면 max에 t와 비교갱신
5. 4방탐색으로 현재 (r,c)에서 방향별로 X칸만큼 이동한 nr, nc, t+1을 큐에 넣어준다.
6. nr, nc가 X칸과 같다면 무한 이동이니 바로 return -1

```java
static int bfs(){
        int max = 0;

        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{0,0,0});

        int r, c, t, nr, nc;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            r = cur[0];
            c = cur[1];
            t = cur[2];

            if(r < 0 || r >= N || c < 0 || c >= M || map[r][c] == 'H'){
                max = Math.max(max, t);
                continue;
            }
            int move = map[r][c] - '0';
            for(int d=0; d<4; d++){
                nr = r + dr[d] * move;
                nc = c + dc[d] * move;
                if(0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] - '0' == move){
                    return -1;
                }
                q.offer(new int[]{nr, nc, t+1});
            }
        }
        return max;
    }
```

## 아이디어2

1. dfs + dp
2. 만약 r,c가 범위 밖이거나 구멍이면 그자리에서 끝이므로 0을 return한다
3. boolean[][] visited로 방문체크. 만약 visited[][]가 true이면 사이클이 발생된 것이므로 -1 출력 exit
4. 백트래킹: dp[r][c]가 0이 아니면 이미 그 부분은 전부 탐색한 것이니 값을 return
5. 현재 (r,c)를 방문체크해주고 4방탐색 해준다.
6. dp[r][c] = Math.max(dp[r][c], dfs(nr,nc) + 1) 
7. 방문체크 해제해주고 return해준다. 

```java
static int dfs(int r, int c){
        if(r < 0 || r >= N || c < 0 || c >= M || map[r][c] == 'H')  return 0;
        if(visited[r][c]){
            System.out.println("-1");
            exit(0);
        }
        if(dp[r][c] != 0)   return dp[r][c];
        visited[r][c] = true;
        for(int d=0; d<4; d++){
            int move = map[r][c] - '0';
            int nr = r + dr[d] * move;
            int nc = c + dc[d] * move;
            dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
        }
        visited[r][c] = false;
        return dp[r][c];
    }
```

# 정리

bfs로 하니까 6퍼에서 메모리 초과 떠서 visited 체크 해주니까 7퍼에서 틀렸습니다가 뜬다. 

dfs, dp는 정말정말정말 간단한데 너무너무너무 생각이 안나ㅠㅠ