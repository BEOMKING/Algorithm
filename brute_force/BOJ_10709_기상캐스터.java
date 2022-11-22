package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10709_기상캐스터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] result = new int[H][W];

        for (int i = 0; i < H; i++) {
            String input = br.readLine();
            boolean beforeGroom = false;

            for (int j = 0; j < W; j++) {
                if (input.charAt(j) == 'c') {
                    result[i][j] = 0;
                    beforeGroom = true;
                } else {
                    if (beforeGroom) result[i][j] = result[i][j - 1] + 1;
                    else result[i][j] = -1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
