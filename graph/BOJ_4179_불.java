package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179_불 {
    static int R, C;
    static int dy[] = new int[]{-1, 0, 1, 0};
    static int dx[] = new int[]{0, 1, 0, -1};
    static char map[][];
    static Queue<Location> fqueue, jqueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        fqueue = new LinkedList<>();
        jqueue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if(map[i][j] == 'J'){
                    jqueue.add(new Location(i, j));
                }else if(map[i][j] == 'F') {
                    fqueue.add(new Location(i, j));
                }
            }
        }
        int answer = bfs();
        if(answer == -1) System.out.println("IMPOSSIBLE");
        else System.out.println(answer);
    }
    static int bfs(){
        int count = 0;
        while (!jqueue.isEmpty()) {
            count++;
            int size = fqueue.size();

            for (int i = 0; i < size; i++) {
                Location fnow = fqueue.poll();

                for (int j = 0; j < 4; j++) {
                    int ny = fnow.y + dy[j];
                    int nx = fnow.x + dx[j];
                    if(ny < 0 || ny >= R || nx < 0 || nx >= C) continue; // 범위 밖
                    if(map[ny][nx] == 'F' || map[ny][nx] == '#') continue; // 이미 불이 번졌다면
                    map[ny][nx] = 'F';
                    fqueue.add(new Location(ny, nx));
                }
            }

            size = jqueue.size();
            for (int i = 0; i < size; i++) {
                Location jnow = jqueue.poll();

                for (int j = 0; j < 4; j++) {
                    int ny = jnow.y + dy[j];
                    int nx = jnow.x + dx[j];
                    if(ny < 0 || ny >= R || nx < 0 || nx >= C) return count; // 탈출 조건
                    if(map[ny][nx] == 'J' || map[ny][nx] == '#' || map[ny][nx] == 'F') continue; // 불이 번졌거나 벽이거나 이미 방문한 곳이거나
                    map[ny][nx] = 'J';
                    jqueue.add(new Location(ny, nx));
                }
            }
        }
        return -1;
    }
    static class Location{
        int y, x;
        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
