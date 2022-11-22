package binary_search;

class Pro_징검다리건너기 {
    public int solution(int[] stones, int k) {
        int min = 0;
        int max = 200000000;
        int answer = 0;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (check(stones, k, mid)) {
                min = mid + 1;
                answer = mid;
            } else {
                max = mid - 1;
            }
        }

        return answer;
    }

    private boolean check(int[] stones, int k, int mid) {
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] - mid < 0) {
                count++;
            } else {
                count = 0;
            }

            if (count >= k) {
                return false;
            }
        }

        return true;
    }
}
