package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16432_떡장수와호랑이_DFS {
    static int[] result;
    static boolean[][] checked;
    static boolean finish = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        result = new int[N];
        int[][] riceCakes = new int[N][];
        checked = new boolean[N][10];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            riceCakes[i] = new int[Integer.parseInt(st.nextToken())];
            for (int j = 0; j < riceCakes[i].length; j++) {
                riceCakes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(riceCakes, 0, 0);
        if (!finish) {
            System.out.println(-1);
        }
    }

    private static void dfs(int[][] riceCakes, int count, int before) {
        if(finish) return;
        if(count == riceCakes.length) {
            for (int i = 0; i < riceCakes.length; i++) {
                System.out.println(result[i]);
            }
            finish = true;
            return;
        }

        for (int i = 0; i < riceCakes[count].length; i++) {
            int riceCake = riceCakes[count][i];
            if(before == riceCake || checked[count][riceCake]) continue;
            checked[count][riceCake] = true;
            result[count] = riceCake;
            dfs(riceCakes, count + 1, riceCake);
        }

    }

}
