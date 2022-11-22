package brute_force.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2225_합분해 {
    public static final int RANGE = 201;
    public static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // dp[N][K] = n ~ 0까지의 K - 1개를 사용한 수의 개수이다.
        int[][] dp = new int[RANGE][RANGE];
        dp[0][0] = 1;
        for (int i = 0; i <= N; i++) { // N이 되는 수
            for (int j = 1; j <= K; j++) { // 가지수
                for (int k = 0; k <= i; k++) { // N을 만드는 수
                    dp[i][j] += dp[i - k][j - 1];
                    dp[i][j] %= MOD;
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
