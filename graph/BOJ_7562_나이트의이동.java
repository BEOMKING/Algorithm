package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7562_나이트의이동 {
    static char[][] map;
    static int[][] dist;
    static int N;
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], -1);
            }
            String[] start = br.readLine().split(" ");
            String[] target = br.readLine().split(" ");
            int startY = Integer.parseInt(start[0]);
            int startX = Integer.parseInt(start[1]);
            int targetY = Integer.parseInt(target[0]);
            int targetX = Integer.parseInt(target[1]);

            Queue<Location> q = new LinkedList<>();
            q.add(new Location(startY, startX));
            dist[startY][startX] = 0;

            while (!q.isEmpty()) {
                Location now = q.poll();
                if (now.y == targetY && now.x == targetX) {
                    System.out.println(dist[now.y][now.x]);
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int ny = now.y + dy[i];
                    int nx = now.x + dx[i];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                    if (dist[ny][nx] != -1) continue;
                    q.add(new Location(ny, nx));
                    dist[ny][nx] = dist[now.y][now.x] + 1;
                }
            }
        }
    }

    static class Location {
        int y, x;

        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
