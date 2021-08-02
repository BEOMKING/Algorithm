package 최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1916_최소비용구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<Vertex>[] bus = new ArrayList[N + 1];
        int[] distance = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 1; i <= N; i++) bus[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            bus[start].add(new Vertex(end, dist));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        distance[start] = 0;
        PriorityQueue<Vertex> pq = new PriorityQueue();
        pq.add(new Vertex(start, 0));

        while (true){
            Vertex now = pq.poll();
            if(visited[now.v]) continue;
            visited[now.v] = true;

            if(now.v == end) break;

            for (Vertex v : bus[now.v]) {
                int cost = now.dist + v.dist;
                if(!visited[v.v] && distance[v.v] > cost){
                    distance[v.v] = cost;
                    pq.add(new Vertex(v.v, cost));
                }
            }
        }

        System.out.println(distance[end]);
    }
    public static class Vertex implements Comparable<Vertex>{
        int v, dist;

        public Vertex(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.dist, o.dist);
        }
    }
}
