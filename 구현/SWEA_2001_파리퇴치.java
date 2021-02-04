package 구현;

import java.util.Scanner;

public class SWEA_2001_파리퇴치 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int answer[] = new int[T];

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt(); // 배열 크기
            int M = sc.nextInt(); // 파리채 크기
            int pari[][] = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    pari[i][j] = sc.nextInt();
                }
            }

            int max = 0; // 최대값
            int result = 0; // 최대값과 비교할 현재 값

            for (int k = 0; k < N - M + 1; k++) { // 배열 크기 - 파리채 크기 + 1 -> 파리채 크기만큼의 배열 순회
                for (int l = 0; l < N - M + 1; l++) {
                    for (int i = k; i < k + M; i++) { // 현재 시작 위치에서 파리채 크기만큼만 순회
                        for (int j = l; j < l + M; j++) {
                            result += pari[i][j];
                        }
                    }
                    if (max < result) {
                        max = result;
                    }
                    result = 0;
                }
            }
            answer[t] = max;
        }

        for (int i = 0; i < T; i++) {
            System.out.print("#" + (i + 1) + " ");
            System.out.println(answer[i]);
        }
    }
}