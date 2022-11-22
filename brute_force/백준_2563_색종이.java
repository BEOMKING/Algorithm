package brute_force;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2563_색종이 {
    static int N;
    static int paper[][];
    static int sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sum = 0;
        paper = new int[101][101];

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int a = y; a < y + 10; a++) { // y 좌표에서 y + 9 좌표까지
                for (int b = x; b < x + 10; b++) { // x 좌표에서 x + 9 좌표까지
                    paper[a][b] = 1; // 검은색 칠하기기                }
                }
            }
            for (int i = 1; i <= 100; i++) {
                for (int j = 1; j <= 100; j++) {
                    if (paper[i][j] == 1) {
                        sum += 1;
                    }
                }
            }

            System.out.print(sum);
        }
    }
}
