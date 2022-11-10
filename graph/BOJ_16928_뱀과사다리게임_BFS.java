package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16928_뱀과사다리게임_BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] laddersAndSnakes = new int[101];
        boolean[] check = new boolean[101];

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            laddersAndSnakes[start] = destination;
        }

        PriorityQueue<Location> pq = new PriorityQueue<>();
        pq.add(new Location(1, 0));

        while (!pq.isEmpty()) {
            Location now = pq.poll();
            if (now.location == 100) {
                System.out.println(now.count);
                break;
            }

            for (int i = 1; i <= 6; i++) {
                int nLocation = now.location + i;
                if (nLocation > 100) continue;
                if (check[nLocation]) continue;
                check[nLocation] = true;
                if (laddersAndSnakes[nLocation] != 0) {
                    pq.add(new Location(laddersAndSnakes[nLocation], now.count + 1));
                    check[laddersAndSnakes[nLocation]] = true;
                } else {
                    pq.add(new Location(nLocation, now.count + 1));
                }
            }
        }
    }

    static class Location implements Comparable<Location> {
        int location, count;

        public Location(int location, int count) {
            this.location = location;
            this.count = count;
        }

        @Override
        public int compareTo(Location o) {
            return count - o.count;
        }
    }

}
