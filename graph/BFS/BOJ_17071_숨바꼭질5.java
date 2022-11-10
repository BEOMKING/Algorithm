package graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 시간 제한이 0.25초로 매우 짧다. 약 25000000의 연산
// 동생이 최대 범위를 넘어서는 시간은 약 1000초이다.
// 한 번 방문한 장소에 오는 경우에도 동생을 만날 경우가 있다.
// 3   4  6 9 13 // 동생
// 10 11 10 9 10 // 수빈
public class BOJ_17071_숨바꼭질5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        if (N == K) {
            System.out.println(0);
            return;
        }

        boolean[][] maps = new boolean[2][500001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        maps[0][N] = true;
        int mod, time = 0;

        while (!queue.isEmpty()) {
            Integer size = queue.size();
            time++;
            mod = time % 2;
            K += time;

            if (K > 500000) {
                System.out.println(-1);
                break;
            }

            for (int i = 0; i < size; i++) {
                int now = queue.poll();

                if (now - 1 > 0 && !maps[mod][now - 1]) {
                    queue.add(now - 1);
                    maps[mod][now - 1] = true;
                }

                if (now + 1 <= 500000 && !maps[mod][now + 1]) {
                    queue.add(now + 1);
                    maps[mod][now + 1] = true;
                }

                if (now * 2 <= 500000 && !maps[mod][now * 2]) {
                    queue.add(now * 2);
                    maps[mod][now * 2] = true;
                }
            }

            if (maps[mod][K]) {
                System.out.println(time);
                break;
            }
        }
    }
}
