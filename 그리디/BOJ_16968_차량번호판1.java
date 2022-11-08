package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 최대 경우의 수는 알파벳 개수의 4(자리수)제곱이다. 400000 이하이기 때문에 완전탐색이 가능하다.
 * 가능한 번호판의 개수이기 때문에 꼭 되는지 일일히 확인할 필요가 없다.
 * 숫자의 개수는 10개, 알파벳 개수는 26개이다.
 * 연속되는 경우, 이전까지의 경우의 수 * (숫자(알파벳) 개수 - 1)을 해주면 연속된 경우를 뺀 개수이다.
 * 그러므로 모든 경우의 수를 세지 않고 그리디한 방법을 사용해 풀 수 있다.
 */
public class BOJ_16968_차량번호판1 {
    static final int N_COUNT = 10;
    static final int A_COUNT = 'z' - 'a' + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        char before = input.charAt(0);
        int result = (before == 'd' ? N_COUNT : A_COUNT);

        for (int i = 1; i < input.length(); i++) {
            char now = input.charAt(i);

            if (now == 'c') {
                if (before == now) {
                    result *= (A_COUNT - 1);
                } else {
                    result *= A_COUNT;
                }
            }

            if (now == 'd') {
                if (before == now) {
                    result *= (N_COUNT - 1);
                } else {
                    result *= N_COUNT;
                }
            }

            before = now;
        }

        System.out.println(result);
    }
}
