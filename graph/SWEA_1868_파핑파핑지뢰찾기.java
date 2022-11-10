package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1868_파핑파핑지뢰찾기 {
    static int N, answer, ny, nx, count, map[][];
    static int dy[] = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
    static int dx[] = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
    static char temp[][];
    static Queue<Node> queue;
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            temp = new char[N][N];
            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                temp[i] = br.readLine().toCharArray(); // 입력
            }

            for (int i = 0; i < N; i++) { // 지뢰와 주변 지뢰 개수를 담은 배열 생성
                for (int j = 0; j < N; j++) {
                    count = 0;
                    if(temp[i][j] == '.'){
                        for (int k = 0; k < 8; k++) {
                            ny = i + dy[k];
                            nx = j + dx[k];
                            if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                            if(temp[ny][nx] == '*') {
                                count++;
                            }
                        }
                        map[i][j] = count;
                    }else{
                        map[i][j] = -1;
                        visited[i][j] = true;
                    }
                }
            }

            answer = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == 0 && !visited[i][j]){
                        answer++;
                        visited[i][j] = true;
                        bfs(i, j);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]) answer++;
                }
            }

            System.out.println("#" + t + " " + answer);
        }
    }
    private static void bfs(int i, int j) {
        queue = new LinkedList<>();
        queue.add(new Node(i, j));

        while(!queue.isEmpty()){
            Node now = queue.poll();
            count = 0; // 지뢰

            for (int k = 0; k < 8; k++) {
                ny = now.y + dy[k];
                nx = now.x + dx[k];
                if(ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) continue; // 범위 밖, 이미 방문
                visited[ny][nx] = true;
                if(map[ny][nx] == 0){
                    queue.add(new Node(ny, nx));
                }
            }

        }
    }
    static class Node{
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
