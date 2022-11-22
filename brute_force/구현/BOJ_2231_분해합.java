package brute_force.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 생성자로 분해합을 만드는 경우를 모두 만들면서 확인하되 생성자가 1인 경우부터 확인한다면 가장 먼저 찾는 값이 최소값이 될 것이다.
 * 분해합을 만드는 시간 복잡도가 상수(생성자의 자리수)이므로 O(N) 시간복잡도로 해결 가능하다.
 *
 * 분해합을 만드는 최소 범위를 만들어서 최적화할 수 있다.
 */
public class BOJ_2231_분해합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int length = s.length();
        int n = Integer.parseInt(s);
        int min = 0;

        for (int i = n - length * 9; i < n; i++) {
            if (i + decomposition(i) == n) {
                min = i;
                break;
            }
        }

        System.out.println(min);
    }

    private static int decomposition(int sum) {
        if (sum == 0) return 0;
        return sum % 10 + decomposition(sum / 10);
    }
}
