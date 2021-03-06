# 문제 정의

1. 낚시왕이 잡은 상어 크기의 합을 구하라
2. 낚시왕이 (1,0)에서 출발해 오른쪽으로 한 칸 움직인다
3. 낚시왕이 있는 열의 땅과 가장 가까운 상어를 잡는다.
4. 상어는 d 방향대로 s 속도만큼 칸을 이동한다. 만약 같은 칸에 두마리 이상 상어가 있으면 작은 상어가 큰 놈한테 잡아먹힌다.
5. 낚시왕이 (1, C)에 도착했을 때 종료된다.

# 문제 풀이

1. Shark 클래스에 r, c, z, d, s, 그리고 Shark 배열의 인덱스를 저장할 idx를 선언해준다.
2. 상어 정보를 입력받아 Shark 배열에 저장한다. 3차원 map을 만들어 map[r][c][0] : 상어 인덱스, map[r][c][1]: 상어 사이즈를 저장한다.
3. 낚시왕이 오른쪽으로 한칸 움직이고 상어 배열을 탐색해서 열이 일치하고 그 중 땅에 가장 가까운 상어의 사이즈를 result에 더해주고 map에서 제거, shark 배열에서 제거하기 위해 idx를 -1로 표시해준다.
4. 상어 배열을 탐색하며 방향별로 속도만큼 상어를 움직여준다.  이 때 속도가 1000일수 있어서 전부 이동하면 성능이 떨어진다. 만약 상하로 움직이면 `speed %= (R*2 - 2)`,  좌우면 `speed %= (C*2-2)` 하면 훨씬 빨라진다. 맨 마지막 칸을 한번밖에 방문안하기 때문에 R*2 - 2하면 제자리로 돌아오기 때문이다. 그 후 반복문으로 speed만큼 상어를 이동하고 shark 배열에 상어 정보를 업데이트해준다.
5. map에 업데이트된 상어 정보를 저장한다. 만약 같은 칸에 상어가 여러 마리면 가장 큰 상어만 남아야 하고 나머지 상어는 배열에서 제거해줘야 한다. 상어의 사이즈가 map[r][c][0]보다 크면 map[r][c][1]에 저장되어 있던 이전 상어의 인덱스를 가져와 shark배열의 해당 인덱스에 있는 상어의 idx를 -1로 바꿔준다. 

# 정리

5번에서 사이즈가 작은 상어를 배열에서 없애주는 걸 안해서 계속 에러가 떴다. 이동 칸을 줄여주는 아이디어를 교수님이 말씀해주셨는데 백준의 개미와 비슷한 느낌이었다. 잘 외워두자!