package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 백준_2667_단지번호붙이기 {
    static char map[][];
    static int N;
    static boolean isselected[][];
    static int count;
    static int dangi = 0;
    static ArrayList<Integer> list = new ArrayList<>();
    static int dy[] = new int[]{-1, 0, 1, 0}; // 북 동 남 서
    static int dx[] = new int[]{0, 1, 0, -1}; // 북 동 남 서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        isselected = new boolean[N][N];

        for (int n = 0; n < N; n++) {
            map[n] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == '1' && !isselected[i][j]){
                    dangi += 1;
                    count = 0;
                    state(i, j);
                    list.add(count);
                }
            }
        }
        System.out.println(dangi);
        Collections.sort(list);
        for (int li : list) {
            System.out.println(li);
        }
    }

    static void state(int y, int x){
        isselected[y][x] = true;
        count += 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
            if(!isselected[ny][nx] && map[ny][nx] != '0'){
                state(ny, nx);
            }
        }
    }
}
