package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2428_표절 {
    static int[] solution;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        solution = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(solution);

        int start = 1; int end = 1;
        long result = 0;

        while (start < N){
            while(true){
                if(end >= N) break;
                if(solution[start] < (double) solution[end + 1] * 0.9) break;
                end++;
            }
            result += end - start++;
        }
        System.out.println(result);
    }
}
