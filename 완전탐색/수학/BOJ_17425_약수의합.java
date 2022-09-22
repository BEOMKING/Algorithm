package 완전탐색.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_17425_약수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        long[] prefixSum = new long[1000001];
        Arrays.fill(prefixSum, 1);

        for (int i = 2; i <= 1000000; i++) {
            for (int j = 1; i * j <= 1000000; j++) {
                prefixSum[i * j] += i;
            }
        }

        for (int i = 2; i <= 1000000; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }

        for (int i = 0; i < T; i++) {
            bw.write(prefixSum[Integer.parseInt(br.readLine())] + "\n");
        }
        bw.flush();
    }
}
