package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범검거 {
    static int N, M, R, C, L, answer, map[][], visited[][];
    static int dy[] = new int[]{-1, 0, 0, 1};
    static int dx[] = new int[]{0, -1, 1, 0};
    static String type[] = {null, "0312", "03", "12", "02", "32", "31", "01"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    visited[i][j] = Integer.MAX_VALUE;
                }
            }

            dfs(R, C, 1);
            sb.append("#" + t + " " + getCount() + "\n");
        }
        System.out.print(sb.toString());
    }
    static int getCount(){
        answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j] != Integer.MAX_VALUE) answer++;
            }
        }
        return answer;
    }
    static void dfs(int y, int x, int time){
        visited[y][x] = time;
        if(time == L) return;

        String info = type[map[y][x]];

        for (int i = 0, length = info.length(); i < length; i++) {
            int dir = info.charAt(i) - '0';
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] > 0
            && type[map[ny][nx]].contains(Integer.toString(3 - dir)) && visited[ny][nx] > time){
                dfs(ny, nx, time + 1);
            }
        }
    }
}
