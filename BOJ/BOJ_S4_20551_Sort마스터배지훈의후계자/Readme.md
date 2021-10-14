# 문제 정의

1. 배열 A를 정렬했을 때 주어지는 원소 D가 제일 처음 등장한 위치를 출력하시오
2. 배열 A의 길이는 200000개 이하, 원소의 크기는 -100억 ~ 100억 이다

# 문제 풀이

1. 배열 A를 정렬하고 이분탐색으로 원소가 존재하는지 아닌지를 찾아야 한다
2. 그러나 원소가 중복될 수 있으므로 일반 이분탐색으로 풀면 fail 뜬다
3. 이럴때 lower bound로 풀어야 한다. lower bound는 값이 나올 때 return 하는 것이 아니라 값을 찾기 위해 범위를 좁혀가면서 찾는 것이다. 값이 나오는 처음 index를 찾기 위해 사용한다.
4. 마지막 나온 low가 `arr[low] = 찾는 값` 이 아닐 경우 값이 없는 것이기 때문에 -1, 있으면 low를 return해준다.

```java
public static int lowerBound(int arr[], int value){
	int low = 0;
	int high = arr.lenght - 1;
	int mid = 0;
	while(low < high){
		mid = (low + high) / 2;
		if(value <= arr[mid]){
			high = mid;
		}else{
			low = mid + 1;
		}
	}
}
```

# 정리

가장 처음 나온 인덱스를 어떻게 구하지? 이분탐색은 알겠는데.....