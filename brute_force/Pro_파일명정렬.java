package brute_force;

import java.util.Arrays;

public class Pro_파일명정렬 {
    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            int start = findNumberStart(o1);
            int number = findNumber(start, o1);
            int oStart = findNumberStart(o2);
            int oNumber = findNumber(oStart, o2);

            int compareString = o1.substring(0, start).toLowerCase().compareTo(o2.substring(0, oStart).toLowerCase());
            if (compareString == 0) return number - oNumber;
            return compareString;
        });

        return files;
    }

    public int findNumberStart(String input) {
        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);
            if (now >= '0' && now <= '9') return i;
        }

        return -1;
    }

    public int findNumber(int start, String input) {
        StringBuilder end = new StringBuilder();

        for (int i = start; i < input.length(); i++) {
            char now = input.charAt(i);

            if (now >= '0' && now <= '9' && end.length() < 5) {
                end.append(now);
                continue;
            }

            break;
        }

        return Integer.parseInt(end.toString());
    }
}
