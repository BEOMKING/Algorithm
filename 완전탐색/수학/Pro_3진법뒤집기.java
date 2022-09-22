package 완전탐색.수학;

import java.util.ArrayList;
import java.util.List;

public class Pro_3진법뒤집기 {
    public int solution(int n) {
        int answer = 0;
        List<Integer> three = new ArrayList<>();

        if(n < 3) return n;
        while (n >= 3) {
            int remainder = n % 3;
            n /= 3;
            three.add(remainder);
            if(n < 3 && n > 0) three.add(n);
        }

        for (int i = 0; i < three.size(); i++) {
            answer += three.get(i) * (Math.pow(3, three.size() - 1 - i));
        }

        return answer;
    }

}
