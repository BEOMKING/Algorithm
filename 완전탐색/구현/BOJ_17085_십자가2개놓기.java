package 완전탐색.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17085_십자가2개놓기 {
    static int N, M;
    static char[][] maps;
    static boolean[][] visited;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        maps = new char[N][M];
        for (int i = 0; i < N; i++) {
            maps[i] = br.readLine().toCharArray();
        }
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i][j] == '.') continue;
                dfs(i, j);
            }
        }

        System.out.println(answer);
    }

    static void dfs(int y, int x) {
        for (int size1 = 0; size1 <= 7; size1++) {
            if (!eastWestSouthNorth(y, x, size1)) return;
            check(y, x, size1);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (maps[i][j] == '.') continue;
                    for (int size2 = 0; size2 <= 7; size2++) {
                        if (!eastWestSouthNorth(i, j, size2)) break;
                        answer = Math.max(answer, (4 * size1 + 1) * (4 * size2 + 1));
                    }
                }
            }

            uncheck(y, x, size1);
        }
    }

    private static void uncheck(int y, int x, int size) {
        visited[y][x] = false;

        for (int i = 1; i <= size; i++) {
            for (int j = 0; j < 4; j++) {
                visited[y + dy[j] * i][x + dx[j] * i] = false;
            }
        }
    }

    private static void check(int y, int x, int size) {
        visited[y][x] = true;

        for (int i = 1; i <= size; i++) {
            for (int j = 0; j < 4; j++) {
                visited[y + dy[j] * i][x + dx[j] * i] = true;
            }
        }
    }

    private static boolean eastWestSouthNorth(int y, int x, int i) {
        for (int j = 0; j < 4; j++) {
            int ny = y + dy[j] * i;
            int nx = x + dx[j] * i;

            if (ny < 0 || nx < 0 || ny >= N || nx >= M) return false;
            if (maps[ny][nx] == '.') return false;
            if (visited[ny][nx]) return false;
        }

        return true;
    }
}
