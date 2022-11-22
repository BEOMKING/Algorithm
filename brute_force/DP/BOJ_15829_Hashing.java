package brute_force.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열 길이가 최대 50이기 때문에 31^49은 너무 큰 값이 나온다.
 * 나머지 연산을 수행할 수 1234567891 가 있기 때문에 이를 이용해 모듈러 연산을 수행하면 해결할 수 있을 것이다.
 */
public class BOJ_15829_Hashing {

    private static final int MOD = 1234567891;
    private static long[] multiples;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String s = br.readLine();

        multiples = new long[50];
        multiples[0] = 1;
        for (int i = 1; i < 50; i++) {
            multiples[i] = multiples[i - 1] * 31 % MOD;
        }

        System.out.println(hash(s) % MOD);
    }

    private static long hash(final String s) {
        long value = 0;

        for (int i = 0; i < s.length(); i++) {
            value += (s.charAt(i) - 'a' + 1) * multiples[i] % MOD;
        }

        return value;
    }

}
