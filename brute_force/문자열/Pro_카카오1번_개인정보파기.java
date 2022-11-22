package brute_force.문자열;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pro_카카오1번_개인정보파기 {
    Map<String, Integer> termsMap = new HashMap<>();

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answers = new ArrayList<>();

        for (int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            termsMap.put(term[0], Integer.parseInt(term[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split("\\.| ");
            int year = Integer.parseInt(privacy[0]);
            int month = Integer.parseInt(privacy[1]);
            int day = Integer.parseInt(privacy[2]);
            int addMonth = termsMap.get(privacy[3]);

            int nm = month + addMonth;
            year += nm / 12;
            month = nm % 12;
            day -= 1;

            if (day <= 0) {
                month -= 1;
                day = 28;
            }

            if (month <= 0) {
                year -= 1;
                month = 12;
            }

            if (year < Integer.parseInt(today.substring(0, 4))) {
                answers.add(i + 1);
            } else if (year == Integer.parseInt(today.substring(0, 4))) {
                if (month < Integer.parseInt(today.substring(5, 7))) {
                    answers.add(i + 1);
                } else if (month == Integer.parseInt(today.substring(5, 7))) {
                    if (day < Integer.parseInt(today.substring(8, 10))) {
                        answers.add(i + 1);
                    }
                }
            }
        }

        return answers.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Pro_카카오1번_개인정보파기 s = new Pro_카카오1번_개인정보파기();
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        int[] answer = s.solution(today, terms, privacies);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
