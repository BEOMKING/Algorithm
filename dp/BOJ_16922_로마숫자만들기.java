package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 모든 경우의 수는 4^20, 때문에 너무 크다.
 * 만약 IVL와 VIL의 경우를 생각해보면
 * 1 + 5 후에 L 연산이 추가되고, 5 + 1 후에 L 연산이 추가되는데 이는 같은 결과를 가져오기 때문에 연산을 반복할 필요가 없다.
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

/**
 * 조합을 이용해서 풀 수도 있다.
 * IVVI 와 VIIV 는 같다. 즉, 중복 조합 문제이다.
 * 이는 I : 2, V : 2 로 문제를 생각해볼 수 있는 것을 의미한다.
 * 시간 복잡도는 I, V, X, L의 개수의 경우로 나타낼 수 있다.
 * N^4 이므로 최대 160000의 연산을 가진다.
 *
 * I, V, X의 개수를 합치면 L의 개수는 루프를 돌릴 필요가 없다. 그러므로 N^3이 가능하다.
 */
class 조합_풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] checked = new boolean[1001];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                for (int k = 0; k <= n - i - j; k++) {
                    int l = n - i - j - k;
                    int result = 1 * i + j * 5 + k * 10 + l * 50;
                    checked[result] = true;
                }
            }
        }

        int result = 0;
        for (int i = 0; i <= 1000; i++) {
            if (checked[i]) result++;
        }

        System.out.println(result);
    }
}
