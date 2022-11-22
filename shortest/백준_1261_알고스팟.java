package shortest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_1261_알고스팟 {
    static int dy[] = new int[]{-1, 0, 1, 0};
    static int dx[] = new int[]{0, 1, 0, -1};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // x
        n = Integer.parseInt(st.nextToken()); // y
        int map[][] = new int[n][m];
        int d[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < d.length; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE);
        }
        d[0][0] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(0, 0, d[0][0]));
        Node now = null;

        while(!queue.isEmpty()){
            now = queue.poll();
            if(now.y == n - 1 && now.x == m - 1) break;

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                int cost = map[ny][nx];
                if(d[ny][nx] > d[now.y][now.x] + cost){
                    d[ny][nx] = d[now.y][now.x] + cost;
                    queue.offer(new Node(ny, nx, d[ny][nx] + cost));
                }
            }
        }
        System.out.print(d[n- 1][m - 1]);
    }
    static class Node implements Comparable<Node>{
        int y;
        int x;
        int dis;

        public Node(int y, int x, int dis) {
            this.y = y;
            this.x = x;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            return dis - o.dis;
        }
    }
}
