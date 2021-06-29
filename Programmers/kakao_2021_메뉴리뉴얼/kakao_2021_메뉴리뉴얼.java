package programmers;

import java.util.*;

public class kakao_2021_메뉴리뉴얼 {
    static HashMap<String, Integer> map;
    static int max;
    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};

        String[] answer = solution(orders, course);
        System.out.println(Arrays.toString(answer));
    }
    static String[] solution(String[] orders, int[] course){
        String[] answer = {};
        List<String> ans = new ArrayList<String>();
        for(int i=0; i<course.length; i++){
            map = new HashMap<String, Integer>();
            max = 0;
            for(int j=0; j< orders.length; j++){
                combi(0, 0, course[i], "", orders[j]);
            }
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                if(entry.getValue() == max && max > 1){
                    ans.add(entry.getKey());
                }
            }
        }
        int size = ans.size(), i = 0;
        answer = new String[size];
        for(String str : ans)
            answer[i++] = str;
        Arrays.sort(answer);
        return answer;
    }

    static void combi(int idx, int cnt, int targetCnt, String str, String order){
        if(cnt == targetCnt){
            // str 정렬하기
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            str = String.valueOf(temp);
            // map에 값 넣기
            if(map.containsKey(str))   map.put(str, map.get(str) + 1);
            else    map.put(str, 1);
            // 각 course 별 최대 조합 횟구 구하기
            max = Math.max(max, map.get(str));
            return;
        }
        // 각 문자열에서 모든 알파벳 조합 구하기
        for(int i=idx; i<order.length(); i++){
            String temp = str + order.charAt(i);
            combi(i+1, cnt+1, targetCnt, temp, order);
        }
    }
}
