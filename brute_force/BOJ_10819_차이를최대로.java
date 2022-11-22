package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10819_차이를최대로 {
    static int N;
    static int[] array, numbers;
    static boolean[] checked;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        array = new int[N];
        numbers = new int[N];
        checked = new boolean[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        permutation(0);
        System.out.println(max);
    }

    static void permutation(int count) {
        if(count == N) {
            max = Math.max(max, calMax());
            return;
        }

        for (int i = 0; i < N; i++) {
            if(checked[i]) continue;
            numbers[count] = array[i];
            checked[i] = true;
            permutation(count + 1);
            checked[i] = false;
        }
    }

    private static int calMax() {
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(numbers[i] - numbers[i + 1]);
        }
        return sum;
    }

}
