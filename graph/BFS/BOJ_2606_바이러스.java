package graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 컴퓨터가 최대 100개이고 양방향 그래프이기 때문에 간선의 개수는 최대 10000개이다.
 * 인접 리스트를 사용했을 때, 시간 복잡도는 O(V + E)이다.
 */
public class BOJ_2606_바이러스 {
    private static int count;
    private static boolean[] checked;
    private static List<Integer>[] computers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        computers = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            computers[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            computers[a].add(b);
            computers[b].add(a);
        }

        count = 0;
        checked = new boolean[v + 1];
        checked[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int computer = queue.poll();

            for (int chain : computers[computer]) {
                if (checked[chain]) continue;
                checked[chain] = true;
                count++;
                queue.add(chain);
            }
        }

        System.out.println(count);
    }
}
