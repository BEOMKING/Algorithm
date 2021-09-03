package 구현.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012_괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            boolean flag = true;
            String parenthesis = br.readLine();
            int length = parenthesis.length();
            stack = new Stack<>();

            for (int j = 0; j < length; j++) {
                char now = parenthesis.charAt(j);
                if(now == '(') stack.push(now);
                else if(stack.isEmpty()) {
                    flag = false;
                    break;
                }else stack.pop();
            }

            if(!flag || !stack.isEmpty()) sb.append("NO");
            else sb.append("YES");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

}
