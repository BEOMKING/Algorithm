package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {
    static int[][] map;
    static boolean[][] checked;
    static int y, x, count;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.valueOf(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            y = Integer.valueOf(st.nextToken());
            x = Integer.valueOf(st.nextToken());
            map = new int[y][x];
            checked = new boolean[y][x];
            count = Integer.valueOf(st.nextToken());

            for (int j = 0; j < count; j++) {
                st = new StringTokenizer(br.readLine());
                map[Integer.valueOf(st.nextToken())][Integer.valueOf(st.nextToken())] = 1;
            }

            System.out.println(bfs());
        }
    }

    static int bfs() {
        int count = 0;
        Queue<Location> queue = new LinkedList<>();

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(map[i][j] == 0 || checked[i][j]) continue;
                queue.add(new Location(i, j));
                count++;

                while(!queue.isEmpty()) {
                    Location now = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int ny = now.y + dy[k];
                        int nx = now.x + dx[k];
                        if(ny < 0 || ny >= y || nx < 0 || nx >= x) continue;
                        if(map[ny][nx] == 0 || checked[ny][nx]) continue;
                        checked[ny][nx] = true;
                        queue.add(new Location(ny, nx));
                    }

                }
            }
        }
        return count;
    }

    static class Location {
        int y, x;

        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
