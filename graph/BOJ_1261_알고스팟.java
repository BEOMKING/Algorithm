package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class BOJ_1261_알고스팟 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Deque<Location> deque = new ArrayDeque<>();
        deque.add(new Location(0, 0, 0));
        visited[0][0] = true;

        while (!deque.isEmpty()) {
            Location now = deque.pollFirst();
            if (now.y == N - 1 && now.x == M - 1) {
                System.out.println(now.breaking);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] == '1') {
                    deque.addLast(new Location(ny, nx, now.breaking + 1));
                } else {
                    deque.addFirst(new Location(ny, nx, now.breaking));
                }
                visited[ny][nx] = true;
            }
        }
    }

    static class Location {
        int y, x, breaking;

        public Location(int y, int x, int breaking) {
            this.y = y;
            this.x = x;
            this.breaking = breaking;
        }
    }
}
