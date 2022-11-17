package 자료구조.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 덱을 이용해 카운트를 채울때까지 삭제 후 삽입을 반복하고 카운트가 채워지면 삭제만 하면 해결할 수 있다.
 * 각 원소를 찾는 시간복잡도는 K이므로 시간복잡도는 O(NK)
 */
public class BOJ_11966_요세푸스문제0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        Deque<Integer> sequence = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            sequence.addLast(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (!sequence.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                sequence.addLast(sequence.pollFirst());
            }

            sb.append(sequence.pollFirst());

            if (sequence.size() != 0) {
                sb.append(", ");
            }
        }

        sb.append(">");

        System.out.println(sb);
    }
}
