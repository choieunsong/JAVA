# 문제 정의

1. W x H 칸에 벽돌들이 1~9로 표시되어 있다.
2. 구슬은 좌우만 움직이며 항상 맨 위에 있는 벽돌만 깨뜨릴 수 있다. 구슬이 명중한 벽돌은 벽돌에 적힌 숫자 - 1 칸만큼 상하좌우로 같이 제거되며 터진 벽돌들은 동시에 연쇄적으로 제거된다.
3. 벽돌이 깨지고 빈 공간 있으면 벽돌이 밑으로 떨어진다.
4. N, W, H가 주어지고 맵 정보가 주어질때 최대한 많은 벽돌을 제거했을 때 남은 벽돌 수를 출력하라

# 문제 풀이

1. 입력받을 때 전체 벽돌 수를 cnt에 저장한다.
2. 구슬이 쏘아지는 칸은 중복될 수 있으므로 c: 0 ~ W까지 중 N개를 중복순열로 구한다.
3. 뽑은 열의 수만큼 반복해서 벽돌 깨고, 벽돌을 밑으로 내리는 작업을 반복
    1. 현재 열의 w, h와 값을 구해서 큐에 저장. 만약 선택한 열에 벽돌이 없으면 다음 순서로 continue해야 한다.
    2. bfs로 깨질 벽돌 탐색. 현재 칸에서 사방탐색을 (벽돌의 수 - 1)만큼 반복하며 아직 깨지지 않은 벽돌을 찾아 큐에 넣어준다. 그 때 방문처리와 벽돌 수 cnt -= 1 해준다.
    3. bfs로 깨질 벽돌 탐색을 마치면 벽돌을 밑으로 떨어뜨린다. 한열씩 밑으로 떨어뜨리는데  0 ~ H까지 탐색하며 방문처리 된 벽돌을 만났을 때 윗칸을 아래 칸으로 하나씩 떨어뜨려 준다.
4. N번 벽돌깨기가 끝났을 때 남은 벽돌의 수를 min과 비교하여 최소값을 갱신한다.

# 정리

시뮬이라서 설계를 아이패드에 쭉 하고 풀었는데 역시나 문제를 꼼꼼히 안봐서 놓친 부분이 있었다. 중복순열을 놓쳐서 잘못된 부분을 찾는데 힘들었다ㅠㅠㅠ먼저 리드미를 작성하면서 입력, 문제 조건을 꼼꼼히 봐야겠다.