package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_10163_색종이 {
    static int map[][];
    static int paper[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        map = new int[101][101];
        paper = new int[N + 1];

        for(int n = 1; n <= N; n++){
            st = new StringTokenizer(br.readLine());
            int starty = Integer.parseInt(st.nextToken());
            int startx = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            for(int i = starty; i < starty + y; i++){
                for(int j = startx; j < startx + x; j++){
                    map[i][j] = n;
                }
            }
        }

        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++){
                paper[map[i][j]] += 1;
            }
        }

        for(int i = 1; i < N + 1; i++) {
            System.out.println(paper[i]);
        }
    }
}
