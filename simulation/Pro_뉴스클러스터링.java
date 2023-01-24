package simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @solved 2022.12.01
 */
class Pro_뉴스클러스터링 {
    public int solution(String str1, String str2) {
        int answer = 0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();

        split(str1, str1List);
        split(str2, str2List);

        if (str1List.isEmpty() && str2List.isEmpty()) return 65536;

        int intersection = 0;
        boolean[] isChecked = new boolean[str2List.size()];

        for (int i = 0; i < str1List.size(); i++) {
            String s1 = str1List.get(i);
            for (int j = 0; j < str2List.size(); j++) {
                if (isChecked[j]) continue;
                if (s1.equals(str2List.get(j))) {
                    intersection++;
                    isChecked[j] = true;
                    break;
                }
            }
        }

        return intersection * 65536 / (str1List.size() + str2List.size() - intersection);
    }

    private void split(String str, List<String> strList) {
        for (int i = 0; i < str.length() - 1; i++) {
            char prev = str.charAt(i);
            char next = str.charAt(i + 1);

            if (prev >= 'a' && prev <= 'z' && next >= 'a' && next <= 'z') {
                strList.add("" + prev + next);
            }
        }
    }
}
