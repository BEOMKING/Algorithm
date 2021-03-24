package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1149_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int map[][] = new int[N + 1][3];
        int value[][] = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            value[i][0] = Math.min(value[i - 1][1], value[i - 1][2]) + map[i][0];
            value[i][1] = Math.min(value[i - 1][0], value[i - 1][2]) + map[i][1];
            value[i][2] = Math.min(value[i - 1][0], value[i - 1][1]) + map[i][2];
        }
        System.out.print(Math.min(Math.min(value[N][0], value[N][1]), value[N][2]));
    }
}
