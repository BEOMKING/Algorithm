package 기업코테;

class LG유플러스_2022_상반기_2번 {

    public int solution(int n, int m , int k) {
        int[][] dp = new int[m + 1][n + 1];
//        Arrays.fill(dp[0], 1);
        dp[0][0] = 1;
        for (int i = 1; i <= m; i++) { // 너비
            for (int j = 1; j <= k; j++) { // 각 차선의 너비
                if (i - j < 0) break;
                for (int l = 1; l <= n; l++) { // 차선의 개수
                    if (i - l < 0) break;
                    dp[i][l] += dp[i - j][l - 1];
                }
            }
        }

        return dp[m][n];
    }

}