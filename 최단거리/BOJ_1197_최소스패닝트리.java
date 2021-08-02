package 최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1197_최소스패닝트리 {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<Vertex>[] map = new ArrayList[V]; // 인접 리스트
        for (int i = 0; i < V; i++) {
            map[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[V];
        int[] distance = new int[V]; // 최소 거리를 갱신할 배열
        Arrays.fill(distance, INF);

        for (int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            map[a].add(new Vertex(b, c));
            map[b].add(new Vertex(a, c));
        }

        int result = 0, cnt = 0;
        distance[0] = 0;
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.add(new Vertex(0, 0));

        while(true){
            Vertex v = pq.poll();
            if(visited[v.location]) continue;
            visited[v.location] = true;
            result += v.dist;
            if(++cnt == V) break;

            for (Vertex ver : map[v.location]){
                if(!visited[ver.location] && distance[ver.location] > ver.dist){
                    distance[ver.location] = ver.dist;
                    pq.add(new Vertex(ver.location, ver.dist));
                }
            }
        }
        System.out.print(result);
    }
    public static class Vertex implements Comparable<Vertex>{
        int location, dist;
        public Vertex(int location, int dist){
            this.location = location;
            this.dist = dist;
        }
        @Override
        public int compareTo(Vertex v) {
            return this.dist - v.dist;
        }
    }
}
