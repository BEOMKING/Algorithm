package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기 {
    static int N, W, H, answer;
    static int dy[] = new int[]{-1, 0, 1, 0};
    static int dx[] = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            int map[][] = new int[H][W];
            answer = Integer.MAX_VALUE;

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            go(0, map);
            sb.append("#" + t + " " + answer + "\n");
        }
        System.out.print(sb.toString());
    }
    static void attach(int map[][]){ // 벽돌 떨어뜨리기
        for (int x = 0; x < W; x++) {
            int y = H - 1;
            while(y >= 0 && map[y][x] == 0) y--;
            if(y < 0) continue;

            y = H - 1;
            while(y > 0){
                if(map[y][x] == 0){
                    int ny = y - 1;
                    while (ny > 0 && map[ny][x] == 0) ny--;
                    map[y][x] = map[ny][x];
                    map[ny][x] = 0;
                }
                y--;
            }
        }
    }
    static void destroy(int map[][], int y, int x){
        Queue<Point> queue = new LinkedList<>();
        if(map[y][x] > 1){
            queue.offer(new Point(y, x, map[y][x]));
        }
        map[y][x] = 0;

        while(!queue.isEmpty()){
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p.y;
                int nx = p.x;
                for (int k = 1; k < p.count; k++) {
                    ny += dy[i];
                    nx += dx[i];
                    if(ny < 0 || ny >= H || nx < 0 || nx >= W || map[ny][nx] == 0) continue;
                    if(map[ny][nx] > 1){
                        queue.offer(new Point(ny, nx, map[ny][nx]));
                    }
                    map[ny][nx] = 0;
                }
            }
        }
    }
    static void go(int count, int map[][]){
        if(count == N){
            answer = Math.min(answer, numbrick(map));
            return;
        }

        int newMap[][] = new int[H][W];

        for (int x = 0; x < W; x++) {
            int y = 0;
            while(y < H && map[y][x] == 0) y++;
            if(y == H){
                go(count + 1, map);
            }else{
                copy(map, newMap);
                destroy(newMap, y, x);
                attach(newMap);
                go(count + 1, newMap);
            }
        }
    }
    static void copy(int map[][], int newMap[][]){
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                newMap[i][j] = map[i][j];
            }
        }
    }
    static int numbrick(int newMap[][]){
        int result = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(newMap[i][j] != 0) result++;
            }
        }
        return result;
    }
    static class Point{
        int y, x, count;

        public Point(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
}
