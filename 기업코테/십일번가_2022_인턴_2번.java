package 기업코테;

/**
 * leetcode 1375 bulb switcher III
 */
public class 십일번가_2022_인턴_2번 {

    public int solution(int[] A) {
        int answer = 0;
        int max = -1;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int bulb = A[i];
            count++;
            max = Math.max(max, bulb);
            if (count == max) answer++;
        }

        return answer;
    }

}
