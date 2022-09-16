package 완전탐색.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14888_연산자끼워넣기 {
    static int[] operations;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }
        inputs = br.readLine().split(" ");
        operations = new int[4];
        for (int i = 0; i < 4; i++) {
            operations[i] = Integer.parseInt(inputs[i]);
        }

        brute(numbers, 1, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void brute(final int[] numbers, final int count, final int sum) {
        if (count == numbers.length) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operations[i] > 0) {
                operations[i]--;
                if (i == 0) {
                    brute(numbers, count + 1, sum + numbers[count]);
                } else if (i == 1) {
                    brute(numbers, count + 1, sum - numbers[count]);
                } else if (i == 2) {
                    brute(numbers, count + 1, sum * numbers[count]);
                } else {
                    if (sum < 0) {
                        brute(numbers, count + 1, -((-sum) / numbers[count]));
                    } else {
                        brute(numbers, count + 1, sum / numbers[count]);
                    }
                }
                operations[i]++;
            }
        }
    }
}
