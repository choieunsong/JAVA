# 문제 정의

1. 1개의 회의실을 쓰려고 하고, N개의 회의에 대해 회의실 사용표를 만들려고 한다.
2. 회의 시작, 끝시간이 주어질 때 사용할 수 있는 회의의 최대 개수를 출력하시오

# 문제 풀이

1. 전형적인 그리디 회의실 배정 문제였다.
2. 끝시간이 작은 순서대로 정렬해서 PriorityQueue에 회의실 (시작, 끝)시간을 저장한다.
3. pq에서 하나씩 빼면서 이전 회의 끝시간보다 현재 회의 시작시간이 크거나 같으면 cnt를 1 올려준다

# 정리

전형적인 그리디 문제였다. pq에서 compareTo를 작성하는데 끝시간이 같을 때는 시작시간이 작은 순서대로 정렬해야하는데 고려하지 못해서 처음에 fail됐다.