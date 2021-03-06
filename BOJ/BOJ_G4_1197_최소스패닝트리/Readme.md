# 문제 정의

1. 정점의 개수 V(1 ≤ V ≤ 10,000), 간선의 개수 E(1≤ E ≤ 100,000)과 각 간선의 시작, 도착, 가중치가 주어진다. 최소 스패닝 트리의 가중치를 출력하시오

# 문제 풀이

프림: 정점의 개수가 작을 때

일반: O(V^2logV)

pq: O((E+V)logV)

크루크칼: 간선의 개수가 작을 때

1. 이 문제는 정점의 개수가 10,000으로 간선개수보다 훨씬 작기 때문에 프림으로 푸는 게 좋다. 또한 정점이 십만개이므로 인접행렬로 절대 풀 수 없다. 메모리가 128mb제한인데 최악의 경우 4기가까지 나오기 때문에 인접 리스트를 써야 한다.
2. 정점의 차출간선의 최소 가중치를 저장할 minEdge 배열, 정점이 MST의 일부인지 체크할 visited 배열 선언.
3. 1부터 시작. minEdge[1] = 0. pq에 1을 넣어준다.
4. 반복: true
    1. pq에서 poll해주면 cost가 가장 작은 값이 나온다. 방문 안된 정점이 나올때까지 poll해주기
    2. 방문처리 해주고 result에 현재 정점의 cost를 누적
    3. 만약 ++cnt == V면 모든 정점이 MST의 일부이므로 반복 종료
    4. 현재 정점과 연결된 정점을 리스트에서 살피며, 아직 방문하지 않았고 기존에 그 정점까지 가는 거리보다 현재 정점을 거쳐서 가는게 더 빠를 경우 minEdge를 거쳐가는 값으로 갱신, pq에 넣어준다.

# 정리

무작정 정점 수가 더 작으니까 인접행렬! 하고 풀었는데 메모리 초과가 떴다. V가 십만인데 int 타입 2차원 배열을 선언하면 당연히 메모리 초과가 뜰수밖에 없지. 정점의 범위를 보고 너무 크다 싶으면 무조건 인접리스트로 구현하자.