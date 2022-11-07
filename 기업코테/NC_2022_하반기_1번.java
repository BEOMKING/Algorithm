package 기업코테;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class NC_2022_하반기_1번 {
    public String solution(String source) {
        boolean[] isDeleted = new boolean['z' - 'a' + 1];

        if (source.length() == 0) {
            return "";
        }

        StringBuilder nextSource = new StringBuilder();
        List<Character> deleted = new ArrayList<>();

        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            if (isDeleted[c - 'a']) {
                nextSource.append(c);
            } else {
                isDeleted[c - 'a'] = true;
                deleted.add(c);
            }
        }

        Collections.sort(deleted);
        StringBuilder dest = new StringBuilder();
        for (Character c : deleted) {
            dest.append(c);
        }

        return dest + solution(nextSource.toString());
    }

    public static void main(String[] args) {
        NC_2022_하반기_1번 nc_2022_하반기_1번 = new NC_2022_하반기_1번();
        System.out.println(nc_2022_하반기_1번.solution("execute"));
    }
}
