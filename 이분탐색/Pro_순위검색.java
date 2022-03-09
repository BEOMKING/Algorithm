package 이분탐색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Pro_순위검색 {
    HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for (int i = 0; i < info.length; i++) {
            combination("", 0, info[i].split(" "));
        }

        for (String key : hashMap.keySet()) {
            Collections.sort(hashMap.get(key));
        }

        for (int i = 0; i < query.length; i++) {
            String[] querys = query[i].split(" ");
            String input = querys[0] + querys[2] + querys[4] + querys[6];
            if (!hashMap.containsKey(input)) continue;
            ArrayList<Integer> list = hashMap.get(input);
            int score = Integer.parseInt(querys[7]);
            int start = 0, end = list.size() - 1;

            while (start <= end) {
                int mid = (start + end) / 2;
                if (list.get(mid) >= score) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            answer[i] = list.size() - start;
        }

        return answer;
    }

    public void combination(String combi, int target, String[] info) {
        if (target == 4) {
            int score = Integer.parseInt(info[4]);
            if (hashMap.containsKey(combi)) {
                hashMap.get(combi).add(score);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(score);
                hashMap.put(combi, list);
            }
            return;
        }

        combination(combi + "-", target + 1, info);
        combination(combi + info[target], target + 1, info);

    }

}
