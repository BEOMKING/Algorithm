package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2193_이친수 {
    public static final int RANGE = 91;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[RANGE][2];
        dp[1][1] = 1; dp[2][0] = 1;
        for (int i = 3; i < RANGE; i++) {
            dp[i][0] = dp[i - 1][1] + dp[i - 1][0];
            dp[i][1] = dp[i - 1][0];
        }
        long sum = 0;
        for (int i = 0; i < 2; i++) {
            sum += dp[N][i];
        }
        System.out.println(sum);
    }
}
