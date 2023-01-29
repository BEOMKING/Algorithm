package sort;

import java.util.Arrays;

public class LeetCode_324_wiggleSort2 {
    /**
     * 1 6 1 4 와 같이 좌우측보다 작은 값, 좌우측보다 큰 값이 번갈아서 나오는 정렬을 하라는 문제이다.
     * n이 최대 50000이기 때문에 O(N^2)을 사용해서는 해결할 수 없으며 문제에서는 O(n)의 시간 복잡도와 O(1)의 공간 복잡도를 사용하기를 추천하고 있다.
     *
     * 추천하는 복잡도로 푸는 건 잘 모르겠고 O(NlogN) 시간 복잡도로 풀어봤다.
     * 붙어있는 작은 값과 큰 값의 격차를 줄이는 것이 관건이다.
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        int half = nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1;
        int[] answer = new int[nums.length];

        for(int i = 0; i < half; i++){
            answer[i * 2] = nums[half - i - 1];
        }

        for(int i = 0; i < nums.length / 2; i++){
            answer[i * 2 + 1] = nums[nums.length - i - 1];
        }

        for(int i = 0; i < nums.length; i++){
            nums[i] = answer[i];
        }
    }
}
