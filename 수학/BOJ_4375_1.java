package 수학;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_4375_1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int remain = 0;

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                remain = (remain * 10 + 1) % n;
                if (remain == 0) {
                    System.out.println(i + 1);
                    break;
                }
            }

        }
    }
}
