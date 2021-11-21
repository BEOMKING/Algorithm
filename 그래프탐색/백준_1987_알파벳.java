package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1987_알파벳 {
    static char map[][];
    static int R;
    static int C;
    static int result;
    static int dx[] = new int[]{-1, 1, 0, 0}; // 북 남 동 서
    static int dy[] = new int[]{0, 0, 1, -1}; // 북 남 동 서
    static boolean isselected[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        isselected = new boolean[26];
        map = new char[R][C];
        result = 0;
        for(int r = 0; r < R; r++){
            map[r] = br.readLine().toCharArray();
        }
        dfs(0, 0, 1);
        System.out.println(result);
    }

    private static void dfs(int x, int y, int max) {
        if(isselected[map[x][y] - 65]) return;
        result = Math.max(max, result);

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < R && ny >= 0 && ny < C){
                isselected[map[x][y] - 65] = true;
                dfs(nx, ny, max + 1);
                isselected[map[x][y] - 65] = false;
            }
        }
        return;
    }
}
