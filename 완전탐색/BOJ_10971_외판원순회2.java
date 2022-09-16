package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971_외판원순회2 {
    static int N, min = Integer.MAX_VALUE;
    static int[][] map;
    static int[] selected;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        selected = new int[N];
        checked = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        permutation(0);
        System.out.println(min);
    }

    public static void permutation(int count) {
        if (count == N) {
            int sum = 0;
            for (int i = 1; i < N; i++) {
                if (map[selected[i - 1]][selected[i]] == 0) return;
                sum += map[selected[i - 1]][selected[i]];
            }
            if (map[selected[N - 1]][selected[0]] == 0) return;
            sum += map[selected[N - 1]][selected[0]];
            min = Math.min(min, sum);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (checked[i]) continue;
            checked[i] = true;
            selected[count] = i;
            permutation(count + 1);
            checked[i] = false;
        }
    }
}
