package datastucture.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9934_완전이진트리 {
    static String[] result;
    static int[] input;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        int count = (int) Math.pow(2, K) - 1;
        input = new int[count];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        result = new String[K];
        Arrays.fill(result, "");
        make(0, count - 1, 0);
        for (int i = 0; i < K; i++) {
            System.out.println(result[i]);
        }

    }

    public static void make(int start, int end, int floor) {
        if(floor == K) return;
        int mid = (start + end) / 2;
        result[floor] += input[mid] + " ";
        make(start, mid - 1, floor + 1);
        make(mid + 1, end, floor + 1);
    }

}
