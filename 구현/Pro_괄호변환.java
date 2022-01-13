package 구현;

import java.util.Stack;

public class Pro_괄호변환 {
    int index;

    public String solution(String p) {
        return split(p);
    }

    private String split(String p) {
        if(p.isEmpty()) return p;
        boolean correct = checkCorrect(p);
        String u = p.substring(0, index);
        String v = p.substring(index);

        if(correct) {
            return u + split(v);
        }
        return "(" + split(v) + ")" + reverse(u);
    }

    private boolean checkCorrect(String u) {
        boolean result = true;
        int left = 0;
        int right = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < u.length(); i++) {
            char put = u.charAt(i);
            if(put == '(') {
                left++;
                stack.push(put);
            }
            if(put == ')') {
                right++;
                if(stack.isEmpty()) {
                    stack.push(put);
                    result = false;
                } else {
                    if(stack.peek() == '(') stack.pop();
                }
            }
            if(left == right) {
                index = i + 1;
                return result;
            }
        }

        return result;
    }

    public String reverse(String u) {
        String result = "";
        for (int i = 1; i < u.length() - 1; i++) {
            char put = u.charAt(i);
            if(put == '(') result += ')';
            if(put == ')') result += '(';
        }
        return result;
    }
}
