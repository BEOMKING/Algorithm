package DFSBFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class Pro_게임맵최단거리 {
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, 1, 0, -1};
    boolean visited[][];

    public int solution(int[][] maps) {
        int answer = -1;
        int N = maps.length;
        int M = maps[0].length;
        visited = new boolean[N][M];
        Queue<Location> q = new ArrayDeque<>();
        q.add(new Location(0, 0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()){
            Location now = q.poll();
            int y = now.y; int x = now.x;
            if(y == N - 1 && x == M - 1){
                answer = now.count + 1;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if(visited[ny][nx] || maps[ny][nx] == 0) continue;
                q.add(new Location(ny, nx, now.count + 1));
                visited[ny][nx] = true;
            }
        }

        return answer;
    }

    class Location{
        int y, x, count;

        public Location(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

}
