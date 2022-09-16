package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5212_지구온난화 {
    static char[][] map, result;
    static int R, C;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int minY = Integer.MAX_VALUE;
    static int minX = Integer.MAX_VALUE;
    static int maxY = Integer.MIN_VALUE;
    static int maxX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] RC = br.readLine().split(" ");
        R = Integer.valueOf(RC[0]); C = Integer.valueOf(RC[1]);
        map = new char[R][C]; result = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
            result[i] = str.toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == '.') continue;
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];

                    if(ny < 0 || ny >= R || nx < 0 || nx >= C || map[ny][nx] == '.') count++;
                }
                if(count >= 3) result[i][j] = '.';
                else {
                    minY = Math.min(minY, i);
                    minX = Math.min(minX, j);
                    maxY = Math.max(maxY, i);
                    maxX = Math.max(maxX, j);
                }
            }
        }

        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }

}
