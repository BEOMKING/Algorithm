package 구현;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
class Pro_주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> recordByCars = new HashMap<>();
        Map<String, Integer> prefixSumByCars = new TreeMap<>();

        for (String record : records) {
            String[] splits = record.split(" ");
            Integer time = convert(splits[0]);
            String number = splits[1];
            String type = splits[2];

            if (type.equals("IN")) {
                recordByCars.put(number, time);

                if (!prefixSumByCars.containsKey(number)) {
                    prefixSumByCars.put(number, 0);
                }
            }

            if (type.equals("OUT")) {
                Integer diff = time - recordByCars.get(number);
                prefixSumByCars.put(number, prefixSumByCars.get(number) + diff);
                recordByCars.remove(number);
            }
        }

        recordByCars.forEach((key, value) -> {
            Integer diff = convert("23:59") - value;
            prefixSumByCars.put(key, prefixSumByCars.get(key) + diff);
        });

        int[] answer = new int[prefixSumByCars.size()];
        int i = 0;

        for (int value : prefixSumByCars.values()) {
            answer[i] = fees[1];

            if (value > fees[0]) {
                answer[i] += Math.ceil((value - fees[0]) / (double) fees[2]) * fees[3];
            }

            i++;
        }

        return answer;
    }

    Integer convert(String time) {
        String[] splitTime = time.split(":");
        return Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
    }
}
