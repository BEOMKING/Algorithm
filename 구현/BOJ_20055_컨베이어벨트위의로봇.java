package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어벨트위의로봇 {
    static int N, K, count, now = 0;
    static int[] belt;
    static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new int[2 * N]; robot = new boolean[2 * N];
        initial(new StringTokenizer(br.readLine()));

        while(true) {
            now++;
            one();
            two();
            three();
            if(four()) break;
        }

        System.out.println(now);
    }

    private static void initial(StringTokenizer st) {
        for (int i = 0; i < belt.length; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void one() {
        int beltS = belt[belt.length - 1];
        boolean robotS = robot[belt.length - 1];

        for (int i = belt.length - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
            robot[i] = robot[i - 1];
        }

        belt[0] = beltS;
        robot[0] = robotS;
        drop();
    }

    private static void drop() {
        robot[N - 1] = false;
    }

    private static void two() {
        for (int i = N - 2; i >= 0 ; i--) {
            if(!robot[i] || robot[i + 1] || belt[i + 1] < 1) continue;
            robot[i + 1] = robot[i];
            robot[i] = false;
            belt[i + 1]--;
        }
        drop();
    }

    private static void three() {
        if(belt[0] == 0) return;
        robot[0] = true;
        belt[0]--;
    }

    private static boolean four() {
        count = 0;
        for (int i = 0; i < belt.length; i++) {
            if(belt[i] == 0) count++;
        }

        if(count < K) return false;
        return true;
    }

}
