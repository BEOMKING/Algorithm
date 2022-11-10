package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1339_단어수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputs = new String[N];
        int[] weights = new int['Z' - 'A' + 1];
        for (int i = 0; i < N; i++) {
            inputs[i] = br.readLine();
            for (int j = 0; j < inputs[i].length(); j++) {
                weights[inputs[i].charAt(j) - 'A'] += Math.pow(10, inputs[i].length() - j - 1);
            }
        }

        int[] value = new int['Z' - 'A' + 1];
        for (int i = 9; i >= 0; i--) {
            int maxIndex = -1;
            int maxValue = 0;

            for (int j = 0; j < weights.length; j++) {
                if (weights[j] > maxValue) {
                    maxValue = weights[j];
                    maxIndex = j;
                }
            }

            if (maxIndex == -1) {
                break;
            }

            weights[maxIndex] = 0;
            value[maxIndex] = i;
        }

        long sum = 0;
        for (int i = 0; i < N; i++) {
            long temp = 0;
            for (int j = 0; j < inputs[i].length(); j++) {
                temp = temp * 10 + value[inputs[i].charAt(j) - 'A'];
            }
            sum += temp;
        }

        System.out.println(sum);
    }
}
