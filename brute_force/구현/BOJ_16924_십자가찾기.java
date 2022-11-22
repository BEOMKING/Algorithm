package brute_force.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 격자판의 크기가 크지 않고 별다른 알고리즘으로 해결할 수 없어보여 완탐으로 접근한다.
 * 모든 경우의 수를 탐색하며 십자가의 크기를 확장하는 방법을 사용한다.
 * 이 때, 십자가의 크기가 격자 상태를 벗어날 경우 백트래킹한다.
 */
public class BOJ_16924_십자가찾기 {
    static char[][] maps, result;
    static int N, M;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ranges = br.readLine().split(" ");
        N = Integer.parseInt(ranges[0]);
        M = Integer.parseInt(ranges[1]);

        maps = new char[N + 1][M + 1];
        result = new char[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String inputs = br.readLine();
            for (int j = 1; j <= M; j++) {
                maps[i][j] = inputs.charAt(j - 1);
            }
        }

        System.out.println(logic());
    }

    static String logic() {
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= M; x++) {
                int range = calculateRange(y, x, 0);
                if (range <= 0) continue;
                sb.append(y).append(" ").append(x).append(" ").append(range).append("\n");
                marking(y, x, range);
                count++;
                if (isFinished()) {
                    return count + "\n" + sb;
                }
            }
        }

        return "-1";
    }

    private static void marking(int y, int x, int range) {
        for (int i = 0; i <= range; i++) {
            for (int j = 0; j < 4; j++) {
                int ny = y + dy[j] * i;
                int nx = x + dx[j] * i;
                result[ny][nx] = '*';
            }
        }
    }

    static boolean isFinished() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (maps[i][j] == '*' && result[i][j] != '*') {
                    return false;
                }
            }
        }

        return true;
    }

    static int calculateRange(int y, int x, int distance) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i] * distance;
            int nx = x + dx[i] * distance;
            
            if (ny <= 0 || ny > N || nx <= 0 || nx > M || maps[ny][nx] != '*') {
                return distance - 1;
            }
        }
        
        return calculateRange(y, x, distance + 1);
    }
}
