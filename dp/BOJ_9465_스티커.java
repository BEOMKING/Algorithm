package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 모든 경우를 탐색하기에는 경우의 수가 너무 많다.
 * 이 문제는 DP를 이용하여 풀 수 있다.
 *
 * 50 10 100 20 40
 * 30 50 70 10 60
 *
 * 보기의 예제를 기준으로 각 자리의 최대값은 다음과 같다.
 * 50  40 200 130 250
 * 30 100 110 210 260
 *
 * 여기서 주의할 점은 2행 마지막 열의 값이 260이라는 것이다.
 * 문제를 간단하게 보면 대각선의 합을 구하는 두 가지가 최대값이 나올 경우 같지만 대각선의 값을 건너뛰고 그 다음값을 더하는 경우도 있다.
 * 만약 대각선의 합으로 최대값을 구했다면 2행 마지막 열은 150이 나오지만 대각선을 건너뛰고 200에 60을 더한 260이 나온 경우가 있다는 것을 주의하면 된다.
 */
public class BOJ_9465_스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[3][n + 2];
            int[][] dp = new int[3][n + 2];

            for (int i = 1; i <= 2; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 2; j <= n + 1; j++) {
                    stickers[i][j] = Integer.parseInt(input[j - 2]);
                }
            }

            for (int x = 2; x <= n + 1; x++) {
                for (int y = 1; y <= 2; y++) {
                    if (y == 1) {
                        dp[y][x] = Math.max(dp[2][x - 2], dp[2][x - 1]) + stickers[y][x];
                    } else {
                        dp[y][x] = Math.max(dp[1][x - 2], dp[1][x - 1]) + stickers[y][x];
                    }
                }
            }

            sb.append(Math.max(dp[1][n + 1], dp[2][n + 1])).append("\n");
        }

        System.out.print(sb);
    }
}
