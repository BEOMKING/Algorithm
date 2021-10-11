package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BOJ_15881_PenPineappleApplePen {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        Pattern pattern = Pattern.compile("pPAp");
        Matcher matcher = pattern.matcher(input);

        int count = 0;
        while (matcher.find()){
            count++;
        }
        System.out.println(count);

    }

}
