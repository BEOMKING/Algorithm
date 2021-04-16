package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2531_회전초밥 {
    static int N, d, k, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 초밥 수
        d = Integer.parseInt(st.nextToken()); // 종류
        k = Integer.parseInt(st.nextToken()); // 접시 수
        c = Integer.parseInt(st.nextToken()); // 쿠폰
        List<Integer> sushi = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < N; i++) {
            sushi.add(Integer.parseInt(br.readLine()));
        }
        for (int i = 0; i < k - 1; i++) {
            sushi.add(sushi.get(i));
        }
        for (int i = 0; i < N; i++) {
            HashSet<Integer> set = new HashSet<>();
            boolean bonus = false;
            for (int j = i; j < i + k; j++) {
                if(sushi.get(j) == c) bonus = true;
                set.add(sushi.get(j));
            }
            int kinds;
            kinds = bonus ? set.size() : set.size() + 1;
            answer = Math.max(answer, kinds);
        }
        System.out.print(answer);
    }
}
