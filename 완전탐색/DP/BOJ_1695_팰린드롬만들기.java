package 완전탐색.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * 팰린드롬을 찾는 시간 복잡도는 O(N)이다.
 * 어느 위치에 끼워넣어도 되기 때문에 완전 탐색으로 하기에는 경우의 수가 너무 많고 매번 팰린드롬을 확인하는 것은 시간 복잡도가 크다.
 * 1 2 3 의 경우 안쪽에서 수를 채워넣는 것은 의미가 없다. 1 2 2 1 3
 * 그러므로 바깥부터 맞추는 방법으로 접근했다.
 * 가장 바깥을 비교하고 같으면 그 사이의 값을 확인한다. i + 1, j - 1
 * 바깥이 다를 경우 왼쪽에 맞는 수를 하나 끼웠다고 가정한 로직을, 오른쪽에 맞는 수를 하나 끼웠다고 가정한 로직을 수행했고 이 중에 작은 값을 사용했다.
 * 이 경우 시간 복잡도는 O(N^2)
 *
 * 아래는 LCS 풀이
 */
public class BOJ_1695_팰린드롬만들기 {
    static int[][] dp;
    static String[] sequences;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sequences = br.readLine().split(" ");
        dp = new int[n][n];

        System.out.println(topDown(0, n - 1));
//        System.out.println(lcs(n));
    }

    private static int topDown(int left, int right) {
        if (dp[left][right] > 0) {
            return dp[left][right];
        }

        if (left >= right) {
            return 0;
        }

        if (!Objects.equals(sequences[left], sequences[right])) {
            return dp[left][right] = Math.min(topDown(left + 1, right), topDown(left, right - 1)) + 1;
        }

        return dp[left][right] = topDown(left + 1, right - 1);
    }

    public static int lcs(int n) {
        dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (sequences[j - 1].equals(sequences[n - i])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return n - dp[n][n];
    }
}
