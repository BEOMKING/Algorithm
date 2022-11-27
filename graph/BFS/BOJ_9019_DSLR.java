package graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * A를 B로 바꾸는데 사용되는 연산을 구하는 문제이다.
 * 앞에서 이미 나온 숫자는 뒤에서 다시 연산을 수행할 필요가 없다.
 * 앞에서 이미 나온 숫자가 더 적은 연산을 수행했을 것이기 때문이다.
 * 그러므로 BFS를 수행하면서 이미 나온 숫자를 중복 체크한다.
 *
 * 문제가 됬던 부분은 1을 빼는 연산인데 -1을 했을 때 0이 되면 9999로 바꾸는 것이 아닌 0으로 들어오면 그냥 9999로 바꾸는 것이다.
 * 문제의 범위가 0 ~ 9999인데 이 부분을 놓쳐서 틀렸다.
 *
 * 또한 * 2 연산을 수행할 때 배열의 범위를 벗어나는 경우가 있기 때문에 좀 더 여유있는 배열 크기를 사용해야 한다.
 */
public class BOJ_9019_DSLR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            boolean[] visited = new boolean[20000];

            Queue<Register> q = new LinkedList<>();
            q.add(new Register(a, ""));
            visited[a] = true;

            while (!q.isEmpty()) {
                Register now = q.poll();
                int num = now.num;
                String command = now.command;

                if (num == b) {
                    sb.append(command).append("\n");
                    break;
                }

                int d = d(num);
                if (!visited[d]) {
                    visited[d] = true;
                    q.add(new Register(d, command + "D"));
                }

                int s = s(num);
                if (!visited[s]) {
                    visited[s] = true;
                    q.add(new Register(s, command + "S"));
                }

                int l = l(num);
                if (!visited[l]) {
                    visited[l] = true;
                    q.add(new Register(l, command + "L"));
                }


                int r = r(num);
                if (!visited[r]) {
                    visited[r] = true;
                    q.add(new Register(r, command + "R"));
                }
            }
        }

        System.out.print(sb);
    }

    static int d(int num) {
        return (num * 2) % 10000;
    }

    static int s(int num) {
        return (num == 0) ? 9999 : num - 1;
    }

    static int l(int num) {
        return num % 1000 * 10 + num / 1000;
    }

    static int r(int num) {
        return num % 10 * 1000 + num / 10;
    }

    static class Register {
        int num;
        String command;

        public Register(int num, String command) {
            this.num = num;
            this.command = command;
        }
    }
}
