package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_10866_덱 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        BJPDeque deque = new BJPDeque();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            if (operation.equals("push_front")) {
                deque.push_front(Integer.parseInt(st.nextToken()));
                continue;
            }
            if (operation.equals("push_back")) {
                deque.push_back(Integer.parseInt(st.nextToken()));
                continue;
            }
            if (operation.equals("pop_front")) {
                sb.append(deque.pop_front());
            }
            if (operation.equals("pop_back")) {
                sb.append(deque.pop_back());
            }
            if (operation.equals("size")) {
                sb.append(deque.size());
            }
            if (operation.equals("empty")) {
                sb.append(deque.empty());
            }
            if (operation.equals("front")) {
                sb.append(deque.front());
            }
            if (operation.equals("back")) {
                sb.append(deque.back());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static class BJPDeque {
        int[] deque = new int[10000];
        int begin = 0;
        int end = 0;

        void push_front(int x) {
            if (begin != 0) {
                deque[--begin] = x;
            } else {
                for (int i = end - 1; i >= 0; i--) {
                    deque[i + 1] = deque[i];
                }
                end++;
                deque[begin] = x;
            }
        }

        void push_back(int x) {
            deque[end++] = x;
        }

        int pop_front() {
            if (size() == 0) return -1;
            return deque[begin++];
        }

        int pop_back() {
            if (size() == 0) return -1;
            return deque[end-- - 1];
        }

        int size() {
            return end - begin;
        }

        int empty() {
            if (size() == 0) return 1;
            return 0;
        }

        int front() {
            if (size() == 0) return -1;
            return deque[begin];
        }

        int back() {
            if (size() == 0) return -1;
            return deque[end - 1];
        }

    }

}