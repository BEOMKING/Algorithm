package brute_force;

import java.util.Arrays;

class Pro_양궁대회 {
    public int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        int max = 0;
        int[] temp = new int[11];

        for (int i = 1; i < (1 << 10); i++) {
            int useArrow = 0;
            int apeach = 0;
            int ryan = 0;

            for (int j = 0; j < 10; j++) {
                if ((i & (1 << j)) > 0) {
                    useArrow += (info[j] + 1);
                    ryan += (10 - j);
                    temp[j] = info[j] + 1;
                } else {
                    if (info[j] != 0) {
                        apeach += (10 - j);
                    }
                    temp[j] = 0;
                }
            }

            temp[10] = n - useArrow;
            if (useArrow > n) continue;

            int diff = ryan - apeach;
            if (max < diff) {
                answer = Arrays.copyOf(temp, temp.length);
                max = diff;
            } else if (max == diff) {
                for (int j = 10; j >= 0; j--) {
                    if (answer[j] < temp[j]) {
                        answer = Arrays.copyOf(temp, temp.length);
                        break;
                    } else if(answer[j] > temp[j]) {
                        break;
                    }
                }
            }
        }

        if (max == 0) {
            return new int[]{-1};
        }
        return answer;
    }
}
