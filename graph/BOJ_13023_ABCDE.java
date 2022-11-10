package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class BOJ_13023_ABCDE {

    static int N, M, available = 0;
    static boolean[] visited;
    static List<Integer>[] relations;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        relations = new List[N];
        for (int i = 0; i < N; i++) {
            relations[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relations[a].add(b);
            relations[b].add(a);
        }

        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (available == 1) break;
            visited[i] = true;
            brute(1, i);
            visited[i] = false;
        }
        System.out.println(available);

    }

    static void brute(int depth, int index) {
        if (depth == 5) {
            available = 1;
            return;
        }

        for (int i = 0; i < relations[index].size(); i++) {
            Integer next = relations[index].get(i);
            if (visited[next]) continue;
            visited[next] = true;
            brute(depth + 1, next);
            visited[next] = false;
        }
    }
}
