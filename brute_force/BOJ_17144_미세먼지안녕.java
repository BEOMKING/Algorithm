package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {
    static int R, C, T, answer, map[][];
    static int dy[] = new int[]{-1, 0, 1, 0};
    static int dx[] = new int[]{0, 1, 0, -1};
    static Cleaner top, down;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        int topdown = 0;

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int now = Integer.parseInt(st.nextToken());
                map[i][j] = now;
                if(now == -1 && topdown == 0){
                    top = new Cleaner(i, j);
                    topdown++;
                }else if(now == -1 && topdown == 1){
                    down = new Cleaner(i, j);
                }
            }
        }

        for (int t = 0; t < T; t++) {
            spread();
            map[top.y][top.x] = -1;
            map[down.y][down.x] = -1;
            tclean();
            dclean();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] != -1) answer += map[i][j];
            }
        }
        System.out.print(answer);
    }
    static void tclean(){ // 순서, 바람의 방향으로 계산하는 것이 아닌 반대 방향으로 계산
        for(int i = top.y - 1; i > 0; i--){
            map[i][0] = map[i - 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            map[0][i] = map[0][i + 1];
        }
        for(int i = 0; i < top.y; i++){
            map[i][C - 1] = map[i + 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            map[top.y][i] = map[top.y][i - 1];
        }
        map[top.y][1] = 0;
    }
    static void dclean(){
        for(int i = down.y + 1; i < R - 1; i++){
            map[i][0] = map[i + 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            map[R - 1][i] = map[R - 1][i + 1];
        }
        for (int i = R - 1; i > down.y; i--) {
            map[i][C - 1] = map[i - 1][C - 1];
        }
        for(int i = C - 1; i > 1; i--){
            map[down.y][i] = map[down.y][i - 1];
        }
        map[down.y][1] = 0;
    }
    static void spread(){
        int temp[][] = new int[R][C];
        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                if(map[y][x] == -1 || map[y][x] == 0) continue;
                int count = 0;
                int quantity = map[y][x] / 5;
                for (int k = 0; k < 4; k++) {
                    int ny = y + dy[k];
                    int nx = x + dx[k];
                    if(ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
                    if(map[ny][nx] == -1) continue;
                    count++;
                    temp[ny][nx] += quantity;
                }
                temp[y][x] += map[y][x] - ((map[y][x] / 5) * count);
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = temp[i][j];
            }
        }
    }
    static class Cleaner{
        int y;
        int x;

        public Cleaner(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}