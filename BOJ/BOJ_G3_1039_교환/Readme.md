# ���� ����

1. 0���� �������� �ʴ� ���� N�� �ְ� M�� N�� �ڸ�����.
2. 1 �� i < j < M�� i�� j�� ��� i�� ��ġ ���� j ��ġ ���� �ٲ۴�. �� �� �ٲ� ���� 0���� �����ϸ� �ȵȴ�
3. ���� ���������� K�� ������ �� �ִ��� ���Ͻÿ�.  K�� ������ �Ұ����ϸ� -1 ���
4. N �� 1000000, K �� 10 �ڿ���

# ���� Ǯ��

1. �ð� ������ `2��`�̰� �޸� ������ `128MB` �̱⶧���� dfs�� �ƴ� bfs ������� Ǯ��� �Ѵ�. �� ���� ����ó�� �������� �޸� �ʰ��� ���. for������ Ǯ��� �ϴ� ����
2. Queue�� �Է¹��� ���� �����Ѵ�
3. K�� ������ �ϹǷ� K����ŭ �ݺ��Ѵ�. 
4. ��ġ�� �ٲ� �� �ִ� ���� �ٲ� ���ڿ��� Queue�� �־��ش�. �� �� ���� K�� ������ �� �� ���� ���� �����ؼ� �ߺ��� ���ؾ� �ð��ʰ��� �ȶ��
5. �׷��Ƿ� boolean visited �迭�� ���� �ߺ��� �����ش�.

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

1. �߿��� ���� Queue���� ���� poll�� �� while(!q.isEmpth())�� �ϸ� ���� �ȳ��´�. �ؿ��� ��� ť�� �ڸ��� �ٲ� ���� �־��ְ� �ֱ� �����̴�. ó���� �̸� ť�� ����� �� k��° ���������� ���� poll�ؼ� ��������� �Ѵ�.

# ����

�ð��� �޸𸮸� ���� ���� ���Ʈ������ �����ؾ� �ϴ��� dfs, bfs�� �����ؾ� �ϴ��� ���� ������ �ϴµ� ���� ��������. �˰��� ��ü�� �����µ� �������� ��û Ʋ���Ծ���. ó���� �ߺ�üũ�� 2���� �迭�� ���� k��°�϶� �ߺ��� üũ������� �ð��ʰ��� ����. ������ �ñ��ϴ�...