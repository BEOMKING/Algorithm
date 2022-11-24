package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19947_투자의귀재배주형 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[] dp = new int[Y + 1];
        dp[0] = H;
        for (int i = 1; i <= Y; i++) {
            if (i - 5 >= 0) dp[i] = (int) Math.max(dp[i], dp[i - 5] * 1.35);
            if (i - 3 >= 0) dp[i] = (int) Math.max(dp[i], dp[i - 3] * 1.2);
            dp[i] = (int) Math.max(dp[i], dp[i - 1] * 1.05);
        }

        System.out.println(dp[Y]);
    }

}
