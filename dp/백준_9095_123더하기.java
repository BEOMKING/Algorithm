package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_9095_123더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] dp = new int[11];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            sb.append(dp[Integer.parseInt(br.readLine())] + "\n");
        }
        System.out.println(sb);
    }
}
