package 구현.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14569_시간표짜기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Long[] clas = new Long[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            Long bit = 0L;

            for (int j = 0; j < k; j++) {
                bit |= 1L << (Integer.parseInt(st.nextToken()));
            }
            clas[i] = bit;
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            Long stu = 0L;
            int available = 0;

            for (int j = 0; j < q; j++) {
                stu |= 1L << (Integer.parseInt(st.nextToken()));
            }

            for (Long c: clas) {
                if((stu & c) == c) available++;
            }

            sb.append(available + "\n");
        }
        System.out.println(sb.toString());
    }
}
