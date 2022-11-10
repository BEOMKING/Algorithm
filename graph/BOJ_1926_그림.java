package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926_그림 {

    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static int maxWidth = 0;
    static int count = 0;
    static int[][] paper;
    static boolean[][] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        paper = new int[n][m];
        checked = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (checked[i][j] || paper[i][j] == 0) continue;
                bfs(i, j);
            }
        }

        System.out.print(count + "\n" + maxWidth);

    }

    public static void bfs(int y, int x) {
        count++;
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(y, x));
        checked[y][x] = true;
        int width = 1;

        while (!queue.isEmpty()) {
            Location now = queue.poll();

            for (int k = 0; k < 4; k++) {
                int ny = now.y + dy[k];
                int nx = now.x + dx[k];

                if (ny < 0 || ny >= paper.length || nx < 0 || nx >= paper[0].length) continue;
                if (paper[ny][nx] == 0 || checked[ny][nx]) continue;
                queue.add(new Location(ny, nx));
                width++;
                checked[ny][nx] = true;
            }
        }

        maxWidth = Math.max(maxWidth, width);
    }

    public static class Location {
        int y, x;

        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
