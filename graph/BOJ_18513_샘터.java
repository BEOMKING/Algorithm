package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18513_샘터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] sam = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sam[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs(sam, K));
    }

    public static long bfs(int[] sam, int K) {
        int[] lr = {-1, 1};
        HashSet<Integer> hashSet = new HashSet<>();
        Queue<Location> queue = new LinkedList<>();

        for (int i = 0; i < sam.length; i++) {
            hashSet.add(sam[i]);
            queue.add(new Location(sam[i], 0));
        }

        int count = 0;
        long unhappyness = 0;

        while (!queue.isEmpty()) {
            if (count == K) break;
            Location now = queue.poll();
            for (int i = 0; i < lr.length; i++) {
                if (!hashSet.contains(now.location + lr[i])) {
                    hashSet.add(now.location + lr[i]);
                    queue.add(new Location(now.location + lr[i], now.distance + 1));
                }
            }

            if (now.distance == 0) continue;
            count++;
            unhappyness += now.distance;
        }

        return unhappyness;
    }

    public static class Location {
        int location, distance;

        public Location(int location, int distance) {
            this.location = location;
            this.distance = distance;
        }
    }

}
