package brute_force.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_13398_연속합2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sequence = new int[n];
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = sequence[0]; dp[0][1] = sequence[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(sequence[i], dp[i - 1][0] + sequence[i]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + sequence[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(Math.max(dp[i][0], dp[i][1]), max);
        }
        System.out.println(max);
    }

}
