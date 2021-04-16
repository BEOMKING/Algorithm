package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15961_회전초밥 {
    static int N, d, k, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 초밥 수
        d = Integer.parseInt(st.nextToken()); // 종류
        k = Integer.parseInt(st.nextToken()); // 접시 수
        c = Integer.parseInt(st.nextToken()); // 쿠폰
        int sushi[] = new int[N];
        int kinds[] = new int[d + 1];
        int answer = 0, total = 0;

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k; i++) {
            if(kinds[sushi[i]]++ == 0) total++;
        }
        answer = total;

        for (int i = 1; i < N; i++) {
            if(--kinds[sushi[i - 1]] == 0) total--;
            if(kinds[sushi[(i + k - 1) % N]]++ == 0) total++; // 범위를 넘어갔을 때 맨 시작초밥을 먹는 방법

            if(answer <= total) {
                if (kinds[c] == 0) {
                    answer = total + 1;
                } else {
                    answer = total;
                }
            }
        }
        System.out.print(answer);
    }
}
//8 30 4 30
//9
//8
//29
//29
//2
//2
//9
//25
