package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이되고픈원숭이 {
    static int[] dy = new int[]{1, 0, -1, 0};
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] hy = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
    static int[] hx = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine()); // 말의 움직임 횟수 제한
        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] map = new int[H][W];
        boolean[][][] visited = new boolean[H][W][K + 1]; // 움직임의 횟수는 0 ~ K

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Monkey> q = new LinkedList<>();
        q.add(new Monkey(0, 0, 0, 0));
        visited[0][0][0] = true;
        int result = -1;

        while(!q.isEmpty()){
            Monkey now = q.poll();
            int y = now.y;
            int x = now.x;
            if(now.y == H - 1 && now.x == W - 1) { // 도착지점
                result = now.count; // 가장 먼저 도착하는 것이 최솟값
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
                if(visited[ny][nx][now.horse]) continue;
                if(map[ny][nx] == 1) continue;

                visited[ny][nx][now.horse] = true;
                q.add(new Monkey(ny, nx, now.horse, now.count + 1));
            }

            if(now.horse == K) continue;

            for (int i = 0; i < 8; i++) {
                int ny = y + hy[i];
                int nx = x + hx[i];

                if(ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
                if(visited[ny][nx][now.horse + 1]) continue;
                if(map[ny][nx] == 1) continue;

                visited[ny][nx][now.horse + 1] = true;
                q.add(new Monkey(ny, nx, now.horse + 1, now.count + 1));
            }
        }
        System.out.println(result);
    }
    static class Monkey{
        int y, x, horse, count;

        public Monkey(int y, int x, int horse, int count) {
            this.y = y;
            this.x = x;
            this.horse = horse;
            this.count = count;
        }
    }
}
