package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {
    static int N, M, max = 0;
    static int[][] map;
    static boolean[][] checked;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        checked = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                checked[i][j] = true;
                dfs(i, j, 0, 0);
                checked[i][j] = false;
                specify(i , j);
            }
        }

        System.out.println(max);
    }

    private static void dfs(int y, int x, int count, int sum) {
        if(count == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || ny >= N || nx < 0 || nx >= M || checked[ny][nx]) continue;
            checked[ny][nx] = true;
            dfs(ny, nx, count + 1, sum + map[ny][nx]);
            checked[ny][nx] = false;
        }
    }

    private static void specify(int y, int x) {
        if(y - 1 >= 0 && x + 1 < M && y + 1 < N) {
            max = Math.max(max, map[y][x] + map[y - 1][x] + map[y][x + 1] + map[y + 1][x]);
        }
        if(y + 1 < N && x - 1 >= 0 && x + 1 < M) {
            max = Math.max(max, map[y][x] + map[y + 1][x] + map[y][x - 1] + map[y][x + 1]);
        }
        if(y - 1 >= 0 && x - 1 >= 0 && y + 1 < N) {
            max = Math.max(max, map[y][x] + map[y - 1][x] + map[y][x - 1] + map[y + 1][x]);
        }
        if(y - 1 >= 0 && x - 1 >= 0 && x + 1 < M) {
            max = Math.max(max, map[y][x] + map[y - 1][x] + map[y][x - 1] + map[y][x + 1]);
        }

    }

}
