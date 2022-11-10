package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {
    public static final int RANGE = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dist = new int[RANGE];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        dist[N] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == K) {
                System.out.println(dist[now]);
                break;
            }

            if (now >= 1 && dist[now - 1] == -1) {
                q.add(now - 1);
                dist[now - 1] = dist[now] + 1;
            }
            if (now + 1 < RANGE && dist[now + 1] == -1) {
                q.add(now + 1);
                dist[now + 1] = dist[now] + 1;
            }
            if (now * 2 < RANGE && dist[2 * now] == -1) {
                q.add(now * 2);
                dist[now * 2] = dist[now] + 1;
            }

        }
    }

}
