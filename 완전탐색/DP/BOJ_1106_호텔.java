package 완전탐색.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1106_호텔 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] customers = new int[C + 101];
        Arrays.fill(customers, Integer.MAX_VALUE);
        customers[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.valueOf(st.nextToken());
            int customer = Integer.valueOf(st.nextToken());

            for (int j = customer; j < customers.length; j++) {
                if(customers[j - customer] == Integer.MAX_VALUE) continue;
                customers[j] = Math.min(customers[j], customers[j - customer] + price);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = C; i < customers.length; i++) {
            result = Math.min(result, customers[i]);
        }
        System.out.println(result);
    }

}
