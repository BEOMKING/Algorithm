package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14391_종이조각 {
    static int N, M, max = 0;
    static int map[][];
    static boolean isselected[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isselected = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        dfs(0, 0);
        System.out.println(max);
    }

    private static void dfs(int row, int col) {
        if(row == N){
            sum();
            return;
        }

        if(col == M){
            dfs(row + 1, 0);
            return;
        }

        isselected[row][col] = true;
        dfs(row, col + 1);
        isselected[row][col] = false;
        dfs(row, col + 1);
    }

    private static void sum() {
        int result = 0;
        int temp = 0;

        for (int i = 0; i < N; i++) {
            temp = 0;
            for (int j = 0; j < M; j++) {
                if(isselected[i][j]){
                    temp *= 10;
                    temp += map[i][j];
                }else{
                    result += temp;
                    temp = 0;
                }
            }
            result += temp;
        }


        for (int i = 0; i < M; i++) {
            temp = 0;
            for (int j = 0; j < N; j++) {
                if(!isselected[j][i]){
                    temp *= 10;
                    temp += map[j][i];
                }else{
                    result += temp;
                    temp = 0;
                }
            }
            result += temp;
        }

        max = Math.max(max, result);
    }
}
