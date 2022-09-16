package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18808_스티커붙이기 {

    static boolean[][] notebook;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        notebook = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[R][C];
            for (int j = 0; j < R; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < C; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < 4; j++) {
                if (check(sticker)) break;
                sticker = rotate(sticker);
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (notebook[i][j]) count++;
            }
        }

        System.out.println(count);
    }

    private static int[][] rotate(int[][] sticker) {
        int[][] temp = new int[sticker[0].length][sticker.length];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                temp[i][j] = sticker[sticker.length - 1 - j][i];
            }
        }
        return temp;
    }

    private static boolean check(int[][] sticker) {
        for (int i = 0; i <= notebook.length - sticker.length; i++) {
            for (int j = 0; j <= notebook[0].length - sticker[0].length; j++) {
                if (available(i, j, sticker)) return true;
            }
        }
        return false;
    }

    private static boolean available(int y, int x, int[][] sticker) {
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                if (sticker[i][j] == 1) {
                    if (notebook[y + i][x + j]) return false;
                }
            }
        }

        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                if (sticker[i][j] == 1) {
                    notebook[y + i][x + j] = true;
                }
            }
        }
        return true;
    }

}
