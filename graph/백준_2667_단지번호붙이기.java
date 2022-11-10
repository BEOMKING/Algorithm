package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 백준_2667_단지번호붙이기 {

    static char[][] map;
    static boolean[][] visited;
    static int N;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int count = 0;
        List<Integer> houseCount = new ArrayList<>();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (visited[y][x] || map[y][x] == '0') continue;
                count++;
                houseCount.add(dfs(y, x));
            }
        }
        System.out.println(count);
        Collections.sort(houseCount);
        for (int c : houseCount) {
            System.out.println(c);
        }
    }

    private static int dfs(int y, int x) {
        visited[y][x] = true;
        int count = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
            if (visited[ny][nx] || map[ny][nx] == '0') continue;
            count += dfs(ny, nx);
        }

        return count;
    }
}
