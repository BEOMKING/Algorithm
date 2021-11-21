package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_토마토 {
    static int N, M, H, map[][][], count = 0, ny, nx;
    static int dy[];
    static int dx[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이

        map = new int[H][N][M];
        dy = new int[]{-1, 0, 1, 0};
        dx = new int[]{0, 1, 0, -1, 0, 0};
        int time = 0;
        Queue<Tomato> queue = new LinkedList<>();
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine()) ;
                for (int j = 0; j < M; j++) {
                    int now = Integer.parseInt(st.nextToken());
                    map[k][i][j] = now;
                    if(now == 1) {
                        queue.add(new Tomato(k, i, j, 0));
                    }else if(now == 0){
                        count++;
                    }
                }
            }
        }


        while (!queue.isEmpty()){
            Tomato now = queue.poll();
            time = Math.max(time, now.time);
            int y = now.y;
            int x = now.x;

            for (int i = 0; i < 4; i++) {
                ny = y + dy[i];
                nx = x + dx[i];
                if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if(map[now.h][ny][nx] != 0) continue;
                map[now.h][ny][nx] = 1;
                count--;
                queue.add(new Tomato(now.h, ny, nx, now.time + 1));
            }
            if(now.h + 1 < H && map[now.h + 1][y][x] == 0){
                map[now.h + 1][y][x] = 1;
                count--;
                queue.add(new Tomato(now.h + 1, y, x, now.time + 1));
            }
            if(now.h -1 >= 0 && map[now.h - 1][y][x] == 0){
                map[now.h - 1][y][x] = 1;
                count--;
                queue.add(new Tomato(now.h - 1, y, x, now.time + 1));
            }
        }

        if(count == 0){
            System.out.print(time);
        }else{
            System.out.print(-1);
        }
    }

    static class Tomato{
        int h, y, x, time;
        public Tomato(int h, int y, int x, int time) {
            this.h = h;
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }
}
