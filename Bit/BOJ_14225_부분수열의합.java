package Bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14225_부분수열의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sequences = new int[N];
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < inputs.length; i++) {
            sequences[i] = Integer.parseInt(inputs[i]);
        }

        boolean[] available = new boolean[N * 100000 + 1];
        for (int i = 0; i < (1 << N); i++) {
            int sum = 0;

            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0) {
                    sum += sequences[j];
                }
            }

            available[sum] = true;
        }

        int answer = 1;
        for (int i = 1; i <= available.length; i++) {
            if (!available[i]) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}
