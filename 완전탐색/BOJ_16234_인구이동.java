package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, L, R, count, sum, result = 0;
    static int[][] map;
    static boolean[][] checked;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static Queue<Location> queue;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        initial();
        while(true) {
            checked = new boolean[N][N];
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (checked[i][j]) continue;
                    sum = map[i][j];
                    checked[i][j] = true;
                    queue = new LinkedList<>();
                    queue.add(new Location(i, j));
                    simulation(i, j);
                    count = queue.size();
                    while(!queue.isEmpty()) {
                        Location now = queue.poll();
                        map[now.y][now.x] = sum / count;
                    }
                    if(count > 1) flag = true;
                }
            }
            if(!flag) break;
            result++;
        }

        System.out.println(result);
    }

    private static void simulation(int y, int x) {
        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];
            if(ny < 0 || ny >= N || nx < 0 || nx >= N || checked[ny][nx]) continue;
            int diff = Math.abs(map[y][x] - map[ny][nx]);
            if(diff < L || diff > R) continue;
            queue.add(new Location(ny, nx));
            checked[ny][nx] = true;
            sum += map[ny][nx];
            simulation(ny, nx);
        }

    }

    private static void initial() throws IOException {
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static class Location {
        int y, x;

        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
