package datastucture.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949_균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder sb = new StringBuilder();

        while (!(input = br.readLine()).equals(".")) {
            String str = input.replaceAll("[^\\(\\)\\[\\]]", "");

            if (isBalanced(str)) {
                sb.append("yes");
            } else {
                sb.append("no");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isBalanced(final String inputs) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < inputs.length(); i++) {
            char now = inputs.charAt(i);

            if (now == ')') {
                if (stack.isEmpty() || stack.pop() != '(') return false;
            } else if (now == ']') {
                if (stack.isEmpty() || stack.pop() != '[') return false;
            } else {
                stack.add(now);
            }
        }

        if (!stack.isEmpty()) return false;

        return true;
    }
}
