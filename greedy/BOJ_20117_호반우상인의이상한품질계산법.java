package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20117_호반우상인의이상한품질계산법 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] hobanus = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            hobanus[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(hobanus);
        int max = 0;
        for (int i = N - 1; i > N / 2; i--) {
            max += hobanus[i] * 2;
        }
        if(N % 2 != 0) {
            max += hobanus[N / 2];
        } else {
            max += hobanus[N / 2] * 2;
        }
        System.out.println(max);
    }

}
