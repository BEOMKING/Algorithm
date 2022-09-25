package 완전탐색.DP;

class Pro_배달수거 {
    /**
     *
     * @param cap 최대 재활용 택배 상자 용량
     * @param n 방문해야 할 집 수
     * @param deliveries 집들의 배달량
     * @param pickups 집들의 수거량
     * @return 최소 이동 거리
     */
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long[] dp = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + deliveries[i - 1] + pickups[i - 1];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Pro_배달수거 solution = new Pro_배달수거();
        int cap = 2;
        int n = 7;
        int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
        int[] pickups = {0, 2, 0, 1, 0, 2, 0};
        long answer = solution.solution(cap, n, deliveries, pickups);
        if (answer == 30) {
            System.out.println("정답입니다. 제출을 눌러 보세요");
        } else {
            System.out.println("틀렸습니다. 수정하는게 좋겠어요");
        }

        cap = 4;
        n = 5;
        deliveries = new int[]{1, 0, 3, 1, 2};
        pickups = new int[]{0, 3, 0, 4, 0};
        answer = solution.solution(cap, n, deliveries, pickups);
        if (answer == 16) {
            System.out.println("정답입니다. 제출을 눌러 보세요");
        } else {
            System.out.println("틀렸습니다. 수정하는게 좋겠어요");
        }
    }
}
