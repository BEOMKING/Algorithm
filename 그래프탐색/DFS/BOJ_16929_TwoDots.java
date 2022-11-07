package 그래프탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16929_TwoDots {
    static char[][] map;
    static boolean[][] visited;
    static int fy, fx;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                fy = i;
                fx = j;
                dfs(i, j, 1);
                visited[i][j] = false;
            }
        }

        System.out.println("No");
    }

    private static void dfs(int y, int x, int k) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length) continue;
            if (map[ny][nx] != map[y][x]) continue;
            if (visited[ny][nx]) {
                if (k >= 4) {
                    if (ny == fy && nx == fx) {
                        System.out.println("Yes");
                        System.exit(0);
                    }
                }
            } else {
                visited[ny][nx] = true;
                dfs(ny, nx, k + 1);
                visited[ny][nx] = false;
            }
        }
    }
}
