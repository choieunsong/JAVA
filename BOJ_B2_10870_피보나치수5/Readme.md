# 문제정의

1. N이 주어질 때 피보나치 수를 구하여라
2. N ≤ 20

# 문제풀이

1. memo[21]를 선언, memo[1] = 1 기저조건을 선언한다.
2. 만약 memo[n]가 0이 아니라면 return memo[n]
3. 만약 n == 0이면 return 0, n == 1이면 return 1
4. 아니면 memo[n] = fibo(n-1) + fibo(n-2)
5. 재귀탐색이 끝났으면 memo에 저장된 값을 return

# 정리

다시 푸니까 정말 dp의 top-down의 기본 골격이었다.  다시 풀길 잘한듯!