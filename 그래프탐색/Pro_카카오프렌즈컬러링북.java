package 그래프탐색;

import java.util.LinkedList;
import java.util.Queue;

public class Pro_카카오프렌즈컬러링북 {
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, 1, 0, -1};

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] checked = new boolean[m][n];

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (picture[y][x] == 0 || checked[y][x]) continue;
                int color = picture[y][x];
                numberOfArea += 1;
                int nowSize = 0;
                Queue<Location> queue = new LinkedList<>();
                queue.add(new Location(y, x));
                checked[y][x] = true;

                while(!queue.isEmpty()) {
                    Location now = queue.poll();
                    nowSize++;

                    for (int i = 0; i < 4; i++) {
                        int ny = now.y + dy[i];
                        int nx = now.x + dx[i];
                        if (ny < 0 || ny >= m || nx < 0 || nx >= n) continue;
                        if (checked[ny][nx] || picture[ny][nx] != color) continue;
                        queue.add(new Location(ny, nx));
                        checked[ny][nx] = true;
                    }

                }

                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, nowSize);

            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    class Location {
        int y, x;

        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
