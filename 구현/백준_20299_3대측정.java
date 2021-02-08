package 구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 백준_20299_3대측정 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 신청한 동아리 수
        int S = Integer.parseInt(st.nextToken()); // 팀원 능력치 합 제한
        int M = Integer.parseInt(st.nextToken()); // 팀원 개인 능력치 제한
        int count = 0;

        for(int n = 0; n < N; n++){ // 신청한 팀 순서대로
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st2.nextToken()); // 팀원 1
            int x2 = Integer.parseInt(st2.nextToken()); // 팀원 2
            int x3 = Integer.parseInt(st2.nextToken()); // 팀원 3

            int s = x1 + x2 + x3; // 팀원 능력치 합
            if(s >= S && x1 >= M && x2 >= M && x3 >= M) {
                count += 1;
                sb.append(x1 + " "); // StringBuilder로 답을 저장시키면서 속도의 이득을 가져온다.
                sb.append(x2 + " ");
                sb.append(x3 + " ");
            }
        }
        System.out.println(count); // 통과한 동아리 수
        bw.write(sb.toString()); // BufferedWriter로 한번에 정답을 출력함으로 for문을 사용할 때보다 빠르게 출력할 수 있다.
        bw.flush();
        bw.close();
    }
}

