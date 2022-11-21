package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 시간 복잡도 정렬에 수행되는 시간 O(NlogN) + 전체 배열을 순회하는 시간 O(N) = O(NlogN)
 */
public class BOJ_18870_좌표압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];
        String[] inputs = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(inputs[i]);
        }

        int[] sorted = Arrays.copyOf(sequence, n);
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(sorted);
        int rank = 0;

        for (int s : sorted) {
            if (map.containsKey(s)) continue;
            map.put(s, rank++);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(sequence[i])).append(" ");
        }

        System.out.println(sb);
    }
}
