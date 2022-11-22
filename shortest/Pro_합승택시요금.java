package shortest;

import java.util.Arrays;

class Pro_합승택시요금 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], 100000000);
        }

        for (int i = 0; i < fares.length; i++) {
            int from = fares[i][0];
            int to = fares[i][1];
            dp[from][to] = fares[i][2];
            dp[to][from] = fares[i][2];
        }

        for(int k = 1; k <= n; k++)
            for(int i = 1; i <= n; i++)
                for(int j = 1; j <= n; j++) {
                    if (i == j) {
                        dp[i][j] = 0;
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, dp[s][i] + dp[i][a] + dp[i][b]);
        }
        return answer;
    }
}
