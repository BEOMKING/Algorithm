package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z {
    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        System.out.println(dicision((int) Math.pow(2, N), 0, 0));
    }

    private static int dicision(int size, int y, int x) {
        if (size == 1) {
            return 0;
        }

        if (r < y + size / 2 && c < x + size / 2) {
            return dicision(size / 2, y, x);
        }

        if (r < y + size / 2 && c < x + size) {
            return dicision(size / 2, y, x + size / 2) + (int) Math.pow(size / 2, 2);
        }

        if (r < y + size && c < x + size / 2) {
            return dicision(size / 2, y + size / 2, x) + (int) Math.pow(size / 2, 2) * 2;
        }

        return dicision(size / 2, y + size / 2, x + size / 2) + (int) Math.pow(size / 2, 2) * 3;
    }
}
