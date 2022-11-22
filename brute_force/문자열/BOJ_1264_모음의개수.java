package brute_force.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BOJ_1264_모음의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        Pattern pattern = Pattern.compile("[aeiou]");

        while(!(str = br.readLine()).equals("#")) {
            int count = 0;
            Matcher matcher = pattern.matcher(str.toLowerCase(Locale.ROOT));
            while (matcher.find()) {
                count++;
            }
            System.out.println(count);
        }
    }
}
