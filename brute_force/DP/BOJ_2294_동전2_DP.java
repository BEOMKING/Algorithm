package brute_force.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2294_동전2_DP {
    static int n, k;
    static int[] value;
    static int[] coin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coin = new int[n + 1];
        value = new int[k + 1];
        for (int i = 1; i <= n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        Arrays.fill(value, 100001);
        value[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = coin[i]; j <= k; j++) {
                value[j] = Math.min(value[j], value[j - coin[i]] + 1);
            }
        }

        if (value[k] == 100001) {
            System.out.println(-1);
        } else {
            System.out.println(value[k]);
        }

    }

}
