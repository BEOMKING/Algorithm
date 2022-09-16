package 완전탐색.비트마스크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1182_부분수열의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int S = Integer.parseInt(inputs[1]);

        int[] sequence = new int[N];
        inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(inputs[i]);
        }

        int answer = 0;
        for (int i = 1; i < 1 << N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += sequence[j];
                }
            }
            if (sum == S) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
