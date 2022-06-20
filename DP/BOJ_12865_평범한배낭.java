package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][K + 1];
        for (int item = 1; item <= N; item++) {
            for (int weight = 1; weight <= K; weight++) {
                dp[item][weight] = dp[item - 1][weight];
                if (weight - weights[item] >= 0) {
                    dp[item][weight] = Math.max(dp[item - 1][weight], dp[item - 1][weight - weights[item]] + values[item]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//        int[] weights = new int[N + 1];
//        int[] values = new int[N + 1];
//        for (int i = 1; i <= N; i++) {
//            st = new StringTokenizer(br.readLine());
//            weights[i] = Integer.parseInt(st.nextToken());
//            values[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int[] dp = new int[K + 1];
//        for (int item = 1; item <= N; item++) {
//            for (int weight = K; weight >= 1; weight--) {
//                if (weight - weights[item] >= 0) {
//                    dp[weight] = Math.max(dp[weight], dp[weight - weights[item]] + values[item]);
//                }
//            }
//        }
//        System.out.println(dp[K]);
//    }
}
