package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class BOJ_1260_DFSBFS {

    static int V, E;
    static boolean[] visited;
    static List<Integer>[] relations;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        relations = new List[V + 1];
        visited = new boolean[V + 1];
        sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            relations[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relations[a].add(b);
            relations[b].add(a);
        }

        for (int i = 1; i <= V; i++) {
            Collections.sort(relations[i]);
        }

        dfs(start);
        visited = new boolean[V + 1];
        sb.append("\n");
        bfs(start);
        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now + " ");
            for (int i = 0; i < relations[now].size(); i++) {
                int next = relations[now].get(i);
                if (visited[next]) continue;
                visited[next] = true;
                queue.add(next);
            }
        }
    }

    private static void dfs(int start) {
        sb.append(start + " ");
        visited[start] = true;

        for (int i = 0; i < relations[start].size(); i++) {
            int next = relations[start].get(i);
            if (visited[relations[start].get(i)]) continue;
            dfs(next);
        }
    }

}