package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Softeer_GBC {
    /**
     * 엘레베이터 검사 범위가 100m로 고정되어 있어 실제 운영 기록과 테스트 기록의 모든 위치 정보에 대한 제한 속도를 저장할 수 있는 배열을 만들어 저장한다.
     * 실제 운영 기록을 저장할 배열 real과 테스트 기록을 저장할 배열 test를 완전 탐색하면서, 제한 속도를 넘은 경우의 최대 값을 구하면 해결할 수 있었다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        int[] real = new int[101];
        int now = 1;
        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            int length = Integer.parseInt(inputs[0]);
            int limit = Integer.parseInt(inputs[1]);

            for (int j = now; j < now + length; j++) {
                real[j] = limit;
            }

            now += length;
        }

        now = 1;
        int[] test = new int[101];
        for (int i = 0; i < M; i++) {
            inputs = br.readLine().split(" ");
            int length = Integer.parseInt(inputs[0]);
            int limit = Integer.parseInt(inputs[1]);

            for (int j = now; j < now + length; j++) {
                test[j] = limit;
            }

            now += length;
        }

        int result = 0;
        for (int i = 1; i <= 100; i++) {
            if (real[i] < test[i]) {
                result = Math.max(result, test[i] - real[i]);
            }
        }

        System.out.print(result);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] inputs = br.readLine().split(" ");
//        int N = Integer.parseInt(inputs[0]);
//        int M = Integer.parseInt(inputs[1]);
//
//        int[][] real = new int[N][2];
//        for (int i = 0; i < N; i++) {
//            inputs = br.readLine().split(" ");
//            real[i][0] = Integer.parseInt(inputs[0]);
//            real[i][1] = Integer.parseInt(inputs[1]);
//        }
//
//        int[][] test = new int[M][2];
//        for (int i = 0; i < M; i++) {
//            inputs = br.readLine().split(" ");
//            test[i][0] = Integer.parseInt(inputs[0]);
//            test[i][1] = Integer.parseInt(inputs[1]);
//        }
//
//        int i = 0;
//        int j = 0;
//        int iPlace = real[0][0];
//        int jPlace = test[0][0];
//        int iLimit = real[0][1];
//        int jLimit = test[0][1];
//        int result = 0;
//
//        while (true) {
//            if (iLimit < jLimit) {
//                result = Math.max(result, jLimit - iLimit);
//            }
//
//            if (i == N - 1 && j == M - 1) {
//                break;
//            }
//            if (iPlace > jPlace) {
//                j++;
//                jPlace += test[j][0];
//                jLimit = test[j][1];
//            } else if (iPlace == jPlace) {
//                i++;
//                iPlace += real[i][0];
//                iLimit = real[i][1];
//                j++;
//                jPlace += test[j][0];
//                jLimit = test[j][1];
//            } else {
//                i++;
//                iPlace += real[i][0];
//                iLimit = real[i][1];
//            }
//
//        }
//
//        System.out.print(result);
//    }
}
