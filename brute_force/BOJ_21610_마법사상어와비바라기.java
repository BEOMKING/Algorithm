package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21610_마법사상어와비바라기 {
    static int N, M, water[][], d, s, result = 0;
    static boolean groom[][];
    static int dy[] = new int[]{0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int dx[] = new int[]{0, -1, -1, 0, 1, 1, 1, 0, -1};
    static Queue<Location> q, g;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 이동 횟수
        water = new int[N + 1][N + 1];
        groom = new boolean[N + 1][N + 1];
        groom[N][1] = true; groom[N][2] = true; groom[N - 1][1] = true; groom[N - 1][2] = true; // 구름 위치

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                water[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken()); // 방향
            s = Integer.parseInt(st.nextToken()); // 이동 칸
            move(d, s);
            copy();
            makegroom();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                result += water[i][j];
            }
        }
        System.out.print(result);
    }

    public static int mod(int n){
        if(n > N){
            n %= N;
        }
        while (n < 1){
            n += N;
        }
        return n;
    }
    private static void makegroom() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(!groom[i][j] && water[i][j] >= 2){
                    water[i][j] -= 2;
                    groom[i][j] = true;
                }else if(groom[i][j]) groom[i][j] = false;
            }
        }

    }
    private static void copy() {
        while (!q.isEmpty()){
            Location now = q.poll();
            int count = 0;
            for (int i = 2; i <= 8; i += 2) {
                int y = now.y + dy[i];
                int x = now.x + dx[i];
                if(y < 1 || y > N || x < 1 || x > N) continue;
                if(water[y][x] < 1) continue;
                count++;
            }
            water[now.y][now.x] += count;
        }
    }

    private static void move(int dir, int count) {
        q = new LinkedList<>();
        g = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (groom[i][j]) {
                    int y = i + dy[dir] * count;
                    int x = j + dx[dir] * count;
                    y = mod(y);
                    x = mod(x);
                    water[y][x]++; // 구름이 이동한 위치에 물 증가
                    groom[i][j] = false;
                    q.add(new Location(y, x));
                    g.add(new Location(y, x));
                }
            }
        }

        while (!g.isEmpty()){
            Location now = g.poll();
            groom[now.y][now.x] = true;
        }
    }
    public static class Location{
        int y, x;
        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
