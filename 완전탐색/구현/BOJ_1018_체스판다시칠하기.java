package 완전탐색.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 체스판을 만드는 경우의 수가 2개라고 명시되어 있다.
 * 그렇기 때문에 주어진 보드와 두 경우의 수를 비교한 후에 적은 값을 출력하면 된다.
 * 보드판의 어느 부분을 사용할지 결정되지 않았으므로 모든 경우를 탐색해봐야한다.
 * 그러므로 시간 복잡도는 NM 만큼 비교해야하고 비교하는데 사용되는 시간이 NM 이므로
 * NM이 같다고 쳤을 때, O(N^4)의 시간이 사용된다.
 *
 * 범위를 비교할 때, 배열의 크기가 다르다는 것을 주의하면 된다.
 */
public class BOJ_1018_체스판다시칠하기 {
    private static char[][] maps, case1, case2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        maps = new char[n][m];
        for (int i = 0; i < n; i++) {
            maps[i] = br.readLine().toCharArray();
        }

        case1 = new char[8][8];
        case2 = new char[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        case1[i][j] = 'W';
                        case2[i][j] = 'B';
                    } else {
                        case1[i][j] = 'B';
                        case2[i][j] = 'W';
                    }
                } else {
                    if (j % 2 == 0) {
                        case1[i][j] = 'B';
                        case2[i][j] = 'W';
                    } else {
                        case1[i][j] = 'W';
                        case2[i][j] = 'B';
                    }
                }
            }
        }

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                minDiff = Math.min(minDiff, brute(i, j));
            }
        }

        System.out.println(minDiff);
    }

    private static int brute(int startY, int startX) {
        int diff1 = 0;
        int diff2 = 0;

        for (int i = startY; i < startY + 8; i++) {
            for (int j = startX; j < startX + 8; j++) {
                if (maps[i][j] == case1[i - startY][j - startX]) {
                    diff2++;
                } else {
                    diff1++;
                }
            }
        }

        return Math.min(diff1, diff2);
    }
}
