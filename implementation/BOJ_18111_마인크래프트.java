package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 범위(250000) * 최대 높이(256) = 64000000 이므로 모든 경우를 해봐도 시간 복잡도는 괜찮다.
 *
 * 가장 낮은 곳보다 낮은 경우, 가장 높은 곳보다 높은 경우는 그 사이의 값보다 적은 시간이 나올 수 없다.
 *
 * 특정한 층이 가능한지 경우를 살펴볼 때, 특정한 층보다 높이가 낮으면 블록을 채워야한다.
 * 이 때, 인벤토리의 블럭이 없어도 우선 빼기를 하고 더 높은 경우에 블럭을 채운다.
 * 그리고 마지막에 블럭이 음수이면 불가능한 경우인 것을 알 수 있다.
 */
public class BOJ_18111_마인크래프트 {
    static int minTime = Integer.MAX_VALUE;
    static int maxHeight = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int b = Integer.parseInt(inputs[2]);

        int[][] maps = new int[n][m];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                maps[i][j] = Integer.parseInt(inputs[j]);
                min = Math.min(min, maps[i][j]);
                max = Math.max(max, maps[i][j]);
            }
        }

        for (int target = min; target <= max; target++) {
            int time = 0;
            int block = b;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int diff = maps[i][j] - target;

                    if (diff > 0) {
                        time += Math.abs(diff * 2);
                        block += diff;
                    } else {
                        time += Math.abs(diff);
                        block -= Math.abs(diff);
                    }
                }
            }

            if (block < 0) continue;

            if (minTime == time) {
                maxHeight = Math.max(maxHeight, target);
            } else if (minTime > time) {
                minTime = time;
                maxHeight = target;
            }
        }

        System.out.println(minTime + " " + maxHeight);
    }
}
