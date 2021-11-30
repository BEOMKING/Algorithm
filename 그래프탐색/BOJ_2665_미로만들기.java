package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_2665_미로만들기 {
    static int N;
    static char[][] map;
    static boolean[][] checked;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        map = new char[N][N];
        checked = new boolean[N][N];

        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();
        System.out.println(bfs());
    }

    private static int bfs() {
        int result = Integer.MAX_VALUE;
        PriorityQueue<Location> queue = new PriorityQueue<>();
        queue.add(new Location(0, 0, 0));
        checked[0][0] = true;

        while (!queue.isEmpty()) {
            Location now = queue.poll();
            if(now.y == N - 1 && now.x == N - 1) {
                result = Math.min(result, now.count);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if(map[ny][nx] == '0') {
                    if(checked[ny][nx]) continue;
                    checked[ny][nx]= true;
                    queue.add(new Location(ny, nx, now.count + 1));
                }
                else {
                    if(checked[ny][nx]) continue;
                    checked[ny][nx] = true;
                    queue.add(new Location(ny, nx, now.count));
                }
            }
        }

        return result;
    }

    static class Location implements Comparable<Location>{
        int y, x, count;

        public Location(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }

        @Override
        public int compareTo(Location o) {
            return count - o.count;
        }
    }

}
