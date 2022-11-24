package brute_force.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5525_IOIOI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int count = 0;
        int result = 0;

        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == 'I' && s.charAt(i - 1) == 'O' && s.charAt(i - 2) == 'I') {
                count++;

                if (count == n) {
                    count--;
                    result++;
                }

                i++;
            } else {
                count = 0;
            }
        }

        System.out.println(result);
    }
}