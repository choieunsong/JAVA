# 문제 정의

1. N*M 모양의 맵에 아이템과 장애물이 있다.
2. 왼쪽 아래에서 출발해 오른쪽 위로 가려는 데 중간에 모든 아이템을 먹으려 한다.
3. 오른쪽이나 위쪽으로만 이동할 수 있으며 장애물은 못지나간다. 
4. 이동하는 경로의 개수를 구하여라
5. 1 ≤ N, M ≤ 100

# 문제 풀이

1. N,M의 수가 100까지 되기 때문에 일반 bfs, dfs로는 못푼다. dp로 풀어야 한다
2. Arraylist에 (0,0), 아이템 좌표, (N-1,M-1)을 넣고 정렬한다
3. 아이템1 → 다음 아이템까지 경로 수를 dp에 저장한다.
4.  r1 → r2까지 장애물이 없으면 dp에 1 저장, c1 → c2까지 장애물이 없으면 dp에 1 저장, (r1+1,c1+1) → (r2,c2)까지 장애물이 없으면 오른쪽의 경로 수 + 왼쪽의 경로 수 더해준다.
5. dp[r2][c2]에는 아이템 사이의 경로의 수가 저장된다.
6. 이렇게 모든 아이템 사이의 경로를 곱해주면 된다

# 정리

어렵다...처음에 되도 않는 dfs를 쓰려고 했다가 10%에서 에러. 결국 블로그 보고 베꼈다. dp 생각을 하나도 못했는데 뜯어보니까 단순하다.