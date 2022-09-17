package 완전탐색.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_11055_가장큰증가부분수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] sequence = new int[N];
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        dp[0] = sequence[0];
        for (int i = 1; i < N; i++) {
            dp[i] = sequence[i];
            for (int j = i - 1; j >= 0; j--) {
                if (sequence[i] <= sequence[j]) continue;
                dp[i] = Math.max(dp[i], dp[j] + sequence[i]);
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
