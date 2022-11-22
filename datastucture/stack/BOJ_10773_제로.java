package datastucture.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773_제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < count; i++) {
            int now = Integer.parseInt(br.readLine());

            if (now == 0) {
                stack.pop();
            } else {
                stack.add(now);
            }
        }

        System.out.println(stack.stream()
                .mapToInt(i -> i)
                .sum());
    }
}
