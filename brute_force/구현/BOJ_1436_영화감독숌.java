package brute_force.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436_영화감독숌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int index = 0;
        int now = 665;

        while (index != N) {
            if (isValid(++now)) {
                index++;
            }
        }

        System.out.println(now);
    }

    static boolean isValid(int n) {
        String convert = n + "";
        int sequence = 0;
        for (int i = 0; i < convert.length(); i++) {
            if (convert.charAt(i) == '6') {
                sequence++;
                if (sequence == 3) {
                    return true;
                }
            } else {
                sequence = 0;
            }
        }

        return false;
    }
}
