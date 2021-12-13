package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {
    static int N, M, result = 0;
    static int[][] map;
    static boolean[][] checked;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static Queue<Robot> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        checked = new boolean[N][M];
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        queue.add(new Robot(r, c, d));
        bfs();

        System.out.println(result);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Robot now = queue.poll();
            if(!checked[now.y][now.x]) result++;
            checked[now.y][now.x] = true;

            search(now.y, now.x, now.d);
        }

    }

    private static void search(int y, int x, int d) {
        for (int i = 0; i < 4; i++) {
            int nd = (3 + d) % 4;
            int ny = y + dy[nd];
            int nx = x + dx[nd];
            if(map[ny][nx] == 0 && !checked[ny][nx]) {
                queue.add(new Robot(ny, nx, nd));
                return;
            }
            d = nd;
        }
        if(map[y - dy[d]][x - dx[d]] == 0) {
            queue.add(new Robot(y - dy[d], x - dx[d], d));
            return;
        }
    }

    public static class Robot {
        int y, x, d;

        public Robot(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }

}
