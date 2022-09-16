package 완전탐색;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1289_원재의메모리복구 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int answer[] = new int[T];

        for(int i = 0; i < T; i++){
            String input = sc.next();
            String[] str = input.split(""); // 받은 문자 자르기
            int[] original = Arrays.stream(str).mapToInt(Integer::parseInt).toArray(); // 문자 숫자로 변환
            int[] memory = new int[original.length]; // 현재 값 초기화
            int count = 0; // 변환 횟수

            for(int j = 0; j < memory.length; j++){
                if(original[j] == memory[j]){ // 현재 순서 메모리값 같으면 패스
                    continue;
                }else{
                    count += 1;
                    for(int k = j; k < memory.length; k++){
                        if(original[j] == 1){
                            memory[k] = 1;
                        }else{
                            memory[k] = 0;
                        }
                    }
                }
            }
            answer[i] = count;
        }

        for(int i = 0; i < T; i++){
            System.out.println("#" + (i + 1) + " " + answer[i]);
        }
    }
}
