package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {
    static ArrayList<Camera> cameraList;
    static Camera[] cameras;
    static int[][] map, tempMap;
    static int result = Integer.MAX_VALUE;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cameraList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int kind = Integer.parseInt(st.nextToken());
                map[i][j] = kind;
                if (kind >= 1 && kind <= 5) cameraList.add(new Camera(i, j, kind, 0));
            }
        }
        cameras = new Camera[cameraList.size()];
        brute(0);
        System.out.println(result);
    }

    private static void brute(int count) {
        if (count == cameraList.size()) {
            blindSpot();
            return;
        }

        Camera camera = cameraList.get(count);
        for (int i = 0; i < 4; i++) {
            camera.direct += i;
            cameras[count] = camera;
            brute(count + 1);
            camera.direct -= i;
        }

    }

    private static void blindSpot() {
        int count = 0;
        tempMap = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                tempMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < cameras.length; i++) {
            Camera camera = cameras[i];
            int y = camera.y;
            int x = camera.x;
            int kind = camera.kind;
            int direct = camera.direct;

            if (kind == 1) {
                move(y, x, direct);
            }
            if (kind == 2) {
                move(y, x, direct % 2);
                move(y, x, direct % 2 + 2);
            }
            if (kind == 3) {
                if (direct == 0) {
                    move(y, x, 0);
                    move(y, x, 3);
                }
                if (direct == 1) {
                    move(y, x, 0);
                    move(y, x, 1);
                }
                if (direct == 2) {
                    move(y, x, 1);
                    move(y, x, 2);
                }
                if (direct == 3) {
                    move(y, x, 2);
                    move(y, x, 3);
                }
            }
            if (kind == 4) {
                if (direct == 0) {
                    move(y, x, 2);
                    move(y, x, 3);
                    move(y, x, 0);
                }
                if (direct == 1) {
                    move(y, x, 3);
                    move(y, x, 0);
                    move(y, x, 1);
                }
                if (direct == 2) {
                    move(y, x, 0);
                    move(y, x, 1);
                    move(y, x, 2);
                }
                if (direct == 3) {
                    move(y, x, 1);
                    move(y, x, 2);
                    move(y, x, 3);
                }
            }
            if (kind == 5) {
                move(y, x, 0);
                move(y, x, 1);
                move(y, x, 2);
                move(y, x, 3);
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (tempMap[i][j] == 0) count++;
            }
        }

        result = Math.min(count, result);

    }

    public static void move(int y, int x, int direct) {
        int ny = y, nx = x;
        while (true) {
            ny += dy[direct];
            nx += dx[direct];
            if (ny < 0 || ny >= map.length || nx < 0 || nx >= map[0].length || tempMap[ny][nx] == 6) return;
            tempMap[ny][nx] = 7;
        }
    }

    public static class Camera {
        int y, x, kind, direct;

        public Camera(int y, int x, int kind, int direct) {
            this.y = y;
            this.x = x;
            this.kind = kind;
            this.direct = direct;
        }
    }

}
