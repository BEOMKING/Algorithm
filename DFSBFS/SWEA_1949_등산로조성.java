package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_1949_등산로조성 {
    static int map[][];
    static int N;
    static int K;
    static boolean available[][];
    static int result = 0;
    static boolean cut = true;
    static int dx[] = new int[]{-1, 0, 1, 0}; // 북 동 남 서
    static int dy[] = new int[]{0, 1, 0, -1}; // 북 동 남 서


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 지도 한 변의 길이
            K = Integer.parseInt(st.nextToken()); // 최대 공사 가능 깊이

            map = new int[N][N];
            available = new boolean[N][N]; // 방문 체크 (지나온 곳은 현재 있는 곳보다 높기 때문에 방문할 일이 없을 줄 알았는데 지나온 곳을 다시 깎는 경우가 존재해 필요했다.)
            int max = 0; // 지도에서 가장 높은 봉우리

            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < N; m++) {
                    map[n][m] = Integer.parseInt(st.nextToken());
                    max = Math.max(map[n][m], max);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == max){ // 가장 높은 봉우리라면
                        available[i][j] = true;
                        dfs(i, j, 1, cut);
                        available[i][j] = false;
                    }
                }
            }
            sb.append("#" + t + ' ' + result + "\n");
        }
        System.out.print(sb.toString());
    }
    static void dfs(int x, int y, int maxdepth, boolean cut){
        result = Math.max(result, maxdepth);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= N || available[nx][ny]) continue;

            if(map[x][y] > map[nx][ny]){
                available[nx][ny] = true;
                dfs(nx, ny, maxdepth + 1, cut);
                available[nx][ny] = false;
            }else{
                if(cut && map[x][y] > map[nx][ny] - K) {
                    int before = 0;
                    for (int j = 1; j <= K; j++) {
                        if (map[x][y] > map[nx][ny] - j) {
                            before = map[nx][ny];
                            map[nx][ny] -= j;
                            break;
                        }
                    }
                    available[nx][ny] = true;
                    cut = false;
                    dfs(nx, ny, maxdepth + 1, cut);
                    cut = true;
                    available[nx][ny] = false;
                    map[nx][ny] = before;
                }
            }
        }
    }
}

