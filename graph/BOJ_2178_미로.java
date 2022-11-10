package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로 {
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static char[][] miro;
    static int[][] dist;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new char[N][M];
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            miro[i] = br.readLine().toCharArray();
        }

        System.out.print(bfs(0, 0));

    }

    public static int bfs(int y, int x) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(y, x));
        dist[y][x] = 1;

        while (!queue.isEmpty()) {
            Location now = queue.poll();
            if (now.y == N - 1 && now.x == M - 1) {
                return dist[N - 1][M - 1];
            }

            for (int k = 0; k < 4; k++) {
                int ny = now.y + dy[k];
                int nx = now.x + dx[k];

                if (ny < 0 || ny >= miro.length || nx < 0 || nx >= miro[0].length) continue;
                if (miro[ny][nx] == '0' || dist[ny][nx] != 0) continue;
                queue.add(new Location(ny, nx));
                dist[ny][nx] = dist[now.y][now.x] + 1;
            }
        }

        return 0;
    }

    public static class Location {
        int y, x;

        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
