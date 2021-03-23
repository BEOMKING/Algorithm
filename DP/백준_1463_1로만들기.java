package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1463_1로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int n[] = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            n[i] = n[i - 1] + 1;
            if(i % 2 == 0){
                n[i] = Math.min(n[i], n[i / 2] + 1);
            }
            if(i % 3 == 0){
                n[i] = Math.min(n[i], n[i / 3] + 1);
            }
        }
        System.out.print(n[N]);
    }
}
