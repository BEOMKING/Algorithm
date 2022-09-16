package 완전탐색.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BOJ_10491_Quiteaproblem {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        Pattern pattern = Pattern.compile("problem");

        while((str = br.readLine()) != null){
            Matcher matcher = pattern.matcher(str.toLowerCase(Locale.ROOT));
            if (matcher.find())
                System.out.println("yes");
            else {
                System.out.println("no");
            }
        }

    }

}
