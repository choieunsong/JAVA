# 문제 정의

1. KOI 어린이집에 N명의 아이들이 있고 1~N까지 번호가 적혀있다.
2. 아이들을 순서대로 줄세우기 위해 한번에 한명씩 자리를 옮기고자 한다
3. 위치를 옮기는 아이들의 수가 최소가 되는 값을 구하시오
4. 1≤N≤200

# 문제 풀이

1. [3 7 5 2 6 1 4]가 있을 때 7, 2, 1, 4 아이들을 옮겨야 한다
2. [3 7 5 2 6 1 4 ]가 고정된 아이들
3. LIS를 구하고 LIS가 아닌 아이들의 숫자를 구하는 문제이다.
4. LIS는 Longest Increasing Subsequence로서 최장증가부분수열이다. 시간 복잡도는 O(n^2)

```java
int[] array = new int[N]; // 인덱스마다 각 입력값

int[] dp = new int[N]; // 인덱스마다 각 증가 수열의 길이

int max = 0;

dp[0] = 1;

for(int i=1;i<N;i++) {
    dp[i] = 1;
    // i 를 기준으로 인덱스 0 에서부터 i-1까지 체크한다 
    // 길이를 기준
    for(int j=0;j<i;j++) {
        if (array[i] > array[j] && dp[j] + 1 > dp[i]) {
            // 증가 수열
            dp[i] = dp[j] + 1;
        }
    }

    if (max < dp[i]) {
        max = dp[i];
    }

}

출처: https://mygumi.tistory.com/69 [마이구미의 HelloWorld]
```

# 정리

LIS 어렵군. dp라기에 왜 이게 디핀가 했는데 LIS도 dp의 일부분이라서 그런 것이었다