package simulation;

import java.util.Arrays;
import java.util.List;

class Pro_키패드누르기 {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left = 10;
        int right = 12;
        List<Integer> leftList = Arrays.asList(1, 4, 7);
        List<Integer> rightList = Arrays.asList(3, 6, 9);

        for (int n : numbers) {
            if (leftList.contains(n)) {
                left = n;
                sb.append("L");
            } else if (rightList.contains(n)) {
                right = n;
                sb.append("R");
            } else {
                if (n == 0) {
                    n = 11;
                }

                int leftDistance = Math.abs(n - left) / 3 + Math.abs(n - left) % 3;
                int rightDistance = Math.abs(n - right) / 3 + Math.abs(n - right) % 3;

                if (leftDistance < rightDistance) {
                    left = n;
                    sb.append("L");
                } else if (leftDistance > rightDistance) {
                    right = n;
                    sb.append("R");
                } else {
                    if (hand.equals("left")) {
                        left = n;
                        sb.append("L");
                    } else {
                        right = n;
                        sb.append("R");
                    }
                }
            }
        }

        return sb.toString();
    }
}
