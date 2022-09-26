package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2217_루프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ropes = new int[N];
        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        Arrays.sort(ropes);

        for (int i = N - 1; i >= 0; i--) {
            max = Math.max(max, ropes[i] * (N - i));
        }

        System.out.println(max);
    }
}
