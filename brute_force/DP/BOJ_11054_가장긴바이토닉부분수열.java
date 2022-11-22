package brute_force.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_11054_가장긴바이토닉부분수열 {
    // i 번째에서 시작하는 가장 긴 감소하는 부분 수열의 길이 == N에서 시작하는 N - i에서 끝나는 가장 긴 증가하는 부분 수열의 길이
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
        int[] reverseDp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (sequence[i] <= sequence[j]) continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            reverseDp[i] = 1;
            for (int j = i + 1; j < N; j++) {
                if (sequence[i] <= sequence[j]) continue;
                reverseDp[i] = Math.max(reverseDp[i], reverseDp[j] + 1);
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(dp[i] + reverseDp[i] - 1, max);
        }
        System.out.println(max);
    }
}
