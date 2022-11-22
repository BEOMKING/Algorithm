package datastucture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class BOJ_2800_괄호제거_Stack {
    static Stack<Index> stack;
    static String input;
    static List<Parenthesis> parenthesis;
    static boolean[] checked;
    static TreeSet<String> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        stack = new Stack<>();
        parenthesis = new ArrayList<>();
        makeIndex();
        checked = new boolean[parenthesis.size()];
        result = new TreeSet<>();
        makeCombination(0);
        for (String str : result) {
            System.out.println(str);
        }

    }

    private static void makeResult() {
        int count = 0;
        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < checked.length; i++) {
            if(!checked[i]) {
                count++;
                continue;
            }
            chars[parenthesis.get(i).before] = '`';
            chars[parenthesis.get(i).after] = '`';
        }
        if(count == parenthesis.size()) return;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '`') continue;
            sb.append(chars[i]);
        }
        result.add(sb.toString());
    }

    public static void makeCombination(int count) {
        if(count == parenthesis.size()) {
            makeResult();
            return;
        }
        checked[count] = true;
        makeCombination(count + 1);
        checked[count] = false;
        makeCombination(count + 1);

    }

    public static void makeIndex() {
        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);
            if(now != '(' && now != ')') continue;
            if(now == '(') stack.add(new Index(i, now));
            if(now == ')') {
                Index before = stack.pop();
                parenthesis.add(new Parenthesis(before.index, i));
            }

        }
    }

    static class Parenthesis {
        int before, after;

        public Parenthesis(int before, int after) {
            this.before = before;
            this.after = after;
        }
    }

    static class Index {
        int index;
        char c;

        public Index(int index, char c) {
            this.index = index;
            this.c = c;
        }
    }

}
