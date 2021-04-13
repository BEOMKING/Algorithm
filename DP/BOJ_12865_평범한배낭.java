package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물건의 수
        int K = Integer.parseInt(st.nextToken()); // 배낭 무게
        int Weight[] = new int[N + 1];
        int Value[] = new int[N + 1];
        int DP[][] = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            Weight[i] = Integer.parseInt(st.nextToken());
            Value[i] = Integer.parseInt(st.nextToken());
        }

        for (int n = 1; n <= N; n++) {
            for (int k = 1; k <= K; k++) {
                if(Weight[n] <= k){
                    DP[n][k] = Math.max(DP[n - 1][k], DP[n - 1][k - Weight[n]] + Value[n]);
                }else{
                    DP[n][k] = DP[n - 1][k];
                }
            }
        }
        System.out.print(DP[N][K]);
    }
}
