package 기업코테;

class 십일번가_2022_10_2번 {
    /**
     *
     * @param N 채울수 있는 최대 빈 잔
     * @param K 채워야할 물의 양
     * @return 모든 물을 채울 수 있는 최소한의 잔의 수
     */
    public int solution(int N, int K) {
        int answer = 0;

        for (int i = N; i >= 1; i--) {
            if (K == 0) {
                break;
            }

            if (K - i >= 0) {
                K -= i;
                answer++;
            }
        }

        return K != 0 ? -1 : answer;
    }
}
