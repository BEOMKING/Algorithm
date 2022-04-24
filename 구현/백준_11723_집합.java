package 구현;

import java.io.*;
import java.util.StringTokenizer;

public class 백준_11723_집합 { // 비트마스킹
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int S = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            if (operation.equals("all")) {
                S |= ((int) Math.pow(2, 20) - 1);
                continue;
            }
            if (operation.equals("empty")) {
                S &= ~((int) Math.pow(2, 20) - 1);
                continue;
            }
            int x = Integer.parseInt(st.nextToken()) - 1;
            if (operation.equals("add")) {
                S |= (1 << x);
            }
            if (operation.equals("remove")) {
                S &= ~(1 << x);
            }
            if (operation.equals("check")) {
                if ((S & (1 << x)) > 0) {
                    sb.append(1 + "\n");
                } else {
                    sb.append(0 + "\n");
                }
            }
            if (operation.equals("toggle")) {
                S ^= (1 << x);
            }
        }
        System.out.println(sb);
    }
}
