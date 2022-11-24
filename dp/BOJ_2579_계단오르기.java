package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * DP 문제이다. 모든 경우를 탐색하기에는 크기가 너무 크다.
 * 계단을 3연속으로 밟는 것은 불가능한데 각 경우마다 연속되어있는지 일일히 확인하는 것은 비효율적이다.
 *
 * 연속되어있지 않은 것을 보장하는 경우는 두 가지이다.
 *
 * 현재 위치와 현재 위치 - 2를 선택하는 경우  o x o
 * 현재 위치와 현재 위치 -1, 현재 위치 - 3을 선택하는 경우 o x o o
 *
 * 계단값 항상 양수이기 때문에 이 경우를 이용해 풀면 해결된다.
 */
public class BOJ_2579_계단오르기 {
    private static int[] dp;
    private static int[] stairs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stairCount = Integer.parseInt(br.readLine());
        stairs = new int[stairCount + 1];
        dp = new int[stairCount + 1];

        for (int i = 1; i <= stairCount; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(topDown(stairCount));
    }

    private static int topDown(final int index) {
        if (index <= 0) return 0;
        if (dp[index] != 0) return dp[index];

        dp[index] = Math.max(stairs[index] + topDown(index - 2), stairs[index] + stairs[index - 1] + topDown(index - 3));

        return dp[index];
    }
}