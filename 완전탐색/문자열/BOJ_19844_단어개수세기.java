package 완전탐색.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class BOJ_19844_단어개수세기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] word = br.readLine().split("[- ]");
        Pattern pattern = Pattern.compile("^(c|j|n|m|t|s|l|d|qu)'[aeiouh]");
        int count = word.length;

        for (String str: word) {
            if(pattern.matcher(str).find()) count++;
        }

        System.out.println(count);
    }
}
