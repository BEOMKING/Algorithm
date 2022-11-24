package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2281_데스노트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] nameLengths = new int[n];
        for (int i = 0; i < n; i++) {
            nameLengths[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            dp[i] = Math.min(dp[i], (int) Math.pow(m - nameLengths[i], 2) + dp[i + 1]);
            int sumLength = nameLengths[i];
            for (int j = i + 1; j < n; j++) {
                sumLength += (nameLengths[j] + 1);
                if (sumLength > m) break;
                if (j == n - 1) {
                    dp[i] = 0;
                    break;
                }
                dp[i] = Math.min(dp[i], (int) Math.pow(m - sumLength, 2) + dp[j + 1]);
            }
        }

        System.out.println(dp[0]);
    }
}
