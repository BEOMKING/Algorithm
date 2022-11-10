package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질3 {
    public static final int RANGE = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        int[] dist = new int[RANGE];
        deque.add(N);
        dist[N] = 1;

        while (!deque.isEmpty()) {
            int now = deque.pollFirst();
            if (now == K) {
                System.out.println(dist[now] - 1);
                break;
            }

            for (int next : new int[]{now * 2, now - 1, now + 1}) {
                if (next < 0 || next >= RANGE) continue;
                if (dist[next] != 0) continue;
                if (next == now * 2) {
                    deque.addFirst(next);
                    dist[next] = dist[now];
                } else {
                    deque.addLast(next);
                    dist[next] = dist[now] + 1;
                }

            }
        }
    }

}
