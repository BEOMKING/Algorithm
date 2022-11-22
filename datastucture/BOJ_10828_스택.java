package datastucture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10828_스택 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            if (operation.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            }
            if (operation.equals("pop")) {
                sb.append(stack.pop() + "\n");
            }
            if (operation.equals("empty")) {
                sb.append(stack.empty() + "\n");
            }
            if (operation.equals("size")) {
                sb.append(stack.size() + "\n");
            }
            if (operation.equals("top")) {
                sb.append(stack.top() + "\n");
            }

        }

        System.out.println(sb);

    }

    public static class Stack {
        final private int max = 10001;
        private int[] stack = new int[max];
        private int pos = 0;

        public void push(int x) {
            stack[pos++] = x;
        }

        public int pop() {
            if (pos == 0) return -1;
            return stack[--pos];
        }

        public int size() {
            return pos;
        }

        public int empty() {
            if (pos == 0) return 1;
            return 0;
        }

        public int top() {
            if (pos == 0) return -1;
            return stack[pos - 1];
        }
    }
}
