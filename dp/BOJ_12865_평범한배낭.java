package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12865_평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            inputs = br.readLine().split(" ");
            int weight = Integer.parseInt(inputs[0]);
            int value = Integer.parseInt(inputs[1]);

            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - weight < 0) continue;
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
            }
        }

        System.out.println(dp[N][M]);
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
