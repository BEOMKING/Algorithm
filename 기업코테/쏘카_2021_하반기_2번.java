package 기업코테;

import java.io.IOException;

public class 쏘카_2021_하반기_2번 {
    static int[] result;
    static int answer = Integer.MAX_VALUE;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        int[] number = {10, 40, 30, 20, 50};
//        int[] number = {10, 30, 20};
        int k = 20;
//        int k = 10;
        System.out.println(solution(number, k));
        System.out.println(cnt);
    }

    public static int solution(int[] numbers, int K) {
        result = new int[numbers.length];
        combination(numbers, K, 0, 0);
        if(answer == Integer.MAX_VALUE) return -1;
        return answer;
    }

    private static void combination(int[] numbers, int K, int count, int min) {
//        if(answer <= min) return; // 이미 최소값이 될 수 없는 경우

        int[] temp = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            temp[i] = numbers[i];
        }

        if (count == numbers.length) {
//            System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3]);
            if (!validation(K)) { // 각 요소의 앞 뒤 차이가 K를 초과하면 조건 불합
                return;
            }
            answer = Math.min(answer, min);
            return;
        }

//        for (int i = count; i < numbers.length; i++) {
//            for (int j = i + 1; j < numbers.length; j++) { // 다음 자리와 변경한 경우
//                cnt++;
//                result[count] = temp[j];
//                int t = temp[i];
//                temp[i] = temp[j];
//                temp[j] = t;
//                combination(temp, K, count + 1, min + 1);
//                temp[j] = temp[i];
//                temp[i] = t;
//            }
//            cnt++;
//            result[count] = temp[i]; // 자리를 바꾸지 않음
//            combination(temp, K, count + 1, min);
//        }
        result[count] = temp[count]; // 자리를 바꾸지 않음
        combination(temp, K, count + 1, min);
        cnt++;
        for (int i = count; i < numbers.length; i++) { // 다음 자리와 변경한 경우
            if(i + 1 >= numbers.length) continue;
            cnt++;
            int t = temp[count];
            temp[count] = temp[i + 1];
            temp[i + 1] = t;
            result[count] = temp[count];
            result[count + 1] = temp[count + 1];
            combination(temp, K, count + 1, min + 1);
        }

    }

    private static boolean validation(int K) {
        int before = result[0];
//        boolean check[] = new boolean[101];
//        check[before] = true;
        for (int i = 1; i < result.length; i++) {
//            if (Math.abs(before - result[i]) > K || check[result[i]]) { // 차이가 K 초과이거나 잘못 정렬된 결과가 올 경우
//                return false;
//            }
            if (Math.abs(before - result[i]) > K) { // 차이가 K 초과이거나 잘못 정렬된 결과가 올 경우
                return false;
            }
            if (Math.abs(before - result[i]) > K) {
                return false;
            }
//            check[result[i]] = true;
            before = result[i];
        }
        return true;
    }

}
