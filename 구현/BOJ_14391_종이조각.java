package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14391_종이조각 {
    static int N, M, max = 0;
    static char[][] map;
    static boolean[][] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        checked = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < (1 << N*M); i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                int cur = 0;
                for (int k = 0; k < M; k++) {
                    if ((i & (1 << (j * M + k))) == 0) {
                        cur = cur * 10 + (map[j][k] - '0');
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }

            for (int j = 0; j < M; j++) {
                int cur = 0;
                for (int k = 0; k < N; k++) {
                    if ((i & (1 << (k * M + j))) != 0) {
                        cur = cur * 10 + (map[k][j] - '0');
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }

            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
