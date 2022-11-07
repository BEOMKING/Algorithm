package 기업코테;

import java.util.Arrays;

// https://browsespot.blogspot.com/2018/04/minimum-distance-of-adjacent-pair-in.html
public class 십일번가_2022_하반기_인턴_2번 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 3, 3, 7, 5, 3, 11, 1}));
    }

    public static int solution(int[] A) {
        if (A.length == 1) {
            return -2;
        }

        Arrays.sort(A);

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < A.length; i++) {
            int distance = A[i] - A[i - 1];
            if (distance < min) {
                min = distance;
            }
        }

        return min > 100000000 ? -1 : min;
    }
}
