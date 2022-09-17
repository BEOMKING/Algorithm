package 완전탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9663_NQueen {
    static int[][] maps;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        maps = new int[N][N];

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int y) {
        if (y == maps.length) {
            answer++;
            return;
        }

        for (int x = 0; x < maps.length; x++) {
            if (!isPossible(y, x)) continue;
            maps[y][x] = 1;
            dfs(y + 1);
            maps[y][x] = 0;
        }
    }

    private static boolean isPossible(int y, int x) {
        for (int i = y - 1; i >= 0; i--) {
            if (maps[i][x] == 1) return false;
            int index = y - i;
            if (x - index >= 0) {
                if (maps[i][x - index] == 1) return false;
            }
            if (x + index < maps.length) {
                if (maps[i][x + index] == 1) return false;
            }
        }

        for (int i = 0; i < x; i++) {
            if (maps[y][i] == 1) return false;
        }

        return true;
    }
}
