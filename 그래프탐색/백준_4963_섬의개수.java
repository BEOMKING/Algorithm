package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_4963_섬의개수 {
    static boolean isselected[][];
    static int map[][];
    static int island;
    static int dx[] = new int[]{1, 0, 1, -1, 1, 0, -1, -1}; // 동 남 남동 남서 북동 북 북서 서
    static int dy[] = new int[]{0, 1, 1, 1, -1, -1, -1, 0};
    static int Y;
    static int X;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());

            if(X == 0 && Y == 0) break;
            isselected = new boolean[Y][X];
            map = new int[Y][X];
            island = 0;
            result = 0;

            for(int i = 0; i < Y; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < X; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int y = 0; y < Y; y++){
                for(int x = 0; x < X; x++){
                    if(!isselected[y][x] && map[y][x] == 1){
                        dfs(y, x);
                        result += 1;
                    }
                }
            }
            System.out.println(result);
        }
    }

    private static void dfs(int y, int x) {
        isselected[y][x] = true;

        for(int i = 0; i < 8; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < Y && nx < X && nx >= 0 && ny >= 0 && map[ny][nx] == 1 && !isselected[ny][nx]){
                dfs(ny, nx);
            }
        }
    }
}
