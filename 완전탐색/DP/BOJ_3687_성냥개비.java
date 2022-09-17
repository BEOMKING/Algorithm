package 완전탐색.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3687_성냥개비 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[][] dp = new String[101][2];
        dp[2][0] = "1"; dp[3][0] = "7"; dp[4][0] = "4"; dp[5][0] = "2"; dp[6][0] = "6"; dp[7][0] = "8"; dp[8][0] = "10";
        dp[2][1] = "1"; dp[3][1] = "7"; dp[4][1] = "11"; dp[5][1] = "71"; dp[6][1] = "111"; dp[7][1] = "711"; dp[8][1] = "1111";
        for (int i = 9; i < 101; i++) {
            for (int j = 2; j <= 7; j++) {
                if (dp[i][0] == null) {
                    dp[i][0] = dp[i - j][0] + dp[j][0];
                } else {
                    if (j == 6) {
                        dp[i][0] = String.valueOf(Math.min(Long.parseLong(dp[i][0]), Long.parseLong(dp[i - j][0] + "0")));
                    } else {
                        dp[i][0] = String.valueOf(Math.min(Long.parseLong(dp[i][0]), Long.parseLong(dp[i - j][0] + dp[j][0])));
                    }
                }
            }
            dp[i][1] = dp[i - 2][1] + "1";
        }

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N][0] + " " + dp[N][1]);
        }
    }
}
