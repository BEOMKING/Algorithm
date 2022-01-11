package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20365_블로그2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        st = new StringTokenizer(input, "B");
        int rCount = st.countTokens();

        st = new StringTokenizer(input, "R");
        int bCount = st.countTokens();

        System.out.println(Math.min(rCount, bCount) + 1);

    }

}
