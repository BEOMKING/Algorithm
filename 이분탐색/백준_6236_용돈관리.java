package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_6236_용돈관리 {
    static int money[];
    static int N;
    static int M;
    static int first;
    static int result;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사용 일수
        M = Integer.parseInt(st.nextToken()); // 출금 횟수
        money = new int[N];
        first = 0;
        result = Integer.MAX_VALUE;

        for(int n = 0; n < N; n++){
            money[n] = Integer.parseInt(br.readLine());
            first = Math.max(first, money[n]);
            sum += money[n]; // 중요
        }

        int start = first;
        int end = sum; // 기존 엔드 값을 최소값 * 2를 주었었는데 M이 1일경우 써야하는 금액의 총합이 필요하므로 end값을 합으로 설정해야한다.

        while(start != end) { // 중요 내 풀이에서는 start의 값이 end를 넘지않는다 그러므로 탈출조건을 이런식으로 주어야한다.
            int count = 0;
            int remain = 0;
            int mid = (start + end) / 2;

            for (int i = 0; i < N; i++) {
                if (remain < money[i]) {
                    count += 1;
                    remain = mid;
                }
                remain -= money[i];
            }

            if (count <= M) {
                result = Math.min(result, mid);
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        System.out.print(result);
    }
}
