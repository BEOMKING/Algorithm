package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_14891_톱니바퀴 {
    static int map[][] = new int[4][8];
    static boolean check[] = new boolean[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 4; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = Integer.parseInt(str.substring(j, j + 1));
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            checkstatus(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
            Arrays.fill(check, false);
        }

        int result = 0;
        int score = 1;
        for (int i = 0; i < 4; i++) {
            if(map[i][0] != 0){
                result += score;
            }
            score *= 2;
        }
        System.out.println(result);
    }
    static void checkstatus(int num, int dir) {
        if(check[num]) return;
        check[num] = true;

        int pre = num - 1;
        int next = num + 1;
        if(pre >= 0){
            if(map[num][6] != map[pre][2]){
                checkstatus(pre, (dir == 1) ? -1 : 1);
            }
        }
        if(next <= 3){
            if(map[num][2] != map[next][6]){
                checkstatus(next, (dir == 1) ? -1 : 1);
            }
        }

        move(num, dir);
    }

    static void move(int num, int dir){
        if(dir == 1){
            int temp = map[num][7];
            for (int i = 7; i >= 1; i--) {
                map[num][i] = map[num][i - 1];
            }
            map[num][0] = temp;
        }else{
            int temp = map[num][0];
            for (int i = 0; i <= 6; i++) {
                map[num][i] = map[num][i + 1];
            }
            map[num][7] = temp;
        }
    }
}
