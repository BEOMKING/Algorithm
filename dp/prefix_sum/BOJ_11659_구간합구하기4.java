package dp.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11659_구간합구하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] sequence = new int[n + 1];
        input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            sequence[i] = Integer.parseInt(input[i - 1]);
        }

        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + sequence[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            sb.append(prefixSum[end] - prefixSum[start - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
