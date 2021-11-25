package 구현;

import java.util.ArrayList;

public class Pro_수식최대화 {
    static char[] permutation = new char[3];
    static boolean[] checked = new boolean[3];
    static long answer = 0;
    static char[] operation = {'+', '-', '*'};
    static ArrayList<Long> numbers = new ArrayList<>();
    static ArrayList<Character> operations = new ArrayList<>();

    public long solution(String expression) {
        int start = 0, end;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+' || expression.charAt(i) == '*') {
                end = i;
                numbers.add(Long.parseLong(expression.substring(start, end)));
                operations.add(expression.charAt(i));
                start = i + 1;
            }
        }
        numbers.add(Long.parseLong(expression.substring(start)));
        permutation(0);
        return answer;
    }

    void permutation(int count) {
        if (count == 3) {
            logic();
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (checked[i]) {
                continue;
            }
            permutation[count] = operation[i];
            checked[i] = true;
            permutation(count + 1);
            checked[i] = false;
        }
    }

    void logic() {
        ArrayList<Long> tnumbers = new ArrayList<>(numbers);
        ArrayList<Character> toperations = new ArrayList<>(operations);

        for (char c : permutation) {
            for (int i = 0; i < toperations.size(); i++) {
                if(c == toperations.get(i)) {
                    long temp = calc(tnumbers.remove(i), tnumbers.remove(i), c);
                    tnumbers.add(i, temp);
                    toperations.remove(i);
                    i--;
                }
            }
        }

        answer = Math.max(Math.abs(tnumbers.get(0)), answer);
    }

    long calc(long a, long b, char oper) {
        if(oper == '*') {
            return a * b;
        } else if(oper == '+') {
            return a + b;
        } else if(oper == '-') {
            return a - b;
        }
        return 0;
    }

}
