package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BOJ_1543_문자검색 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String doc = br.readLine();
        String find = br.readLine();

        Pattern pattern = Pattern.compile(find);
        Matcher matcher = pattern.matcher(doc);
        int result = 0;

        while (matcher.find()) {
            result++;
        }

        System.out.println(result);
    }

}
