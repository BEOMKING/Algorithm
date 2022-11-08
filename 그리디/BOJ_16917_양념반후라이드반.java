package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 반반치킨 두 마리를 사는 것 == 후라이드, 양념 한 마리씩 사는 것
 * 2 * 반반 < 후1 + 양1 이라면 반반을 사는 것이 이득이다.
 * 다만 정량이 아닌 최소 값만 넘으면 되기 때문에 이상을 사도 된다.
 * 이러면 경우의 수는 3가지이다.
 * 1. 반반이 너무 싸서 반반으로만 모두 사는 경우
 * 2. 반반으로 교집합만큼 사고 나머지를 각각 사는 경우
 * 3. 반반이 비싸서 각각 사는게 나은 경우
 */
public class BOJ_16917_양념반후라이드반 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int 양념 = Integer.parseInt(inputs[0]);
        int 후라이드 = Integer.parseInt(inputs[1]);
        int 반반 = Integer.parseInt(inputs[2]);
        int 최소양념 = Integer.parseInt(inputs[3]);
        int 최소후라이드 = Integer.parseInt(inputs[4]);

        int case1 = Math.max(최소양념, 최소후라이드) * 2 * 반반;
        int min = Math.min(최소양념, 최소후라이드);
        int case2 = min * 2 * 반반 + (최소양념 - min) * 양념 + (최소후라이드 - min) * 후라이드;
        int case3 = 양념 * 최소양념 + 후라이드 * 최소후라이드;

        System.out.println(Math.min(Math.min(case1, case2), case3));
    }
}
