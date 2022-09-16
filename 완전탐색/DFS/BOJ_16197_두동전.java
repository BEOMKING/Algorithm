package 완전탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16197_두동전 {
    static int min = Integer.MAX_VALUE;
    static int dy[] = {0, 0, 1, -1};
    static int dx[] = {1, -1, 0, 0};
    static char[][] maps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        maps = new char[N][M];

        Coin coin1 = null;
        Coin coin2 = null;
        int count = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = input.charAt(j);
                if (c == 'o') {
                    if (count == 0) {
                        coin1 = new Coin(i, j);
                        count++;
                    } else {
                        coin2 = new Coin(i, j);
                    }
                }
                maps[i][j] = c;
            }
        }

        dfs(coin1, coin2, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static void dfs(Coin coin1, final Coin coin2, final int count) {
        if (count >= 10) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny1 = coin1.y + dy[i];
            int nx1 = coin1.x + dx[i];
            int ny2 = coin2.y + dy[i];
            int nx2 = coin2.x + dx[i];

            if (check(ny1, nx1, ny2, nx2, count + 1)) {
                continue;
            }

            if (maps[ny1][nx1] == '#') {
                ny1 = coin1.y;
                nx1 = coin1.x;
            }
            if (maps[ny2][nx2] == '#') {
                ny2 = coin2.y;
                nx2 = coin2.x;
            }
            Coin nCoin1 = new Coin(ny1, nx1);
            Coin nCoin2 = new Coin(ny2, nx2);
            dfs(nCoin1, nCoin2, count + 1);
        }
    }

    private static boolean check(int ny1, int nx1, int ny2, int nx2, int count) {
        int drop = 0;
        if (ny1 < 0 || ny1 >= maps.length || nx1 < 0 || nx1 >= maps[0].length) {
            drop++;
        }
        if (ny2 < 0 || ny2 >= maps.length || nx2 < 0 || nx2 >= maps[0].length) {
            drop++;
        }
        if (drop == 1) {
            min = Math.min(min, count);
            return true;
        } else if (drop == 2) {
            return true;
        }
        return false;
    }

    static class Coin {
        int y;
        int x;

        public Coin(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
