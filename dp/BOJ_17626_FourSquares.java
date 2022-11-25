package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 그리디하게 현재 수의 최대 제곱수를 빼는 방법은 사용할 수 없다.
 * 예를 들어 12의 경우 그리디한 방법이라면 3^2을 빼는 방법이 최선(4개)이지만, 2^2를 빼는 방법이 더 최선(3개)일 수도 있다.
 * 그러므로 모든 제곱근의 경우를 고려해야 한다.
 */
public class BOJ_17626_FourSquares {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }

        System.out.println(dp[n]);
    }
}