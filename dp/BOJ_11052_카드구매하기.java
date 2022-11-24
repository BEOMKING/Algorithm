package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 복잡도 O(N^2)
public class BOJ_11052_카드구매하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] cards = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[1001];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i - j < 0) break;
                dp[i] = Math.max(dp[i], dp[i - j] + cards[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
