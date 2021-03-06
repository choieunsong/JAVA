# 문제 정의

1. 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성하려 한다.
2. 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함하기로 함
3. 각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열 orders, 스카피가 추가하고 싶은 코스요리 개수가 담긴 배열 course가 주어진다.
4. orders배열 크기는 2 이상 20 이하, orders 배열의 각 원소 크기는 2 이상 10 이하 문자열(각 문자열을 알파벳 대문자, 알파벳이 중복되지 않음)
5. course 배열 크기는 1 이상 10 이하

# 문제 풀이

1. orders 배열 크기와, 문자열 길이가 작기 때문에 브루트포스로 모든 조합을 구한다.
2. course 수(조합 수)별로 모든 orders 문자열에 대해 조합을 구한다.
3. hashMap<String, Integer>에 각 조합이 나온 수를 카운팅, 저장한다. 그 때 최대개수를 갱신
4. hashMap에 저장된 key의 value가 최대값일 때 answer에 추가한다.

# 정리

처음에 문제를 잘못 이해해서 ACD, ABCDE면 ACD만 가능한 줄 알았다. 알고보니 단품 메뉴의 모든 조합으로 갯수를 세는 문제라 완전 멘붕했다. 처음에 orders 문자열에서 조합을 구해서 다른 문자열에 출현한 횟수를 구하는 방식으로 접근하니 도무지 답이 안나왔다. 블로그를 찾아보니 course에서 조합 개수만큼 각 문자열의 조합 수를 구하니까 훨씬 간단했다. 문제에 제시된 순서대로 구현하려는 경향이 있는데 문제의 핵심을 파악해서 푸는 게 정말 필요할 것 같다.