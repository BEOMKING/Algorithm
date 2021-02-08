package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1228_암호문1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t = 0; t < 10; t++) {
            ArrayList<Integer> List = new ArrayList<>();
            int N = Integer.parseInt(br.readLine()); // 원본 암호문의 길이
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int n = 0; n < N; n++) { // 원본 암호문 입력
                List.add(Integer.parseInt(st.nextToken()));
            }

            int talk = Integer.parseInt(br.readLine()); // 명령어 개수
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for (int tal = 0; tal < talk; tal++) { // 명령어 개수만큼 반복
                String I = st2.nextToken(); // 처음 입력 문자 제거
                int start = Integer.parseInt(st2.nextToken()); // 시작
                int end = Integer.parseInt(st2.nextToken()); // 끝
                for (int i = start; i < start + end; i++) { // 시작점에서 한칸씩 증가하면서 삽입
                    List.add(i, Integer.parseInt(st2.nextToken()));
                }
            }
            System.out.print("#" + (t + 1) + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(List.get(j) + " ");
            }
            System.out.println();
        }
    }
}
