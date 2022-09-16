package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476_날짜계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int targetE = Integer.parseInt(st.nextToken());
        int targetS = Integer.parseInt(st.nextToken());
        int targetM = Integer.parseInt(st.nextToken());

        int E = 0, S = 0, M = 0;
        int year = 0;

        while (true) {
            E = E % 15 + 1;
            S = S % 28 + 1;
            M = M % 19 + 1;
            year++;
            if (E == targetE && S == targetS && M == targetM) {
                System.out.println(year);
                return;
            }
        }
    }
}
