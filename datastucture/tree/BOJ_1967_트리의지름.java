package datastucture.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 모든 노드 사이의 거리를 DFS를 이용해 구했다.
 * V = 10000 이므로, 간선의 수는 최대 10000 * 9999 / 2 = 49995000 이다.
 * 따라서, 인접 리스트를 이용해 구현했고 시간 복잡도는 O(V + E) 이다.
 *
 * 시간을 더 줄이기 위한 방법으로는 지름이 최대가 되기 위한 조건은 리프 노드와 리프 노드 사이의 거리가 최대가 될 수 있는 조건이다.
 * 따라서, 리프 노드를 찾아서 그 노드들 사이의 거리를 구하면 시간을 더 줄일 수 있다.
 */
public class BOJ_1967_트리의지름 {
    private static List<Node>[] edges;
    private static boolean[] visited;
    private static int max = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        edges = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            edges[a].add(new Node(b, Integer.parseInt(input[2])));
            edges[b].add(new Node(a, Integer.parseInt(input[2])));
        }

        for (int i = 1; i <= n; i++) {
            if (edges[i].size() == 1) {
                visited = new boolean[n + 1];
                visited[i] = true;
                dfs(i, 0, i);
            }
        }

        System.out.println(max);
    }

    private static void dfs(final int index, final int sum, final int start) {
        if (edges[index].size() == 1 && index != start) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < edges[index].size(); i++) {
            Node next = edges[index].get(i);
            if (!visited[next.index]) {
                visited[next.index] = true;
                dfs(next.index, sum + next.value, start);
            }
        }
    }

    static class Node {
        private int index;
        private int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}