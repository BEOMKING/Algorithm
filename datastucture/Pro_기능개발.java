package datastucture;

import java.util.ArrayList;

public class Pro_기능개발 {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        int value = 0;
        ArrayList<Integer> answer = new ArrayList<>();

        while(value != progresses.length) {
            int day = 1;
            while (progresses[value] + day * speeds[value] < 100) {
                day += 1;
            }
            for (int i = value; i < progresses.length; i++) {
                progresses[i] += day * speeds[i];
            }

            int count = 0;
            for (int i = value; i < progresses.length; i++) {
                if(progresses[i] < 100){
                    break;
                }
                count += 1;
            }
            answer.add(count);
            value += count;
        }

        return answer;
    }
}
