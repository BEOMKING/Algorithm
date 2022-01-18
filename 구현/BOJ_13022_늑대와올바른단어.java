package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13022_늑대와올바른단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        System.out.println(check(word));
    }

    private static int check(String word) {
        int fixCount = calculateChar('w', word, 0);
        int count = calculateChar('o', word, fixCount);
        if(fixCount != count) return 0;
        count = calculateChar('l', word, 2 * fixCount);
        if(fixCount != count) return 0;
        count = calculateChar('f', word, 3 * fixCount);
        if(fixCount != count) return 0;
        if(4 * count == word.length()) return 1;
        return check(word.substring(4 * count));
    }

    private static int calculateChar(char c, String word, int start) {
        int count = 0;
        for (int i = start; i < word.length(); i++) {
            if(word.charAt(i) != c) return count;
            count++;
        }
        return count;
    }

}
