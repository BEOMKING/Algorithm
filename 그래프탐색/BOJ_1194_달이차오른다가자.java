package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194_달이차오른다가자 {
    static int N, M;
    static char[][] map;
    static int[] dy = new int[]{1, 0, -1, 0};
    static int[] dx = new int[]{0, 1, 0, -1};
    static Queue<Minsik> q;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][64];
        q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                char now = input.charAt(j);
                map[i][j] = now;
                if(now == '0') {
                    q.add(new Minsik(i, j, 0, 0));
                    visited[i][j][0] = true;
                }
            }
        }
        System.out.println(BFS());
    }
    static int BFS(){
        while (!q.isEmpty()){
            Minsik now = q.poll();
            int y = now.y; int x = now.x;
            int move = now.move; int key = now.key;

            if(map[y][x] == '1') return move;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if(visited[ny][nx][key]) continue;
                if(map[ny][nx] == '#') continue;

                if(map[ny][nx] - 'a' >= 0 && map[ny][nx] - 'a' <= 5){
                    int nkey = (1 << (map[ny][nx] - 'a')) | key;

                    if(visited[ny][nx][nkey]) continue;
                    q.add(new Minsik(ny, nx,now.move + 1, nkey));
                    visited[ny][nx][nkey] = true;
                }else if(map[ny][nx] - 'A' >= 0 && map[ny][nx] - 'A' <= 5){
                    if((key & (1 << (map[ny][nx] - 'A'))) == 0) continue;

                    q.add(new Minsik(ny, nx,now.move + 1, key));
                    visited[ny][nx][key] = true;
                }else {
                    q.add(new Minsik(ny, nx,now.move + 1, key));
                    visited[ny][nx][key] = true;
                }
            }
        }
        return -1;
    }
    static class Minsik{
        int y, x, move, key;
        public Minsik(int y, int x, int move, int key) {
            this.y = y;
            this.x = x;
            this.move = move;
            this.key = key;
        }
    }
}
