package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003_피보나치함수 {
    private static int[][] dp = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        fibonacci(40);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }

        System.out.println(sb);
    }

    private static int[] fibonacci(int n) {
        if (dp[n][0] != 0 || dp[n][1] != 0) {
            return dp[n];
        } else if (n == 0) {
            return dp[0] = new int[]{1, 0};
        } else if (n == 1) {
            return dp[1] = new int[]{0, 1};
        } else {
            dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
            return dp[n];
        }
    }
}
