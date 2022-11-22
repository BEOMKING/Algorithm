package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8911_거북이 {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int direction, minY, minX, maxY, maxX, y, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            char[] operation = br.readLine().toCharArray();
            direction = 0;
            minY = minX = maxY = maxX = 0;
            y = 0; x = 0;

            for (char oper : operation) {
                operate(oper);
            }

            sb.append((maxY - minY) * (maxX - minX) + "\n");
        }

        System.out.println(sb);
    }

    public static void operate(char operation) {
        if (operation == 'F') {
            forward();
        }
        if (operation == 'B') {
            back();
        }
        if (operation == 'L') {
            turnLeft();
        }
        if (operation == 'R') {
            turnRight();
        }
        calMaxMin();

    }

    public static void forward() {
        y += dy[direction];
        x += dx[direction];
    }

    public static void back() {
        y += dy[(direction + 2) % 4];
        x += dx[(direction + 2) % 4];
    }

    public static void turnLeft() {
        direction = (direction + 3) % 4;
    }

    public static void turnRight() {
        direction = ++direction % 4;
    }

    public static void calMaxMin() {
        minY = Math.min(minY, y);
        minX = Math.min(minX, x);
        maxY = Math.max(maxY, y);
        maxX = Math.max(maxX, x);
    }
}
