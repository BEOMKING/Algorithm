package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1769_3의배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = br.readLine();
        trans(X, 0);
    }

    public static void trans(String X, int count) {
        if (X.length() < 2) {
            int result = Integer.parseInt(X);
            System.out.println(count);
            if (result % 3 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            return;
        }
        int sum = 0;
        for (int i = 0; i < X.length(); i++) {
            sum += Integer.parseInt(X.substring(i, i + 1));
        }
        trans("" + sum, count + 1);

    }

}
