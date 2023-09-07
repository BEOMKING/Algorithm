package simulation;

import java.util.*;

public class Pro_개인정보수집유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int expire = ymdToInt(today);
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] t = term.split(" ");
            termMap.put(t[0], Integer.parseInt(t[1]));
        }

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] p = privacies[i].split(" ");
            int now = ymdToInt(p[0]);
            int t = termMap.get(p[1]);

            if (expire >= now + (t * 28)) {
                results.add(i + 1);
            }
        }

        return results.stream().mapToInt(i -> i).toArray();
    }

    private int ymdToInt(final String today) {
        String[] splits = today.split("\\.");
        int year = Integer.parseInt(splits[0]) * 12 * 28;
        int month = Integer.parseInt(splits[1]) * 28;
        int day = Integer.parseInt(splits[2]);
        return year + month + day;
    }
}
