# 문제 정의

1. PPAP 문자열이란 P를 PPAP로 바꾼 문자열이다.
2. 두번째 P를 바꿨을 때 PPPAPAP가 됨
3. 입력 문자열이 PPAP 문자열로만 구성되면 PPAP 출력, 아니면 NP 출력

# 문제 풀이

## 아이디어1

1. result에 문자열 추가. P를만나면 앞에 4글자 확인해서 PPAP인지 체크
2. 같으면 4글자 줄이고 P를 추가. result가 비었으면 PPAP,아니면 NP

## 아이디어2

1. PPAP 문자열인지 확인하려면 PP가 연속 2번 나오고 A 뒤에 P가 하나 나와야 함
2. P의 개수를 세어주고 A를 만났을 때 P 개수가 2 이상, 뒤에 P가 있는지만 체크

# 정리

PPAP라는 문자열 특징이 있기 때문에 P의 개수만 세면 되는 문제였다. 익숙한 방식으로 짜지 말고 새로운 아이디어를 계속 생각해야겠다 반성하게 됐다