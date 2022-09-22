package 완전탐색.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15658_연산자끼워넣기2 {
    static int[] permutations;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        int[] operations = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
        }
        permutations = new int[N - 1];
        permutation(0, sequence, operations);
        System.out.println(max);
        System.out.println(min);
    }

    private static void permutation(int count, int[] sequence, int[] operations) {
        if(count == sequence.length - 1) {
            int result = calculate(sequence);
            max = Math.max(result, max);
            min = Math.min(result, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(operations[i] == 0) continue;
            permutations[count] = i;
            operations[i]--;
            permutation(count + 1, sequence, operations);
            operations[i]++;
        }
    }

    private static int calculate(int[] sequence) {
        int before = sequence[0];
        for (int i = 0; i < permutations.length; i++) {
            int after = sequence[i + 1];
            before = calculateDetail(before, after, permutations[i]);
        }
        return before;
    }

    private static int calculateDetail(int before, int after, int permutation) {
        if(permutation == 0) return plus(before, after);
        if(permutation == 1) return minus(before, after);
        if(permutation == 2) return multi(before, after);
        return divid(before, after);
    }

    private static int divid(int before, int after) {
        if(before < 0 && after > 0) {
            before = Math.abs(before);
            return -(before / after);
        }
        return before / after;
    }

    private static int multi(int before, int after) {
        return before * after;
    }

    private static int minus(int before, int after) {
        return before - after;
    }

    private static int plus(int before, int after) {
        return before + after;
    }

}
