package 그래프탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6603_로또 {
    static StringBuilder sb = new StringBuilder();
    static String[] arr = new String[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" ");
            int count = Integer.parseInt(parts[0]);
            if (count == 0) {
                break;
            }

            recursion(parts, 1, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void recursion(final String[] parts, final int start, final int count) {
        if (count == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < parts.length; i++) {
            arr[count] = parts[i];
            recursion(parts, i + 1, count + 1);
        }
    }
}
