package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {
    static int[][][] numberOfCase = {
        {{0, 1}, {0, 2}, {0, 3}},
        {{1, 0}, {2, 0}, {3, 0}},
        {{0, 1}, {1, 0}, {1, 1}},
        {{1, 0}, {2, 0}, {2, 1}},
        {{1, 0}, {2, 0}, {2, -1}},
        {{0, 1}, {0, 2}, {-1, 2}},
        {{0, 1}, {0, 2}, {1, 2}},
        {{0, -1}, {0, -2}, {1, -2}},
        {{0, -1}, {0, -2}, {-1, -2}},
        {{-1, 0}, {-2, 0}, {-2, 1}},
        {{-1, 0}, {-2, 0}, {-2, -1}},
        {{1, 0}, {1, 1}, {2, 1}},
        {{1, 0}, {1, -1}, {2, -1}},
        {{0, 1}, {-1, 1}, {-1, 2}},
        {{0, 1}, {1, 1}, {1, 2}},
        {{0, 1}, {1, 1}, {0, 2}},
        {{0, 1}, {-1, 1}, {0, 2}},
        {{1, 0}, {1, 1}, {2, 0}},
        {{1, 0}, {1, -1}, {2, 0}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max = 0;
        int [][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                for (int i = 0; i < numberOfCase.length; i++) {
                    int sum = map[y][x];
                    boolean flag = true;
                    for (int j = 0; j < 3; j++) {
                        int ny = y + numberOfCase[i][j][0];
                        int nx = x + numberOfCase[i][j][1];
                        if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
                            flag = false;
                            break;
                        }
                        sum += map[y + numberOfCase[i][j][0]][x + numberOfCase[i][j][1]];
                    }
                    if (flag) max = Math.max(max, sum);
                }
            }
        }
        System.out.println(max);
    }

}
