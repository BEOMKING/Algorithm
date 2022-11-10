package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_2206_벽부수고이동하기 {
    static int[] dy = new int[]{1, 0, -1, 0};
    static int[] dx = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M= Integer.parseInt(input[1]);

        int[][] map = new int[N + 1][M + 1];
        boolean[][][] visited = new boolean[N + 1][M + 1][2];
        int result = -1;

        for (int i = 1; i <= N; i++) {
            String in = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = in.charAt(j - 1) - '0';
            }
        }

        Queue<Location> q = new ArrayDeque<>();
        q.add(new Location(1, 1, 1, 1));
        visited[1][1][0] = true;

        while (!q.isEmpty()){
            Location now = q.poll();
            int y = now.y; int x = now.x;

            if(y == N && x == M) {
                result = now.move;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 1 || ny > N || nx < 1 || nx > M) continue;
                if(visited[ny][nx][now.count]) continue;
                visited[ny][nx][now.count] = true;

                int cnt = now.count;
                if(map[ny][nx] == 1) {
                    if(cnt < 1) continue;
                    else --cnt;
                }

                q.add(new Location(ny, nx, cnt, now.move + 1));
            }
        }

        System.out.println(result);
    }
    static class Location{
        int y, x, count, move;

        public Location(int y, int x, int count, int move) {
            this.y = y;
            this.x = x;
            this.count = count;
            this.move = move;
        }
    }
}
