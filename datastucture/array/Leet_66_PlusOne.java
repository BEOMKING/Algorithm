package datastucture.array;

/**
 * 배열의 길이가 100이기 때문에 값을 계산하는 것은 값의 크기가 너무 커진다.
 * 마지막 자리부터 확인하면서 합이 10이 넘어가는 경우와 넘어가지 않는 경우를 나누어서 로직을 수행한다.
 *
 * 합이 10이 넘어가지 않으면 다음 루프를 더 이상 수행할 필요가 없다. 바로 현재 배열을 리턴한다.
 * 루프가 종료되었다는 것은 모든 자리가 9로 채워져 있다는 것이다.
 * 이 경우에는 배열의 길이를 1 늘린 배열을 만들고 맨 앞만 1로 채워서 리턴한다.
 */
class Leet_66_PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }
}
