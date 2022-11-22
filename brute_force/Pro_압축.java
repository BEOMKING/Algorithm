package brute_force;

import java.util.ArrayList;
import java.util.List;

public class Pro_압축 {
    List<Integer> answer = new ArrayList<>();
    List<String> zip = new ArrayList<>();

    public int[] solution(String msg) {
        zip.add("-1");
        for (char i = 'A'; i <= 'Z'; i++) {
            zip.add(i + "");
        }
        LZW(msg);
        int[] result = new int[answer.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }
        return result;
    }

    public void LZW(String msg) {
        for (int i = 0; i < msg.length(); i++) {
            int index = findIndex(i, msg);
            if (index == -1) return;
            zip.add(msg.substring(i, i + index));
            answer.add(zip.indexOf(msg.substring(i, i + --index)));
            i += --index;
        }

    }

    public int findIndex(int start, String msg) {
        int index = 1;

        while (zip.contains(msg.substring(start, start + index))) {
            if (start + index + 1 > msg.length()) {
                answer.add(zip.indexOf(msg.substring(start, start + index)));
                return -1;
            }
            index++;
        }

        return index;
    }

}
