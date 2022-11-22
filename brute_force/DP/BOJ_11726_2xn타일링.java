package brute_force.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726_2xn타일링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mod = 10007;
        int n = Integer.parseInt(br.readLine());
        int DP[] = new int[n + 1];
        DP[0] = 1; DP[1] = 1;
        for (int i = 2; i <= n; i++) {
            DP[i] = (DP[i - 1] +DP[i - 2]) % mod;
        }
        System.out.print(DP[n]);
    }
}
