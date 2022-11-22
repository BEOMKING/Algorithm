package brute_force.DP;

class Pro_코딩테스트공부 {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0;
        int maxCop = 0;
        for (int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }

        if (alp >= maxAlp && cop >= maxCop) {
            return 0;
        }

        if (alp >= maxAlp) {
            alp = maxAlp;
        }
        if (cop >= maxCop) {
            cop = maxCop;
        }

        int[][] dp = new int[maxAlp + 2][maxCop + 2];
        for (int i = alp; i < maxAlp + 1; i++) {
            for (int j = cop; j < maxCop + 1; j++) {
                dp[i][j] = 100000;
            }
        }

        dp[alp][cop] = 0;
        for (int i = alp; i < maxAlp + 1; i++) {
            for (int j = cop; j < maxCop + 1; j++) {
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                for (int[] problem : problems) {
                    if (i >= problem[0] && j >= problem[1]) {
                        int nAlp = i + problem[2];
                        int nCop = j + problem[3];
                        if (nAlp > maxAlp) nAlp = maxAlp;
                        if (nCop > maxCop) nCop = maxCop;
                        dp[nAlp][nCop] = Math.min(dp[nAlp][nCop], dp[i][j] + problem[4]);
                    }
                }
            }
        }

        return dp[maxAlp][maxCop];
    }
}
