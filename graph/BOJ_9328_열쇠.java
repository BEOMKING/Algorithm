package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_9328_열쇠 {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String[] inputs = br.readLine().split(" ");
            int h = Integer.parseInt(inputs[0]);
            int w = Integer.parseInt(inputs[1]);
            h += 2; w += 2;
            char[][] maps = new char[h][w];
            for (int i = 0; i < h; i++) {
                maps[i][0] = '.';
                maps[i][w - 1] = '.';
            }
            for (int i = 0; i < w; i++) {
                maps[0][i] = '.';
                maps[h - 1][i] = '.';
            }

            for (int i = 1; i < h - 1; i++) {
                String input = br.readLine();

                for (int j = 1; j < w - 1; j++) {
                    maps[i][j] = input.charAt(j - 1);
                }
            }

            String key = br.readLine();
            boolean[] keys = new boolean['z' - 'a' + 1];
            if (!key.equals("0")) {
                for (int i = 0; i < key.length(); i++) {
                    keys[key.charAt(i) - 'a'] = true;
                }
            }

            boolean[][] checked = new boolean[h][w];
            Queue<Location>[] candidates = new Queue['z' - 'a' + 1];
            for (int i = 0; i < candidates.length; i++) {
                candidates[i] = new LinkedList<>();
            }
            Queue<Location> queue = new LinkedList<>();
            queue.add(new Location(0, 0));
            checked[0][0] = true;

            int max = 0;
            while (!queue.isEmpty()) {
                Location now = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = now.y + dy[i];
                    int nx = now.x + dx[i];

                    if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                    char next = maps[ny][nx];
                    if (checked[ny][nx]) continue;
                    if (next == '*') continue;
                    checked[ny][nx] = true;

                    if (next >= 'A' && next <= 'Z') {
                        if (keys[next - 'A']) {
                            queue.add(new Location(ny, nx));
                        } else {
                            candidates[next - 'A'].add(new Location(ny, nx));
                        }
                    }
                    if (next >= 'a' && next <= 'z') {
                        keys[next - 'a'] = true;
                        queue.add(new Location(ny, nx));

                        Queue<Location> candidate = candidates[next - 'a'];
                        while (!candidate.isEmpty()) {
                            queue.add(candidate.poll());
                        }
                    }
                    if (next == '$') {
                        queue.add(new Location(ny, nx));
                        max++;
                    }
                    if (next == '.') {
                        queue.add(new Location(ny, nx));
                    }
                }
            }

            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }

    static class Location {
        int y, x;

        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
