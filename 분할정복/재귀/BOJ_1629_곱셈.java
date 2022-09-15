package 분할정복.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1629_곱셈 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int A = Integer.parseInt(inputs[0]);
        int B = Integer.parseInt(inputs[1]);
        int C = Integer.parseInt(inputs[2]);

        System.out.println(recursion(A, B, C));
    }

    private static long recursion(int a, int b, int c) {
        if (b == 1) {
            return a % c;
        }

        long result = recursion(a, b / 2, c);
        result = result * result % c;
        if (b % 2 != 0) result = result * a % c;
        return result;
    }
}

