package 완전탐색.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BOJ_15988_123더하기3 {

    public static final int RANGE = 1000001;
    public static final int MOD = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] dp = new long[RANGE];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        for (int i = 4; i < RANGE; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            dp[i] %= MOD;
        }
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }

}
