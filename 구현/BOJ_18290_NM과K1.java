package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18290_NM과K1 {
    static int[][] map;
    static boolean[][] checked;
    static int N, M, K, max = Integer.MIN_VALUE;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        checked = new boolean[N][M];
        brute(0, 0, 0, 0);
        System.out.println(max);
    }

    public static void brute(int count, int sum, int y, int x) {
        if (count == K) {
            max = Math.max(sum, max);
            return;
        }

        for (int i = y; i < N; i++) {
            for (int j = (i == y ? x : 0); j < M; j++) {
                if (checked[i][j]) continue;
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                        if (checked[ny][nx]) flag = false;
                    }
                }
                if (!flag) continue;
                checked[i][j] = true;
                brute(count + 1, sum + map[i][j], i, j);
                checked[i][j] = false;
            }
        }

    }
}
