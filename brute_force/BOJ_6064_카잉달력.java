package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6064_카잉달력 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int targetX = Integer.parseInt(st.nextToken()) - 1;
            int targetY = Integer.parseInt(st.nextToken()) - 1;

            int year = -1;
            for (int j = targetX; j < N * M; j+=M) {
                if ((j % N) == targetY) {
                    year = j + 1;
                    break;
                }
            }
            System.out.println(year);
        }
    }
}
