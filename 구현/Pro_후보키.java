package 구현;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Pro_후보키 {
    List<Integer[]> answer = new ArrayList<>();
    int y, x;
    Integer[] available;

    public int solution(String[][] relation) {
        y = relation.length;
        x = relation[0].length;
        for (int i = 1; i <= x; i++) {
            available = new Integer[i];
            combination(i, 0, 0, relation);
        }
        return answer.size();
    }

    public void combination(int destination, int count, int start, String[][] relation) {
        if (count == destination) {
            if (!minimality()) return;
            uniqueness(relation);
            return;
        }

        for (int i = start; i < x; i++) {
            available[count] = i;
            combination(destination, count + 1, i + 1, relation);
        }
    }

    private boolean minimality() {
        for (Integer[] a : answer) {
            boolean f = true;
            for (int i = 0; i < a.length; i++) {
                boolean flag = false;
                for (int j = 0; j < available.length; j++) {
                    if (a[i] == available[j]) flag = true;
                }
                if (!flag) f = false;
            }
            if (f) return false;
        }
        return true;
    }

    private void uniqueness(String[][] relation) {
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < y; i++) {
            String str = "";
            for (int j = 0; j < available.length; j++) {
                str += relation[i][available[j]];
            }
            hashSet.add(str);
        }
        Integer[] temp = new Integer[available.length];
        for (int i = 0; i < available.length; i++) {
            temp[i] = available[i];
        }
        if (hashSet.size() == y) answer.add(temp);
    }

}
