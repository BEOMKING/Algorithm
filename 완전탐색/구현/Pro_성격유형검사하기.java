package 완전탐색.구현;

import java.util.HashMap;
import java.util.Map;

public class Pro_성격유형검사하기 {
    Map<Character, Integer> score = new HashMap<>();

    public String solution(String[] survey, int[] choices) {
        score.put('R', 0); score.put('T', 0); score.put('C', 0);
        score.put('F', 0); score.put('J', 0); score.put('M', 0);
        score.put('A', 0); score.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            if (choices[i] < 4) {
                score.put(survey[i].charAt(0), score.get(survey[i].charAt(0)) + Math.abs(choices[i] - 4));
            } else {
                score.put(survey[i].charAt(1), score.get(survey[i].charAt(1)) + choices[i] - 4);
            }
        }

        String answer = "";
        answer += score.get('R') < score.get('T') ? "T" : "R";
        answer += score.get('C') < score.get('F') ? "F" : "C";
        answer += score.get('J') < score.get('M') ? "M" : "J";
        answer += score.get('A') < score.get('N') ? "N" : "A";

        return answer;
    }

    public static void main(String[] args) {
        Pro_성격유형검사하기 solution = new Pro_성격유형검사하기();
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println(solution.solution(survey, choices));
    }
}
