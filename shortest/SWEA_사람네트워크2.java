package shortest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_사람네트워크2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int map[][] = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    if (input == 0) {
                        map[i][j] = 10000;
                    } else {
                        map[i][j] = input;
                    }
                }
            }
            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) { // 출발점 도착점 경유지가 같으면 안된다는 조건을 주면 시간이 더 걸림
                    for (int j = 0; j < N; j++) {
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }

            int dis;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                dis = 0;
                for (int j = 0; j < N; j++) {
                    if(i != j) {
                        dis += map[i][j];
                    }
                }
                min = Math.min(min, dis);
            }
            sb.append("#" + (t + 1) + " " + min + "\n");
        }
        System.out.print(sb.toString().trim());
    }
}
/*
1000000000

2 3 2 1 1 3
2 4 2 1 1 4
3 2 3 1 1 2
3 4 3 1 1 4

1 3
1 4
3 1
3 4

1 2 1 3 3 2
1 4 1 3 3 4
2 1
2 4


 0 1 0
 1 0 1
 0 1 0
 */