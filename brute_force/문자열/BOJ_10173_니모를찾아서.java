package brute_force.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BOJ_10173_니모를찾아서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("nemo");
        String input;

        while (!(input = br.readLine()).equals("EOI")) {
            Matcher matcher = pattern.matcher(input.toLowerCase(Locale.ROOT));
            if(matcher.find()){
                System.out.println("Found");
            }else{
                System.out.println("Missing");
            }
        }
    }

}
