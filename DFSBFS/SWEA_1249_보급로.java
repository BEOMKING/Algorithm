package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SWEA_1249_보급로 {
    static int map[][];
    static boolean visited[][];
    static int dy[] = new int[]{-1, 0, 1, 0};
    static int dx[] = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        int C = Integer.parseInt(br.readLine());
        for (int c = 0; c < C; c++) {
            int N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(str.substring(j, j + 1));
                }
            }

            int answer = 0;
            PriorityQueue<Node> queue = new PriorityQueue<>();
            queue.add(new Node(0, 0, 0));
            while(!queue.isEmpty()){
                Node now = queue.poll();
                if(now.y == N - 1 && now.x == N - 1){
                    answer = now.recovery;
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int ny = now.y + dy[i];
                    int nx = now.x + dx[i];
                    if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                    if(visited[ny][nx]) continue;
                    visited[ny][nx] = true;
                    queue.add(new Node(ny, nx, now.recovery + map[ny][nx]));
                }
            }
            sb.append("#" + (c + 1) + " " + answer + "\n");
        }
        System.out.print(sb.toString());
    }

    static class Node implements Comparable<Node>{
        int y;
        int x;
        int recovery;

        public Node(int y, int x, int recovery) {
            this.y = y;
            this.x = x;
            this.recovery = recovery;
        }

        @Override
        public int compareTo(Node o) {
            return recovery - o.recovery;
        }
    }
}
