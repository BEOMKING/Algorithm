package simulation;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_412_FizzBuzz {
    /**
     * 문자열 리스트를 리턴하는데 3으로 나누어떨어지면 "Fizz", 5로 나누어떨어지면 "Buzz"를 넣고
     * 둘 다 떨어지면 "FizzBuzz"를 넣는 리스트를 만드는 문제이다.
     * n이 최대 10000이므로 시간, 공간 복잡도를 신경쓸 필요는 없다.
     */
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                answer.add("FizzBuzz");
            } else if (i % 3 == 0) {
                answer.add("Fizz");
            } else if (i % 5 == 0) {
                answer.add("Buzz");
            } else {
                answer.add("" + i);
            }
        }

        return answer;
    }
}
