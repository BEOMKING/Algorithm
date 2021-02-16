package 그리디;

import java.util.Scanner;

public class 백준_2839_설탕배달 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = -1;
        int N = sc.nextInt();

        for(int i = N / 5; i >= 0; i--){
            int minus = 5 * i;
            if((N - minus) % 3 == 0) {
                int b = (N - minus) / 3;
                result = i + b;
                break;
            }
        }

        System.out.println(result);
    }
}
