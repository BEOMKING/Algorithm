package 완전탐색.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_14002_가장긴증가하는부분수열4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N + 1];
        int[] effectedIndex = new int[N + 1];
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = 1;
            for (int j = i - 1; j > 0; j--) {
                if (A[i] <= A[j]) continue;
                if (dp[i] <= dp[j]) {
                    effectedIndex[i] = j;
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int maxIndex = 0;
        for (int i = 1; i <= N; i++) {
            if (dp[maxIndex] < dp[i]) {
                maxIndex = i;
            }
        }
        System.out.println(dp[maxIndex]);
        Stack<Integer> stack = new Stack<>();
        stack.push(A[maxIndex]);
        int next = effectedIndex[maxIndex];
        while (next != 0) {
            stack.push(A[next]);
            next = effectedIndex[next];
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
