package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_14502_연구소 {
    static int map[][];
    static int N;
    static int M;
    static int max;
    static int dy[] = new int[]{-1, 0, 1, 0};
    static int dx[] = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0);
        System.out.print(max);
    }
    static void combi(int count){
        if(count == 3) {
            score(bfs());
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != 0) continue;
                map[i][j] = 1;
                combi(count + 1);
                map[i][j] = 0;
            }
        }
    }
    static int[][] bfs(){
        int temp[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = map[i][j];
            }
        }

        Queue<Location> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 2) {
                    queue.offer(new Location(i, j));
                }
            }
        }

        Location now = null;
        int ny, nx;
        while (!queue.isEmpty()){
            now = queue.poll();

            for (int k = 0; k < 4; k++) {
                ny = now.y + dy[k];
                nx = now.x + dx[k];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (temp[ny][nx] == 0) {
                    temp[ny][nx] = 2;
                    queue.offer(new Location(ny, nx));
                }
            }
        }
        return temp;
    }
    static void score(int[][] temp){
        int safe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(temp[i][j] == 0) safe += 1;
            }
        }
        max = Math.max(max, safe);
    }
    static class Location{
        int y;
        int x;
        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
