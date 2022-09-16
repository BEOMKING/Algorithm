package 완전탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Pro_메뉴리뉴얼 {
    char[] available = new char[10];
    HashMap<String, Integer> candidates;

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            candidates = new HashMap<>();

            for (int j = 0; j < orders.length; j++) {
                char[] order = orders[j].toCharArray();
                Arrays.sort(order);
                combination(order, 0, 0, course[i]);
            }

            int max = 0;
            for (String key : candidates.keySet()) {
                max = Math.max(candidates.get(key), max);
            }
            for (String key : candidates.keySet()) {
                if(candidates.get(key) == max && candidates.get(key) > 1) answer.add(key);
            }
        }

        Collections.sort(answer);
        return answer.stream().toArray(String[]::new);
    }

    public void combination(char[] order, int count, int index, int find) {
        if (count == find) {
            String temp = "";
            for (int i = 0; i < find; i++) {
                temp += available[i];
            }
            int value = candidates.getOrDefault(temp, 0);
            candidates.put(temp, value + 1);
            return;
        }

        for (int i = index; i < order.length; i++) {
            available[count] = order[i];
            combination(order, count + 1,  i + 1, find);
        }
    }

}
