package 최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1922_네트워크연결 {
    static int N, M;
    static int[] edge;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        edge = new int[N + 1];
        Arrays.fill(edge, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = c;
            map[b][a] = c;
        }

        edge[1] = 0;
        int result = 0;

        for (int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE;
            int minVertex = 0;

            for (int j = 1; j <= N; j++) {
                if(!visited[j] && min > edge[j]){
                    min = edge[j];
                    minVertex = j;
                }
            }

            result += min;
            visited[minVertex] = true;

            for (int j = 1; j <= N; j++) {
                if(!visited[j] && map[minVertex][j] > 0 && edge[j] > map[minVertex][j]){
                    edge[j] = map[minVertex][j];
                }
            }
        }
        System.out.println(result);
    }
}
