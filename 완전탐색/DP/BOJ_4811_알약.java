package 완전탐색.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4811_알약 {
    static int N;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new long[31][31];

        while ((N = Integer.parseInt(br.readLine())) != 0) {
            System.out.println(brute(N, 0));
        }
    }

    public static long brute(int w, int h) {
        if(w == 0) return 1;
        if(dp[w][h] != 0) return dp[w][h];

        if (w > 0) {
            dp[w][h] += brute(w - 1, h + 1);
        }

        if(h > 0) {
            dp[w][h] += brute(w, h - 1);
        }

        return dp[w][h];
    }

}
