package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1780_종이의개수 {
    private static int[][] maps;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        maps = new int[n][n];
        result = new int[3];
        for (int i = 0; i < n; i++) {
            maps[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        divideConquer(0, 0, n);

        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }

    private static void divideConquer(final int startY, final int startX, final int size) {
        if (check(startY, startX, size)) {
            result[maps[startY][startX] + 1]++;
            return;
        }

        int nSize = size / 3;
        divideConquer(startY, startX, nSize);
        divideConquer(startY + nSize, startX, nSize);
        divideConquer(startY + nSize * 2, startX, nSize);

        divideConquer(startY, startX + nSize, nSize);
        divideConquer(startY + nSize, startX + nSize, nSize);
        divideConquer(startY + nSize * 2, startX + nSize, nSize);

        divideConquer(startY, startX + nSize * 2, nSize);
        divideConquer(startY + nSize, startX + nSize * 2, nSize);
        divideConquer(startY + nSize * 2, startX + nSize * 2, nSize);
    }

    private static boolean check(final int startY, final int startX, final int size) {
        int color = maps[startY][startX];

        for (int i = startY; i < startY + size; i++) {
            for (int j = startX; j < startX + size; j++) {
                if (color != maps[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}