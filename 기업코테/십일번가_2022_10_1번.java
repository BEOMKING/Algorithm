package 기업코테;

public class 십일번가_2022_10_1번 {
    /**
     * AND 연산이 연속되는 최대 부분 집합의 크기를 구한다
     *
     * @param A 주어진 정수 배열, 크기 1 ~ 100,000, 각 원소의 크기 1 ~ 1,000,000,000
     * @return AND 연산이 연속되는 최대 부분 집합의 크기
     */
    public int solution(int[] A) {
        int[] bit = new int[32];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < 32; j++) {
                bit[j] += (A[i] >> j) & 1;
            }
        }

        int answer = 0;
        for (int i : bit) {
            answer = Math.max(answer, i);
        }

        return answer;
    }
}
