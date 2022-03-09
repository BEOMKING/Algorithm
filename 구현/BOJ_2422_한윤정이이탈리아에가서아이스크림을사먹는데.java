package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2422_한윤정이이탈리아에가서아이스크림을사먹는데 {
    static int result = 0;
    static int N, M;
    static int[] ice = new int[3];
    static boolean[][] impossibility;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        impossibility = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            impossibility[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = true;
            impossibility[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = true;
        }

        combination(1, 0);
        System.out.println(result);

    }

    public static void combination(int start, int count) {
        if(count == 3) {
            result++;
            return;
        }

        for (int i = start; i <= N; i++) { // 확인할 번호
            if(!check(count, i)) continue;
            ice[count] = i;
            combination(i + 1, count + 1);
        }

    }

    public static boolean check(int count, int now) {
        for (int j = 0; j < count; j++) {
            if(impossibility[ice[j]][now]) return false;
        }
        return true;
    }

}
