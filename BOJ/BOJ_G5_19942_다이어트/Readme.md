# 문제정의

1. 식재료 N개 중 몇 개를 선택해서 영양분(단백질, 탄수화물, 지방, 비타민)이 일정 이상이 되게 해야 한다.
2. 조건을 만족하면서 가격이 최소가 되는 선택을 하려고 하는데, 같은 비용 집합이 하나 이상이면 식재료 번호를 사전순으로 출력해라
3. 만약 조건을 만족하는 답이 없다면 -1 출력.
4. 3 ≤ N ≤ 15

# 문제풀이

1. 식재료의 영양분과 비용을 arr[][] 2차원 배열에 저장한다.
2. 부분집합으로 각 식재료를 선택하거나, 선택해서 N개까지 재귀호출한다. 선택하면 식재료 번호를 string에 저장한다.
3. N개가 됐을 때 조건을 만족하고 비용이 최소면 최소값 갱신. 
4. 비용이 같으면 선택한 식재료의 번호를 string compare해서 사전순으로 더 빠를 때 갱신

# 정리

문제를 또 제대로 안보고 사전순으로 출력하는걸 빼먹어서 시간이 오래 걸렸다. 조합인줄 알고 부분집합을 분기로 풀었는데 사전순으로 비교하는 로직 때문에 한참 고민했다. 조합으로 풀면 애초에 사전순으로 재귀를 타기 때문에 기저조건으로 영양분이 조건을 넘는것만 확인하면 되는데, 부분집합은 N까지 돌아야지만 영양분 조건을 확인하기 때문에 생긴 문제였다. 알고리즘 매일 풀자..꼭!