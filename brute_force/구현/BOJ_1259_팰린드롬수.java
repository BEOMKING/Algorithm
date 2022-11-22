package brute_force.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팰린드롬을 확인하는 시간 복잡도는 O(N)이다.
 * 이미 확인한 숫자는 다시 확인작업을 수행하지 않도록 배열에 결과를 저장한다.
 */
public class BOJ_1259_팰린드롬수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] checked = new boolean[100000];
        String input;
        StringBuilder sb = new StringBuilder();

        while (!(input = br.readLine()).equals("0")) {
            int index = Integer.parseInt(input);
            if (checked[index]) {
                sb.append("yes").append("\n");
                continue;
            }

            boolean isAvailable = isPalindrome(input, input.length());
            if (isAvailable) {
                sb.append("yes").append("\n");
                checked[index] = true;
            } else {
                sb.append("no").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean isPalindrome(String input, int length) {
        for (int i = 0; i < length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
