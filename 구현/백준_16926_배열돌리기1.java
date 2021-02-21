package 구현;

import java.io.*;
import java.util.StringTokenizer;

public class 백준_16926_배열돌리기1 {
    static int N;
    static int M;
    static int R;
    static int group;
    static int array[][];
    static int dy[] = new int[]{0, 1, 0, -1}; // 동 남 서 북
    static int dx[] = new int[]{1, 0, -1, 0};

    static void turn(){
        for(int g = 0; g < group; g++) {
            int y = g;
            int x = g;
            int temp = array[y][x];
            int direction = 0;
            while(direction < 4) {
                int ny = y + dy[direction];
                int nx = x + dx[direction];
                if (ny >= 0 + g && ny < N - g && nx >= 0 + g && nx < M - g) {// 그룹 내부로 가면 배열의 크기도 줄어든다.
                    array[y][x] = array[ny][nx];
                    y = ny;
                    x = nx;
                } else {
                    direction += 1;
                }
            }
            array[y + 1][x] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        group =  Math.min(N, M) / 2; // 회전을 해야할 그룹을 찾는다. 두 수의 최소값을 2번으로 나눈 수가 그룹의 수 (2x2 이상은 되어야 회전이 가능, 1x2도 회전이 가능하다고 착각했었음)
        array = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r = 0; r < R; r++){ // 회전 횟수
            turn();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                bw.write(array[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
