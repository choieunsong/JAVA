# 문제 정의

1. 숫자 1개를 표현하기 위해 가로 3, 세로 5가 필요하다. 
2. N이 주어질 때 일부 칸이 가려져서 보이지 않는다. 가능한 모든 숫자들의 평균을 출력하시오. 가능한 번호가 없을 경우 -1 출력
3. 1 ≤ N ≤ 9

# 문제 풀이

1. 1~9까지 수를 3차원 char 배열에 미리 저장한다.
2. 입력받은 수를 2차원 char 배열에 저장한다. 입력의 열을 0~3, 4~6씩 끊어가며 각 자리를 1~9까지 모두 비교해서 그 수가 될 수 있는지 체크한다.
3. List<Integer> nums[] 리스트 배열을 만들어서 각 자리별로 가능한 수를 저장한다.
4. 리스트별로 돌면서 각 자리수가 가능한 값을 모두 더하고, 해당 자리수(1 → 10 → 100)을 곱한 값을 리스트 배열의 개수만큼 나눠서 해당 자리의 평균을 구한다.
5. 4번 과정을 모든 자리수에서 평균을 구해주고 결과에 더해준다.

# 정리

자리수에서 가능한 수를 구하는 것까진 어렵지 않았는데 평균을 구하는게 어려웠다. 처음엔 dfs로 모든 경우의 수를 조합으로 구해서 더해줬는데 당연하지만 시간초과가 났다. 고민하다가 각 자리별로 리스트 배열에 있는 수의 평균을 자리수만큼 곱해주고 그걸 더하면 평균이 나오는 것을 깨달았다. 그리고 중간 자리가 불가능한 수가 나오면 뒤에 가능하다 해도 -1을 출력해야 하는데 이 점을 간과해서 푸는데 오래 걸렸다.