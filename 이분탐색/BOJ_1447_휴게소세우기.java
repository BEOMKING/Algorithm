package 이분탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1447_휴게소세우기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int L = Integer.parseInt(inputs[2]);

        int[] restStops = new int[N + 2];
        restStops[0] = 0;
        restStops[N + 1] = L;

        inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            restStops[i + 1] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(restStops);
        int left = 1;
        int right = L;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int i = 0; i < restStops.length - 1; i++) {
                count += (restStops[i + 1] - restStops[i] - 1) / mid;
            }

            if (count > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);
    }
}
