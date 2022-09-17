package 완전탐색.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10844_쉬운계단수 {

    public static final int RANGE = 101;
    public static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[RANGE][10];
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < RANGE; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > 0) dp[i][j] += dp[i - 1][j - 1];
                if (j < 9) dp[i][j] += dp[i - 1][j + 1];
                dp[i][j] %= MOD;
            }
        }
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[N][i];
        }
        System.out.println(sum %= MOD);
    }
}
