package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22858_원상복구 {
    static int N, K, count;
    static int[] S, D, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = new int[N + 1];
        D = new int[N + 1];
        T = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }

        while(count < K) {
            for (int i = 1; i <= N; i++) {
                T[D[i]] = S[i];
            }
            for (int i = 1; i <= N; i++) {
                S[i] = T[i];
            }
            count++;
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(S[i] + " ");
        }
    }

}
