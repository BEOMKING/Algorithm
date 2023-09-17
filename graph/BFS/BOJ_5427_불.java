package graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_5427_불 {
    static Queue<Location> fQueue, sQueue;
    static char[][] maps;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int y, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String[] inputs = br.readLine().split(" ");
            x = Integer.parseInt(inputs[0]);
            y = Integer.parseInt(inputs[1]);
            fQueue = new LinkedList<>();
            sQueue = new LinkedList<>();
            maps = new char[y][x];
            for (int i = 0; i < y; i++) {
                maps[i] = br.readLine().toCharArray();
                for (int j = 0; j < x; j++) {
                    if (maps[i][j] == '*') {
                        fQueue.add(new Location(i, j));
                    } else if (maps[i][j] == '@') {
                        sQueue.add(new Location(i, j));
                    }
                }
            }

            int count = bfs();
            sb.append(count != -1 ? count : "IMPOSSIBLE").append("\n");
        }

        System.out.println(sb);
    }

    private static int bfs() {
        int count = 0;

        while (!sQueue.isEmpty()) {
            count++;

            final int fSize = fQueue.size();
            for (int i = 0; i < fSize; i++) {
                Location now = fQueue.poll();

                for (int j = 0; j < 4; j++) {
                    int ny = now.y + dy[j];
                    int nx = now.x + dx[j];

                    if (ny < 0 || ny >= y || nx < 0 || nx >= x) {
                        continue;
                    }

                    char c = maps[ny][nx];
                    if (c == '*' || c == '#') {
                        continue;
                    }

                    maps[ny][nx] = '*';
                    fQueue.add(new Location(ny, nx));
                }
            }

            final int sSize = sQueue.size();
            for (int i = 0; i < sSize; i++) {
                Location now = sQueue.poll();

                for (int j = 0; j < 4; j++) {
                    int ny = now.y + dy[j];
                    int nx = now.x + dx[j];

                    if (ny < 0 || ny >= y || nx < 0 || nx >= x) {
                        return count;
                    }

                    char c = maps[ny][nx];
                    if (c == '*' || c == '#' || c == 'S') {
                        continue;
                    }

                    maps[ny][nx] = 'S';
                    sQueue.add(new Location(ny, nx));
                }
            }
        }

        return -1;
    }

    private static class Location {
        int y;
        int x;

        public Location(final int y, final int x) {
            this.y = y;
            this.x = x;
        }
    }
}
