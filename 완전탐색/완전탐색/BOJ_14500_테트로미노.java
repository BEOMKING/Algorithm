package 완전탐색.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14500_테트로미노 {
    static int max = 0;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        int[][] maps = new int[N + 6][M + 6];

        for (int i = 3; i < N + 3; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 3; j < M + 3; j++) {
                maps[i][j] = Integer.parseInt(inputs[j - 3]);
            }
        }

        brute(maps);
        System.out.println(max);
    }

    private static void brute(final int[][] maps) {
        for (int i = 3; i < N + 3; i++) {
            for (int j = 3; j < M + 3; j++) {
                max = Math.max(max, maps[i][j] + maps[i + 1][j] + maps[i + 2][j] + maps[i + 3][j]);
                max = Math.max(max, maps[i][j] + maps[i][j + 1] + maps[i][j + 2] + maps[i][j + 3]);

                max = Math.max(max, maps[i][j] + maps[i][j + 1] + maps[i + 1][j] + maps[i + 1][j + 1]);

                max = Math.max(max, maps[i][j] + maps[i][j + 1] + maps[i][j + 2] + maps[i + 1][j + 2]);
                max = Math.max(max, maps[i][j] + maps[i][j + 1] + maps[i][j + 2] + maps[i - 1][j + 2]);
                max = Math.max(max, maps[i][j] + maps[i + 1][j] + maps[i + 2][j] + maps[i + 2][j + 1]);
                max = Math.max(max, maps[i][j] + maps[i + 1][j] + maps[i + 2][j] + maps[i + 2][j - 1]);
                max = Math.max(max, maps[i][j] + maps[i - 1][j] + maps[i - 2][j] + maps[i - 2][j - 1]);
                max = Math.max(max, maps[i][j] + maps[i - 1][j] + maps[i - 2][j] + maps[i - 2][j + 1]);
                max = Math.max(max, maps[i][j] + maps[i][j - 1] + maps[i][j - 2] + maps[i - 1][j - 2]);
                max = Math.max(max, maps[i][j] + maps[i][j - 1] + maps[i][j - 2] + maps[i + 1][j - 2]);

                max = Math.max(max, maps[i][j] + maps[i][j + 1] + maps[i + 1][j + 1] + maps[i + 1][j + 2]);
                max = Math.max(max, maps[i][j] + maps[i][j + 1] + maps[i - 1][j + 1] + maps[i - 1][j + 2]);
                max = Math.max(max, maps[i][j] + maps[i + 1][j] + maps[i + 1][j + 1] + maps[i + 2][j + 1]);
                max = Math.max(max, maps[i][j] + maps[i + 1][j] + maps[i + 1][j - 1] + maps[i + 2][j - 1]);

                max = Math.max(max, maps[i][j] + maps[i][j + 1] + maps[i + 1][j + 1] + maps[i][j + 2]);
                max = Math.max(max, maps[i][j] + maps[i][j + 1] + maps[i - 1][j + 1] + maps[i][j + 2]);
                max = Math.max(max, maps[i][j] + maps[i + 1][j] + maps[i + 1][j + 1] + maps[i + 2][j]);
                max = Math.max(max, maps[i][j] + maps[i + 1][j] + maps[i + 1][j - 1] + maps[i + 2][j]);
            }
        }
    }
}
