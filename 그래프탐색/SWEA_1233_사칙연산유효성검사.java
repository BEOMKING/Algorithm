package 그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1233_사칙연산유효성검사 {
    static int N;
    static String node[][];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t = 0; t < 10; t++){
            N = Integer.parseInt(br.readLine());
            node = new String[N + 1][];
            int result = 1;

            for(int n = 1; n < N + 1; n++){ // 완전 이진 트리임으로 자식이 없는 노드들이 부호가 아니라면 유효할 것
                node[n] = br.readLine().split(" ");
                if(node[n].length == 2 && !Character.isDigit(node[n][1].charAt(0))){ // 자식 노드가 없고 인덱스 번호 다음의 값이 숫자가 아니라면 유효하지 않음
                    result = 0;
//                    break; 브레이크를 넣으면 입력개수는 정해져있으므로 다른 테스트 케이스의 입력을 가져와 런타임에러 발생
                }
            }
            System.out.print("#" + (t + 1) + " " + result);
            System.out.println();
        }
    }
}
