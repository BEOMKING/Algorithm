package 완전탐색.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 모든 경우의 수는 4^20, 때문에 너무 크다.
 * 만약 IVC와 VIC의 경우를 생각해보면
 * 1 + 5 후에 C 연산이 추가되고, 5 + 1 후에 C 연산이 추가되는데 이는 같은 결과를 가져오기 때문에 연산을 반복할 필요가 없다.
 * 이전 연산이 미래 연산에 영향을 미치기 때문에 동적 프로그래밍을 사용할 수 있다.
 *
 * 최대 나올 수 있는 숫자는 'L'이 20번 나오는 수인 1000이다.
 * 그러므로 시간 복잡도는 N * 1000 = O(N) 시간복잡도이다.
 */
public class BOJ_16922_로마숫자만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[][] dp = new boolean[n + 1][1001];
        dp[1][1] = true; dp[1][5] = true; dp[1][10] = true; dp[1][50] = true;

        for (int count = 2; count <= n; count++) {
            for (int number = 2; number <= 1000; number++) {
                if (dp[count - 1][number - 1]
                || (number - 5 >= 1 && dp[count - 1][number - 5])
                || (number - 10 >= 1 && dp[count - 1][number - 10])
                || (number - 50 >= 1 && dp[count - 1][number - 50])) {
                    dp[count][number] = true;
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= 1000; i++) {
            if (dp[n][i]) result++;
        }

        System.out.println(result);
    }
}
