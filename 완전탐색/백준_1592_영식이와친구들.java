package 완전탐색;

import java.util.Scanner;

public class 백준_1592_영식이와친구들 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();

        int n = 0;
        int count = 0;
        int num[] = new int[N];

        while (true) {
            num[n] += 1;
            if(num[n] == M) break;

            if (num[n] % 2 == 1) {
                n = (n + L) % N;
            } else {
                if(n - L < 0) {
                    n = (n - L) + N;
                }else{
                    n -= L;
                }
            }
            count += 1;
        }
        System.out.println(count);
    }
}