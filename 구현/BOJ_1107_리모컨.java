package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107_리모컨 {
    static int target, min;
    static boolean[] broken = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        target = Integer.parseInt(br.readLine());
        int brokenNum = Integer.parseInt(br.readLine());
        if (brokenNum != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < brokenNum; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        min = Math.abs(100 - target);
        for (int i = 0; i < 1000000; i++) {
            int move = possible(i);
            if (move == 0) continue;
            min = Math.min(min, move + Math.abs(i - target));
        }

        System.out.println(min);
    }

    private static int possible(int num) {
        if (num == 0) {
            if (broken[0]) return 0;
            else return 1;
        }

        int len = 0;
        while (num > 0) {
            if (broken[num % 10]) return 0;
            num /= 10;
            len++;
        }

        return len;
    }
}
