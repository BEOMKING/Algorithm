package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
// 큐를 이용하면 쉬운 문제인데 수학적 방법으로 풀어서 오래걸림
public class 백준_1158_요세푸스문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> link = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int result[] = new int[N];

        for (int i = 1; i < N + 1; i++) {
            link.offer(i);
        }
 // q.offer(q.poll()); 큐의 앞 값을 빼서 뒤에 삽입하는 방법
        int index = 0;
        int start = K - 1; // 삭제할 인덱스
        while (!link.isEmpty()) { // 리스트에 값이 없을때까지
            while(start >= link.size()) { // 삭제할 인덱스가 현재 크기보다 크다면
                start = start - link.size(); // 인덱스에서 크기를 빼주어 원형 리스트 유지
            }
            result[index] = link.get(start); // 먼저 삭제되는 순서대로 삽입
            link.remove(start);
            start += (K - 1); // 삭제 지점 값에서 K - 1만큼 이동하면 삭제할 지점
            index += 1;
        }

        System.out.print("<");
        for (int i = 0; i < N; i++) {
            if (i == N - 1) {
                System.out.print(result[i]);
            }else{
                System.out.print(result[i] + ", ");
            }
        }
        System.out.print(">");
    }
}