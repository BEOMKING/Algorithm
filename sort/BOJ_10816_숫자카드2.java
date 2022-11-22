package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 모든 카드를 비교하는 시간 복잡도는 O(N^2)인데 N <= 500,000이므로 시간초과가 난다.
 *
 * 수의 범위가 -10,000,000 ~ 10,000,000이므로 카드의 개수를 저장할 배열의 크기를 20,000,001로 잡으면
 * 공간 복잡도가 대략 20MB * 4 = 80MB가 되므로 충분하다.
 *
 * 배열에 카드의 개수를 카운트해주고 출력하면 시간 복잡도는 O(N)이 된다.
 *
 * 다만 배열 인덱스가 음수일 수 없다는 것을 주의하면 된다.
 */
public class BOJ_10816_숫자카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] given = new int[n];
        String[] givenStr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            given[i] = Integer.parseInt(givenStr[i]);
        }

        int m = Integer.parseInt(br.readLine());
        int[] target = new int[m];
        String[] targetStr = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            target[i] = Integer.parseInt(targetStr[i]);
        }

        int[] count = new int[20000001];
        for (int i = 0; i < n; i++) {
            count[given[i] + 10000000]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(count[target[i] + 10000000]).append(" ");
        }

        System.out.println(sb);
    }
}
