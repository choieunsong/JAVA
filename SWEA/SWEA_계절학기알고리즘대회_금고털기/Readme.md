# 문제 정의

1. 금고를 열기위해 4개의 비밀번호를 풀어야 한다. 각 비밀번호는 알파벳 대문자다
2. 각 자물쇠를 시계방향, 반시계방향으로 1눈금 이동하는데 (1,1),(3,2),(5,4),(7,6)초가 소요된다
3. 초기비밀번호와 정답비밀번호가 주어질 때 금고를 여는 최소 소요 시간을 구하시오

# 문제 풀이

1. 시계방향으로 돌리면 A방향으로 이동하고 반시계방향으로 돌리면 Z방향으로 이동한다
2. 시계방향일 때는 `end ≤ start ? start - end : start + (26 - end)` 로 최소값을 구할 수 있다.
3. 반시계방향일때는 `start <= end ? end - start : 26 - start + end` `로 최소값을 구할 수 있다.`
4. 각 방향별로 구한 눈금수 * 소요시간을 구하고 최소값을 누적해서 더한다

# 정리

간단한 문제였다