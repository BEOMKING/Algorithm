package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15990_123더하기5 {
    public static final int mod = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[100001][4];
        dp[1][1] = 1; dp[2][2] = 1; dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;

        for (int i = 4; i <= 100000; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % mod;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % mod;
        }

        for (int i = 0; i < n; i++) {
            int find = Integer.parseInt(br.readLine());
            sb.append((dp[find][1] + dp[find][2] + dp[find][3]) % mod).append("\n");
        }
        System.out.println(sb);
    }
}
