package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9461_파도반수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        long[] arr = new long[101];
        arr[1] = 1; arr[2] = 1; arr[3] = 1; arr[4] = 2;
        for (int i = 5; i < 101; i++) {
            arr[i] = arr[i - 1] + arr[i - 5];
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n]).append("\n");
        }

        System.out.println(sb);
    }
}