package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2477_참외밭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int dir = Integer.parseInt(st.nextToken());
        int first = Integer.parseInt(st.nextToken());

        int before = first;
        int sum = 0;
        int area = 0;

        for(int n = 1; n < 6; n++){
            st = new StringTokenizer(br.readLine());
            dir = Integer.parseInt(st.nextToken());
            int now = Integer.parseInt(st.nextToken());
            area = Math.max(area, now * before);
            sum += now * before;
            before = now;
        }
        sum += first * before;
        area = Math.max(area, first * before);
        System.out.println((sum - 2 * area) * K);
    }
}
