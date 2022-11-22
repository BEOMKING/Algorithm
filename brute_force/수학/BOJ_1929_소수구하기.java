package brute_force.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929_소수구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] notPrimes = new boolean[N + 1];
        notPrimes[1] = true;

        for (int i = 2; i * i <= N; i++) {
            if (notPrimes[i]) continue;
            for (int j = i + i; j <= N; j+=i) {
                notPrimes[j] = true;
            }
        }

        for (int i = M; i <= N; i++) {
            if (!notPrimes[i]) {
                System.out.println(i);
            }
        }
    }

}
