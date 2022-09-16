package 완전탐색.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2852_NBA농구 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] team = new int[3];
        int[] accumulate = new int[3];
        int before = 0;
        int teamScored = 0;
        int miniute;

        for (int i = 0; i <= N; i++) {
            if (i < N) {
                st = new StringTokenizer(br.readLine());
                teamScored = Integer.parseInt(st.nextToken());
                String mmss = st.nextToken();
                miniute = Integer.parseInt(mmss.substring(0, 2)) * 60 + Integer
                    .parseInt(mmss.substring(3));
            } else {
                miniute = 2880;
            }

            if (team[1] > team[2]) {
                accumulate[1] += (miniute - before);
            } else if (team[1] < team[2]) {
                accumulate[2] += (miniute - before);
            }

            team[teamScored]++;
            before = miniute;
        }

        for (int i = 1; i <= 2; i++) {
            System.out.println(String.format("%02d:%02d", accumulate[i] / 60, accumulate[i] % 60));
        }
    }

}
