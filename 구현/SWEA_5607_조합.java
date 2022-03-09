package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5607_조합 {
    static final int mod = 1234567891;
    static int N, R;
    static long fac[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        fac = new long[1000001];
        fac[0] = 1;
        for (int i = 1; i <= 1000000; i++) {
            fac[i] = (fac[i - 1] * i) % mod;
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            long top = fac[N] % mod;
            long bottom = (fac[N - R] * fac[R]) % mod;
            long botTotop = power(bottom, mod - 2);

            System.out.println("#" + t + " " + (top * botTotop) % mod);
        }
    }
    private static long power(long bot, int p) {
        if(p == 0){
            return 1;
        }

        long half = power(bot, p / 2);

        if(p % 2 == 0){
            return ((half % mod) * (half % mod)) % mod;
        }else{
            return (((bot * half) % mod) * (half % mod)) % mod;
        }
    }
}
