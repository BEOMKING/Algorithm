package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 분할 정복 문제이다.
 * 전체 범위부터 탐색을 시작하고 분할할 때마다 전체 범위를 탐색하는 횟수와 같다.
 * 예를 들어 N이 8일때, 탐색하는 횟수는 N이 8, 4, 2, 1일 때 전체를 탐색하기 때문에 전체 범위를 4번 탐색하는 것과 같다. O(N^2) * 4 = 256
 * N이 16일때, N이 16, 8, 4, 2, 1 이고 횟수는 5번이다. O(N^2) * 5 = 1280
 * 시간 복잡도는 O(N^2) * O(logN + 1) = O(N^2logN)
 */
public class BOJ_2630_색종이만들기 {
    static int[][] maps;
    static int white = 0;
    static int blue = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        maps = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                maps[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        divideAndConquer(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
        System.out.println(count);
    }

    private static void divideAndConquer(int startY, int startX, int size) {
        int w = 0, b = 0;

        for (int y = startY; y < startY + size; y++) {
            for (int x = startX; x < startX + size; x++) {
                count++;
                if (maps[y][x] == 0) {
                    w++;
                } else {
                    b++;
                }
            }
        }

        if (b != 0 && w == 0) {
            blue++;
        } else if (w != 0 && b == 0){
            white++;
        } else {
            divideAndConquer(startY, startX, size / 2);
            divideAndConquer(startY + size / 2, startX, size / 2);
            divideAndConquer(startY, startX + size / 2, size / 2);
            divideAndConquer(startY + size / 2, startX + size / 2, size / 2);
        }
    }
}
