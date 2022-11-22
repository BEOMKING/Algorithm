package binary_search;

import java.util.StringTokenizer;

public class Pro_광고삽입_투포인터_누적합 {

    public String solution(String play_time, String adv_time, String[] logs) {
        StringTokenizer st;
        int[] timeSum = new int[timeToSecond(play_time) + 1];
        for (int i = 0; i < logs.length; i++) {
            st = new StringTokenizer(logs[i], "-");
            int start = timeToSecond(st.nextToken());
            int end = timeToSecond(st.nextToken());
            timeSum[start]++;
            timeSum[end]--;
        }

        for (int i = 1; i <= timeSum.length; i++) {
            timeSum[i] += timeSum[i - 1];
        }

        int adv = timeToSecond(adv_time);
        long prefixSum = 0;
        for (int i = 0; i < adv; i++) {
            prefixSum += timeSum[i];
        }
        long now = prefixSum;
        int start = 0;
        for (int i = adv; i < timeSum.length; i++) {
            now += (timeSum[i] - timeSum[i - adv]);
            if (prefixSum < now) {
                prefixSum = now;
                start = i - adv + 1;
            }
        }

        return secondToTime(start);
    }

    public int timeToSecond(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));
        int second = Integer.parseInt(time.substring(6));
        return hour * 3600 + minute * 60 + second;
    }

    public String secondToTime(int time) {
        String hour = "" + time / 3600;
        String minute = "" + (time % 3600) / 60;
        String second = "" + (time % 3600) % 60;
        return insert(hour) + ":" + insert(minute) + ":" + insert(second);
    }

    public StringBuilder insert(String time) {
        StringBuilder sb = new StringBuilder();
        if (time.length() < 2) {
            sb.append("0");
        }
        sb.append(time);
        return sb;
    }

}
