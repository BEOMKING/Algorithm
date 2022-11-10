package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_13913_숨바꼭질4 {
    public static final int RANGE = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] lis = new int[RANGE];
        int[] dist = new int[RANGE];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        dist[N] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == K) {
                System.out.println(dist[now]);
                Stack<Integer> stack = new Stack<>();
                while (now != N) {
                    stack.add(now);
                    now = lis[now];
                }
                stack.add(N);
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop() + " ");
                }
                break;
            }

            if (now >= 1 && dist[now - 1] == -1) {
                q.add(now - 1);
                dist[now - 1] = dist[now] + 1;
                lis[now - 1] = now;
            }
            if (now + 1 < RANGE && dist[now + 1] == -1) {
                q.add(now + 1);
                dist[now + 1] = dist[now] + 1;
                lis[now + 1] = now;
            }
            if (now * 2 < RANGE && dist[2 * now] == -1) {
                q.add(now * 2);
                dist[now * 2] = dist[now] + 1;
                lis[now * 2] = now;
            }

        }
    }

}
