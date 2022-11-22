package brute_force.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1037_약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] divisor = new int[count];

        for (int i = 0; i < count; i++) {
            divisor[i] = Integer.parseInt(st.nextToken());
        }

        if (count == 1) {
            System.out.println(divisor[0] * divisor[0]);
        } else {
            Arrays.sort(divisor);
            System.out.println(divisor[0] * divisor[count - 1]);
        }
    }
}
