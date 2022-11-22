package brute_force;

import java.util.Arrays;

public class Pro_로또의최고순위와최저순위 {
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int match = 0; int check = 0; int zero = 0;
        for (int i = 0; i < 6; i++) {
            if(lottos[i] == 0) {
                zero++;
                continue;
            }

            for (int j = check; j < 6; j++) {
                if(lottos[i] == win_nums[j]){
                    match++;
                    check = j + 1;
                    break;
                }
            }
        }

        answer[0] = 7 - (match + zero) > 5 ? 6 : 7 - (match + zero);
        answer[1] = 7 - match > 5 ? 6 : 7 - match;

        return answer;
    }
}
