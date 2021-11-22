package 자료구조;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Pro_튜플 {
    public int[] solution(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '{') count++;
        }
        String[][] tuple = new String[count][];

        int start = 0, end;
        int count1 = 0;
        for (int i = 1; i < s.length() - 1; i++) {
            if(s.charAt(i) == '{') {
                start = i + 1;
                count1 = 0;
            } else if(s.charAt(i) == '}') {
                end = i;
                tuple[count1 + 1] = s.substring(start, end).split(",");
            } else if(s.charAt(i) == ',') {
                count1++;
            }
        }

        HashSet<Integer> hashSet = new LinkedHashSet<>();
        for (int i = 1; i < count; i++) {
            for (int j = 0; j < i; j++) {
                hashSet.add(Integer.parseInt(tuple[i][j]));
            }
        }

        int[] answer = new int[hashSet.size()];
        Iterator iter = hashSet.iterator();
        int i = 0;
        while (iter.hasNext()) {
            answer[i++] = (int) iter.next();
        }
        return answer;
    }

}
