package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_14889_스타트와링크 {
    static int N;
    static int map[][];
    static int start[];
    static int link[];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        start = new int[N / 2];
        link = new int[N / 2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combination(0, 0);
        System.out.println(min);
    }
    static void combination(int first, int count){
        if(count == N / 2){
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                boolean flag = false;
                for (int j = 0; j < start.length; j++) {
                    if(i == start[j]){
                        flag = true;
                        break;
                    }
                }
                if(!flag) link[cnt++] = i;
            }
            int startscore = 0;
            int linkscore = 0;
            for (int i = 0; i < N / 2; i++) {
                for (int j = 0; j < N / 2; j++) {
                    startscore += map[start[i]][start[j]];
                    linkscore += map[link[i]][link[j]];
                }
            }
            min = Math.min(min, Math.abs(startscore - linkscore));
            return;
        }
        for (int i = first; i < N; i++) {
            start[count] = i;
            combination(i + 1, count + 1);
        }
    }
}
