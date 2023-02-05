package bit;

public class LeetCode_190_ReverseBits {
    /**
     * 비트를 뒤집은 결과를 리턴하는 문제이다.
     * 001001 -> 100100 이 되어야하며 비트의 길이는 32로 고정이다.
     * n의 첫 번째 비트(이후 n을 비트를 우측으로 이동시킨다)를 비트의 길이만큼 이동시켜(점차 감소시킨다) 더해주는 방법을 사용했다.
     * 시간 복잡도 O(1)
     */
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            result += (n & 1) << i;
            n = n >> 1;
        }

        return result;
    }
}
