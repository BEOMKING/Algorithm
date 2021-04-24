package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1535_안녕 {
    static int N, dp[][], life[], hn[];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][100];
        hn = new int[N + 1];
        life = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            life[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= N; j++) {
            hn[j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 99; j++) {
                if (j - life[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j],  dp[i - 1][j - life[i]] + hn[i]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][99]);
    }
}
