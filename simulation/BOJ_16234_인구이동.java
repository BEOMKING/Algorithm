package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16234_인구이동 {
    static int N, L, R, sum;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Location> alliances;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int answer = 0;
        boolean flag = true;

        while (flag) {
            visited = new boolean[N][N];
            flag = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;
                    alliances = new LinkedList<>();
                    visited[i][j] = true;
                    alliances.add(new Location(i, j));
                    sum = map[i][j];

                    findNearbyAlliances(i, j);

                    if (alliances.size() <= 1) continue;

                    movePopulation();
                    flag = true;
                }
            }

            if (flag) answer++;
        }

        System.out.println(answer);
    }

    private static void movePopulation() {
        int size = alliances.size();
        int population = sum / size;

        while (!alliances.isEmpty()) {
            Location location = alliances.poll();
            map[location.y][location.x] = population;
        }
    }

    private static void findNearbyAlliances(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
            if (visited[ny][nx]) continue;

            int diff = Math.abs(map[y][x] - map[ny][nx]);
            if (diff < L || diff > R) continue;

            visited[ny][nx] = true;
            alliances.add(new Location(ny, nx));
            sum += map[ny][nx];
            findNearbyAlliances(ny, nx);
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
