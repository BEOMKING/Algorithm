package 완전탐색.구현;

import java.util.Arrays;

class Pro_셔틀버스 {
    /**
     * @param n 셔틀 운행 횟수 0 ＜ n ≦ 10
     * @param t 셔틀 운행 간격 0 ＜ t ≦ 60
     * @param m 한 셔틀에 탈 수 있는 최대 크루 수 0 ＜ m ≦ 45
     * @param timetable 크루가 대기열에 도착하는 시각을 모은 배열 timetable은 최소 길이 1이고 최대 길이 2000인 배열로, 하루 동안 크루가 대기열에 도착하는 시각이 HH:MM 형식으로 이루어져 있다.
     * @return 콘이 셔틀을 타고 사무실로 갈 수 있는 도착 시각 중 제일 늦은 시각
     */
    public static String solution(int n, int t, int m, String[] timetable) {
        int[] shuttle = new int[n];
        for (int i = 0; i < n; i++) {
            shuttle[i] = 540 + i * t;
        }
        int[] crew = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            crew[i] = toMinutes(timetable[i]);
        }
        Arrays.sort(crew);
        int crewIndex = 0;
        boolean remain = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (crewIndex < crew.length && shuttle[i] >= crew[crewIndex]) {
                    crewIndex++;
                } else if (i == n - 1){
                    remain = true;
                    break;
                }
            }
        }

        if (remain) {
            return toTime(shuttle[n - 1]);
        } else {
            return toTime(crew[crewIndex - 1] - 1);
        }
    }

    private static String toTime(final int i) {
        return String.format("%02d:%02d", i / 60, i % 60);
    }

    private static int toMinutes(final String s) {
        return Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));
    }

    public static void main(String[] args) {
        if ("09:00".equals(solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"}))) {
            System.out.println("Test 1 passed");
        }
        String solution = solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"});
        System.out.println(solution);
        if ("09:09".equals(solution)) {
            System.out.println("Test 2 passed");
        }
        if ("08:59".equals(solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"}))) {
            System.out.println("Test 3 passed");
        }
        if ("00:00".equals(solution(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"}))) {
            System.out.println("Test 4 passed");
        }
        if ("09:00".equals(solution(1, 1, 1, new String[]{"23:59"}))) {
            System.out.println("Test 5 passed");
        }
        if ("18:00".equals(solution(10, 60, 45, new String[]{"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}))) {
            System.out.println("Test 6 passed");
        }
    }
}
