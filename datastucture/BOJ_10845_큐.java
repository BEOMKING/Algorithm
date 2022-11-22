package datastucture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_10845_큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        BJPQueue queue = new BJPQueue();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            if (operation.equals("push")) {
                queue.push(Integer.parseInt(st.nextToken()));
                continue;
            }
            if (operation.equals("pop")) {
                sb.append(queue.pop());
            }
            if (operation.equals("size")) {
                sb.append(queue.size());
            }
            if (operation.equals("empty")) {
                if (queue.empty()) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            }
            if (operation.equals("front")) {
                sb.append(queue.front());
            }
            if (operation.equals("back")) {
                sb.append(queue.back());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static class BJPQueue {
        int[] queue = new int[10000];
        int begin = 0;
        int end = 0;

        void push(int n) {
            queue[end++] = n;
        }

        int pop() {
            if (empty()) return -1;
            return queue[begin++];
        }

        boolean empty() {
            return begin == end;
        }

        int size() {
            return end - begin;
        }

        int front() {
            if (empty()) return -1;
            return queue[begin];
        }

        int back() {
            if (empty()) return -1;
            return queue[end - 1];
        }
    }

}