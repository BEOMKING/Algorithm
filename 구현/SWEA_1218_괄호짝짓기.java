package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
// 병신같은 문제
public class SWEA_1218_괄호짝짓기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t = 0; t < 10; t++) {
            int N = Integer.parseInt(br.readLine()); // 문자 수
            Stack<Character> bracket = new Stack<>(); // 괄호
            int answer = 0;
            String Str = br.readLine();

            for (int i = 0; i < N; i++) {
                char str = Str.charAt(i);
                if (str == ')') {
                    if (!bracket.isEmpty() && bracket.peek() == '(') {
                        bracket.pop();
                    } else {
                        answer = 0;
                        bracket.push(str);
                        break;
                    }
                } else if (str == (']')) {
                    if (!bracket.isEmpty() && bracket.peek() == '[') {
                        bracket.pop();
                    } else {
                        answer = 0;
                        bracket.push(str);
                        break;
                    }
                } else if (str == ('}')) {
                    if (!bracket.isEmpty() && bracket.peek() == '{') {
                        bracket.pop();
                    } else {
                        answer = 0;
                        bracket.push(str);
                        break;
                    }
                } else if (str == ('>')) {
                    if (!bracket.isEmpty() && bracket.peek() == '<') {
                        bracket.pop();
                    } else {
                        answer = 0;
                        bracket.push(str);
                        break;
                    }
                } else {
                    bracket.push(str);
                }
            }
            if (bracket.size() == 0) {
                answer = 1;
            }
            System.out.println("#" + (t + 1) + " " + answer);
        }
    }
}
