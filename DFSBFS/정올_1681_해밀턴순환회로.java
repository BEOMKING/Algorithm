package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정올_1681_해밀턴순환회로 {
    static int N;
    static int map[][];
    static int value[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];
        value = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        map[0][0] = Integer.MAX_VALUE;
        visited[0] = true;
        dfs(0, 0);
        System.out.print(map[0][0]);
    }
    static void dfs(int start, int dis){
        if(dis > map[0][0]) return;
        boolean flag = true; // 다 들렀다면
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]) flag = false;
        }
        if(flag){
            if(map[start][0] == 0) return; // 출발점으로 돌아가는 값도 0이어서는 안된다.
            dis += map[start][0];
            map[0][0] = Math.min(map[0][0], dis);
            return;
        }

        for (int i = 1; i < N; i++) {
            if(map[start][i] != 0 && !visited[i]) {
                visited[i] = true;
                dfs(i, dis + map[start][i]);
                visited[i] = false;
            }
        }
    }
}
