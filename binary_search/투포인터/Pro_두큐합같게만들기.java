package binary_search.투포인터;

class Pro_두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;

        for (int i : queue1) {
            sum1 += i;
        }
        for (int i : queue2) {
            sum2 += i;
        }

        int length = queue1.length;
        int index1 = 0;
        int index2 = length;

        while (sum1 != sum2) {
            answer++;

            if (index1 >= length * 2 || index2 >= length * 2) {
                return -1;
            }

            int plus = 0;
            if (sum1 > sum2) {
                if (index1 >= length) {
                    plus = queue2[index1 % length];
                } else {
                    plus = queue1[index1];
                }
                sum2 += plus;
                sum1 -= plus;
                index1++;
            } else {
                sum2 -= queue2[index2 % length];
                sum1 += queue2[index2 % length];
                index2++;
            }
        }

        return answer;
    }
}
