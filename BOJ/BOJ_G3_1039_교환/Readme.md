# 문제 정의

1. 0으로 시작하지 않는 정수 N이 있고 M은 N의 자릿수다.
2. 1 ≤ i < j < M인 i와 j를 골라서 i번 위치 수와 j 위치 수를 바꾼다. 이 때 바꾼 수는 0으로 시작하면 안된다
3. 위와 같은연산을 K번 수행할 때 최댓값을 구하시오.  K번 연산이 불가능하면 -1 출력
4. N ≤ 1000000, K ≤ 10 자연수

# 문제 풀이

1. 시간 제한이 `2초`이고 메모리 제한이 `128MB` 이기때문에 dfs가 아닌 bfs 방식으로 풀어야 한다. 딱 보면 순열처럼 보이지만 메모리 초과가 뜬다. for문으로 풀어야 하는 문제
2. Queue에 입력받은 수를 저장한다
3. K번 연산을 하므로 K번만큼 반복한다. 
4. 위치를 바꿀 수 있는 경우면 바꾼 문자열을 Queue에 넣어준다. 이 때 같은 K번 연산일 때 때 같은 수는 제외해서 중복을 피해야 시간초과가 안뜬다
5. 그러므로 boolean visited 배열을 만들어서 중복을 없애준다.

```java
public static int bfs(String num){
    q.offer(num);

    for(int k=1; k<=K; k++){
        int size = q.size();
        boolean[] visited = new boolean[1000001];

        for(int s=0; s < size; s++){
            String str = q.poll();
            if(visited[Integer.parseInt(str)]){
                continue;
            }
            visited[Integer.parseInt(str)] = true;
            char[] cstr = str.toCharArray();
            for(int i=0; i<cstr.length-1; i++){
                for(int j=i+1; j<cstr.length; j++){
                    if(i == 0 && cstr[j] == '0') continue;
                    char temp = cstr[i];
                    cstr[i] = cstr[j];
                    cstr[j] = temp;
                    str = new String(cstr);
                    q.offer(str);
                    temp = cstr[i];
                    cstr[i] = cstr[j];
                    cstr[j] = temp;
                }
            }
        }
    }
    int max = -1;
    while(!q.isEmpty()){
        String str = q.poll();
        max = Math.max(max, Integer.parseInt(str));
    }
    return max;
}
```

1. 중요한 점은 Queue에서 수를 poll할 때 while(!q.isEmpth())를 하면 답이 안나온다. 밑에선 계속 큐에 자리를 바꾼 수를 넣어주고 있기 때문이다. 처음에 미리 큐의 사이즈를 얻어서 k번째 레벨에서의 수만 poll해서 연산해줘야 한다.

# 정리

시간과 메모리만 딱딱 보고 브루트포스로 접근해야 하는지 dfs, bfs로 접근해야 하는지 각을 세워야 하는데 감이 떨어졌다. 알고리즘 자체는 쉬웠는데 구현에서 엄청 틀려먹었다. 처음엔 중복체크를 2차원 배열로 만들어서 k번째일때 중복을 체크해줬더니 시간초과가 떴다. 왜인지 궁금하다...