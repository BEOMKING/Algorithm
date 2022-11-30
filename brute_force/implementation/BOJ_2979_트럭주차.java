package brute_force.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 구현 문제이다.
 * 겹치는 시간대를 카운팅해서 금액을 계산하면 된다.
 */
public class BOJ_2979_트럭주차 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        int c = Integer.parseInt(inputs[2]);

        int[] times = new int[101];
        for (int i = 0; i < 3; i++) {
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);

            for (int j = start; j < end; j++) {
                times[j]++;
            }
        }

        int sum = 0;
        for (int i = 1; i < 101; i++) {
            if (times[i] == 1) {
                sum += a;
            } else if (times[i] == 2) {
                sum += b * 2;
            } else if (times[i] == 3) {
                sum += c * 3;
            }
        }

        System.out.println(sum);
    }
}
