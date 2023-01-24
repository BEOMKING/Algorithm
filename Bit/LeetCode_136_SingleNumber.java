package Bit;

public class LeetCode_136_SingleNumber {
    /**
     * 주어진 배열의 원소 중 하나만 존재하는 원소를 찾는 문제이다.
     * 친절하게도 선형 시간 복잡도(O(N))와 상수 공간 복잡도(O(1))를 이용하라고 명시되어있다.
     * 처음에는 계수정렬 방식을 이용해 풀이해 전체 루프를 돌며 카운트하고 개수가 1인 값을 리턴하는 방법을 이용했다.
     * 그러면 O(N), O(M)의 복잡도를 가진다.
     * 더 좋은 방법으론 비트 연산이 있었다. XOR 연산을 이용하여 풀이하는 방법인데 하나를 제외한 모든 값이 두 번 반복되므로
     * XOR 연산을 이용하면 0이 된다. 예를 들어 10011(19)가 두 번 있으면 00000이 된다.
     * 따라서 유일한 값이 마지막에 남게 된다. O(N), O(1) 복잡도를 가질 수 있다.
     */
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
