package 완전탐색.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156_포도주시식 {

    public static final int RANGE = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[RANGE];
        int[] amount = new int[RANGE];
        for (int i = 1; i <= n; i++) {
            amount[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = amount[1]; dp[2] = dp[1] + amount[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + amount[i], dp[i - 3] + amount[i - 1] + amount[i]));
        }

        System.out.println(dp[n]);
    }
}
