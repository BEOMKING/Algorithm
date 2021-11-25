package 구현;

import java.util.ArrayList;
import java.util.List;

public class Pro_뉴스클러스터링 {
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> one = clus(str1);
        List<String> two = clus(str2);

        int cross = 0, sum = 0;
        for (int i = 0; i < one.size(); i++) {
            for (int j = 0; j < two.size(); j++) {
                if(one.get(i).equals(two.get(j))) {
                    one.remove(i--);
                    two.remove(j--);
                    cross++;
                    sum++;
                    break;
                }
            }
        }

        sum += (one.size() + two.size());

        if(sum == 0) {
            answer = 65536;
        } else {
            answer = 65536 * cross / sum;
        }
        return answer;
    }

    List<String> clus(String str) {
        List<String> list = new ArrayList<>();
        str = str.toUpperCase();
        for (int i = 0; i < str.length() - 1; i++) {
            char first = str.charAt(i);
            char second = str.charAt(i + 1);
            if((first >= 'A' && first <= 'Z') && (second >= 'A' && second <= 'Z')) {
                list.add("" + first + second);
            }

        }
        return list;
    }

}
