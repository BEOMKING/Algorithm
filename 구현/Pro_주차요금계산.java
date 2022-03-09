package 구현;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Pro_주차요금계산 {
    public int baseTime, basePrice, unitTime, unitPrice;
    public Map<String, Integer> inParkingLot = new HashMap<>();
    public Map<String, Integer> outParkingLot = new TreeMap<>();

    public int[] solution(int[] fees, String[] records) {
        baseTime = fees[0]; basePrice = fees[1]; unitTime = fees[2]; unitPrice = fees[3];

        for (String record : records) {
            String[] split = record.split(" ");
            String time = split[0], number = split[1], type = split[2];

            if (type.equals("IN")) in(number, timeConverter(time));
            if (type.equals("OUT")) out(number, timeConverter(time));
        }

        for (String number : inParkingLot.keySet()) {
//            outRecord(number, outTime - inParkingLot.get(number));
//            inParkingLot.remove(number);
//            기존 코드 map을 제거하면서 순회하기 때문에 에러
            outRecord(number, 1439 - inParkingLot.get(number));
        }

        int[] answer = new int[outParkingLot.size()];
        int i = 0;
        for (String number : outParkingLot.keySet()) {
            answer[i++] = basePrice + calAdditionalPrice(outParkingLot.get(number));
        }

        return answer;
    }

    public void out(String number, int outTime) {
        outRecord(number, outTime - inParkingLot.get(number));
        inParkingLot.remove(number);
    }

    public void outRecord(String number, int stayTime) {
        if (outParkingLot.containsKey(number)) {
            outParkingLot.put(number, outParkingLot.get(number) + stayTime);
        } else {
            outParkingLot.put(number, stayTime);
        }
    }

    public void in(String number, int inTime) {
        inParkingLot.put(number, inTime);
    }

    public int calAdditionalPrice(int stayTime) {
        if (baseTime >= stayTime) return 0;
        int additionalTime = stayTime - baseTime;
        if (additionalTime % unitTime == 0) {
            return (additionalTime / unitTime) * unitPrice;
        }
        return (additionalTime / unitTime + 1) * unitPrice;
    }

    public int timeConverter(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
    }
}
