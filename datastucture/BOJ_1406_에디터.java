package datastucture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1406_에디터 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] input;

        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            left.push(str.charAt(i));
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().toCharArray();
            char operation = input[0];
            if (operation == 'L') {
                if (left.isEmpty()) continue;
                right.push(left.pop());
            }
            if (operation == 'D') {
                if (right.isEmpty()) continue;
                left.push(right.pop());
            }
            if (operation == 'B') {
                if (left.isEmpty()) continue;
                left.pop();
            }
            if (operation == 'P') {
                left.push(input[2]);
            }
        }

        while (!left.isEmpty()) {
            right.push(left.pop());
        }

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb);
    }
}
