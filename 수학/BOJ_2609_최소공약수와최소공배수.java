package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609_최소공약수와최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        if (A < B) {
            int temp = A;
            A = B;
            B = temp;
        }

        int gcd = GCD(A, B);
        System.out.println(gcd);
        System.out.println(LCD(A, B, gcd));
    }

    private static int LCD(int a, int b, int gcd) {
        return gcd * (a / gcd) * (b / gcd);
    }

    private static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
}
