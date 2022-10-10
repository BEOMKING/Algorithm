package 완전탐색.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16968_차량번호판1 {
    private static int targetLength;
    private static String form;
    private static int licensePlateCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        form = br.readLine();
        targetLength = form.length();

        bruteForce(0, "");

        System.out.println(licensePlateCount);
    }

    private static void bruteForce(int count, String licensePlate) {
        if (count == targetLength) {
            licensePlateCount++;
            return;
        }

        char now = form.charAt(count);
        if (now == 'c') {
            for (char c = 'a'; c <= 'z'; c++) {
                if (count == 0 || licensePlate.charAt(count - 1) != c) {
                    bruteForce(count + 1, licensePlate + c);
                }
            }
        } else {
            for (char d = '0'; d <= '9'; d++) {
                if (count == 0 || licensePlate.charAt(count - 1) != d) {
                    bruteForce(count + 1, licensePlate + d);
                }
            }
        }
    }
}
