package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class BOJ_1707_이분그래프 {

    static int V, E;
    static int[] visited; // 0 방문 x / 1 방문 + 그래프1 / 2 방문 + 그래프2
    static List<Integer>[] relations;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            relations = new List[V + 1];
            visited = new int[V + 1];
            flag = true;
            for (int i = 1; i <= V; i++) {
                relations[i] = new ArrayList<>();
            }
            for (int i = 1; i <= E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                relations[u].add(v);
                relations[v].add(u);
            }

            for (int i = 1; i <= V; i++) {
                if (visited[i] != 0) continue;
                if (!dfs(i, 1)) flag = false;
            }

            System.out.println(flag ? "YES" : "NO");
        }

    }

    private static boolean dfs(int start, int expect) {
        visited[start] = expect;

        for (int i = 0; i < relations[start].size(); i++) {
            int next = relations[start].get(i);
            if (visited[next] != 0) {
                if (visited[next] == expect) {
                    return false;
                }
            } else {
                if (!dfs(next, 3 - expect)) return false;
            }
        }

        return true;
    }

}