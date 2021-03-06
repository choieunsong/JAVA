# 문제 정의

1. 벌꿀통이 N*N개 있다. 일꾼 두명은 한번에 M개의 벌통을 가로로 연속해서 채집할 수 있으며 둘이 선택한 벌통이 겹치면 안된다.
2. 두 일꾼이 한번에 채취할 수 있는 꿀의 최대 양은 C이다. 채집한 벌꿀들의 수익은 한 벌통의 제곱이다. 만약 일꾼 두명이 5,4, 6, 3의 벌통을 채집하면 수익은 25 + 16 + 36 + 9 = 86이다.
3. 최대 수익을 구하라
4. 3 ≤ N ≤ 10, 1 ≤ M ≤ 5, 10 ≤ C ≤ 30

# 문제 풀이

1. N*N의 벌통을 돌며 일꾼1이 채집할 벌통 M개를 탐색한다.
2. 벌통 M개에서 부분조합으로 C를 넘지 않으며 무게가 최대가 되는 조합을 구한다. 이 때 값이 최대보다 같거나 클때마다 벌꿀의 수익을 계산해서 비교, 갱신해야 한다. 만약 M이 10이고 일꾼이 채집한 벌통이 {7, 2, 9}일때 {7, 2}를 선택하면 수익은 49 + 4 = 53이 되지만 {9}만 선택했을 때는 81이 되므로 벌꿀의 무게는 같지만 수익은 더 커지기 때문이다.
3. 일꾼 1이 벌통을 선택하면 일꾼 2가 N*N의 맵을 탐색하며 일꾼1이 선택하지 않은 벌통을 선택한다. 
4. 일꾼 2도 일꾼 1과 동일한 방식으로 최대 수익을 계산한다.
5. 일꾼 1의 최대 수익 + 일꾼 2의 최대 수익을 max값과 비교 갱신한다.

# 정리

부분집합으로 최대 수익을 계산하는 아이디어를 떠올리기 힘든 것 같다. 특히 무게는 같지만 수익이 다를 수 있는데 처음에 고려하지 못해서 최대무게를 먼저 구한 다음에 수익을 계산하니 잘못된 답이 나왔었다. 이런 디테일들을 잘 고려해야 할 것 같다.