package shortest.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 이 문제는 각 유저와 다른 유저들간의 거리 합을 구하는 문제이다.
 * 양방향 간선에 해당된다.
 */
public class BOJ_1389_케빈베이컨의6단계법칙 {

    private static int n;
    private static int m;
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(map[i], 100000);
        }

        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            map[a][b] = 1;
            map[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        int minIndex = 0;
        int min = Integer.MAX_VALUE;

        for (int i = n; i >= 1; i--) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                sum += map[i][j];
            }

            if (min >= sum) {
                minIndex = i;
                min = sum;
            }
        }

        System.out.println(minIndex);
    }
}
