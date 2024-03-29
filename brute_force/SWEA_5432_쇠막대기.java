package brute_force;

import java.io.IOException;
import java.util.Scanner;

public class SWEA_5432_쇠막대기 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++){
            String input = sc.next();
            String[] array = input.split(""); // 배열에 한 글자씩 저장
            int stick = 0; // 잘릴 수 있는 막대기 개수
            int count = 0; // 분리 된 막대기 개수

            for(int j = 0; j < array.length; j++){ // 마지막 문자는 무조건 ")"이기 때문에 인덱스 오류를 걱정할 필요는 없다.
                if(array[j].equals("(")){ // ==을 사용하면 비교가 되지 않아 equals 사용 , 현재 문자가 "(" 이고
                    if(array[j + 1].equals("(")){ // 다음 문자도 "(" 라면 (현재 문자는 쇠막대기를 의미)
                        stick += 1;
                    }
                    else{
                        count += stick; // 현재 문자가 "("이지만 다음 문자가 ")"이기 때문에 레이저를 의미함, 현재 막대기 값만큼 추가
                    } // 현재 막대기를 자르면 stick * 2 라고 생각할 수도 있지만 다음 레이저부터는 전 막대기들이 이미 포함되어 값을 곱하면 안되기 때문
                }
                else{
                    if(array[j - 1].equals("(")){ // 현재 ")"이고 전 문자가 "("라면 레이저이기 때문에 개수를 추가해야하지만 이미 전 문자 단계에서 처리하기 때문에 스킵
                        continue;
                    }
                    else{ // 현재 ")"이고 전 문자도 ")"라면 쇠막대기의 끝을 의미하기 때문에 stick을 감소시키고 총 개수를 하나 늘린다. (stick * 2를 해결하는 방법)
                        stick -= 1;
                        count += 1;
                    }
                }
            }
            System.out.println("#" + test_case + " " + count);
        }
    }
}
