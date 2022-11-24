package brute_force.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 옷을 입는 경우의 수를 모두 구하는 문제이다.
 * 각 옷의 종류별로 옷을 입는 경우의 수를 구하고, 그것을 모두 곱하면 된다.
 * 다만, 특정 종류의 옷을 입지 않는 경우도 있기 때문에, 각 옷의 종류별로 옷을 입는 경우의 수에 1을 더해준다.
 * 그리고 모든 옷을 입지 않는 경우는 없기 때문에, 모든 옷의 종류별로 옷을 입는 경우의 수에 1을 빼준다.
 */
public class BOJ_9375_패션왕신혜빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            Map<String, Integer> kindOfClothes = new HashMap<>();
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                sb.append(0).append('\n');
                continue;
            }

            for (int i = 0; i < n; i++) {
                String kind = br.readLine().split(" ")[1];

                kindOfClothes.put(kind, kindOfClothes.getOrDefault(kind, 0) + 1);
            }

            int mul = 1;

            for (int value : kindOfClothes.values()) {
                mul *= (value + 1);
            }

            sb.append(mul - 1).append("\n");
        }

        System.out.print(sb);
    }
}