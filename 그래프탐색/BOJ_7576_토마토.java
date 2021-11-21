package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
    static int N, M, map[][], count = 0, ny, nx;
    static int dy[] = new int[]{-1, 0, 1, 0};
    static int dx[] = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        PriorityQueue<Location> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int now = Integer.parseInt(st.nextToken());
                map[i][j] = now;
                if(now == 1){
                    queue.add(new Location(i, j, 0));
                    count++;
                }
            }
        }

        int answer = 0;
        while(!queue.isEmpty()){
            Location now = queue.poll();
            answer = now.day;

            for (int i = 0; i < 4; i++) {
                ny = now.y + dy[i];
                nx = now.x + dx[i];
                if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if(map[ny][nx] != 0) continue;
                map[ny][nx] = 1;
                queue.add(new Location(ny, nx, now.day + 1));
            }
        }
        if(check()){
            System.out.print(answer);
        }else{
            System.out.print(-1);
        }

    }
    static boolean check(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) return false;
            }
        }
        return true;
    }
    static class Location implements Comparable<Location>{
        int y, x, day;

        public Location(int y, int x, int day) {
            this.y = y;
            this.x = x;
            this.day = day;
        }

        @Override
        public int compareTo(Location o) {
            return day - o.day;
        }
    }
}
