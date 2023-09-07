package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Softeer_바이러스
{
    /**
     * K, P가 최대 1억이므로 K * P는 int 범위를 넘어갈 수 있다는 점을 주의해야 한다.
     * 따라서, 매 연산마다 모듈러 연산을 수행해야 한다.
     */
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        long K = Integer.parseInt(inputs[0]);
        long P = Integer.parseInt(inputs[1]);
        int N = Integer.parseInt(inputs[2]);

        for (int n = 0; n < N; n++) {
            K = (K * P) % 1000000007;
        }

        System.out.println(K);
    }
}
