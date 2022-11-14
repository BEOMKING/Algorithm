package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1913_달팽이 {
    private static int[] dy;
    private static int[] dx;
    private static int[][] map;
    private static int n, find, findY, findX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        find = Integer.parseInt(br.readLine());
        map = new int[n][n];

//        snail();
        reverseSnail();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        sb.append(findY + 1).append(" ").append(findX + 1);
        System.out.println(sb);
    }

    private static void snail() {
        dy = new int[]{-1, 0, 1, 0};
        dx = new int[]{0, 1, 0, -1};
        int y = n / 2, x = n / 2;
        int now = 2;
        map[y][x] = 1;
        findY = y; findX = x;
        int direction = 0;
        int range = 1;

        while (true) {
            for (int i = 0; i < range; i++) {
                y += dy[direction];
                x += dx[direction];

                if (now == find) {
                    findY = y;
                    findX = x;
                }

                map[y][x] = now++;
                if (now > n * n) return;
            }

            direction = (direction + 1) % 4;
            if (direction % 2 == 0) {
                range++;
            }
        }
    }

    private static void reverseSnail() {
        dy = new int[]{1, 0, -1, 0};
        dx = new int[]{0, 1, 0, -1};
        int now = n * n;
        map[0][0] = now;
        int y = 0, x = 0;
        int direction = 0;

        while (true) {
            while (true) {
                int ny = y + dy[direction];
                int nx = x + dx[direction];
                if (ny < 0 || ny >= n || nx >= n || map[ny][nx] != 0) break;

                if (--now == find) {
                    findY = ny;
                    findX = nx;
                }

                map[ny][nx] = now;
                y = ny; x = nx;
            }

            direction = (direction + 1) % 4;
            if (now == 1) break;
        }
    }
}
