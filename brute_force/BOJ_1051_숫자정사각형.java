package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1051_숫자정사각형 {
    static int N;
    static int M;
    static char[][] square;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        square = new char[N][M];

        for (int i = 0; i < N; i++) {
            square[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < M; k++) {
                    if(i + k >= N || j + k >= M) break;
                    char leftTop = square[i][j];
                    char rightTop = square[i][j + k];
                    char leftBot = square[i + k][j];
                    char rightBot = square[i + k][j + k];
                    if(leftTop != rightBot) continue;
                    if(leftTop != rightTop) continue;
                    if(leftTop != leftBot) continue;
                    result = Math.max(result, (k + 1) * (k + 1));
                }
            }
        }
        System.out.println(result);
    }

}
