package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_5397_키로거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (int j = 0; j < input.length(); j++) {
                char operation = input.charAt(j);
                if (operation == '<') {
                    if (left.isEmpty()) continue;
                    right.push(left.pop());
                    continue;
                }
                if (operation == '>') {
                    if (right.isEmpty()) continue;
                    left.push(right.pop());
                    continue;
                }
                if (operation == '-') {
                    if (left.isEmpty()) continue;
                    left.pop();
                    continue;
                }
                left.push(operation);
            }

            while (!left.isEmpty()) {
                right.push(left.pop());
            }

            while (!right.isEmpty()) {
                sb.append(right.pop());
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
