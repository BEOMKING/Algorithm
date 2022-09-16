package 완전탐색;

import java.util.Scanner;

public class SWEA_1208_Flatten {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int TestCase = 10; // 테스트 케이스 10개 고정
        int answer[] = new int[TestCase]; // 정답 저장

        for(int i = 0; i < TestCase; i++){
            int dump = sc.nextInt();
            int flatten[] = new int[100];
            for(int j = 0; j < 100; j++){
                flatten[j] = sc.nextInt();
            }
            for(int k = 0; k < dump; k++){
                int max = 0;
                int min = 101;
                int maxindex = 0;
                int minindex = 0;
                for(int l = 0; l < 100; l++){
                    if(max < flatten[l]){ //
                        max = flatten[l];
                        maxindex = l;
                    }
                    if(min > flatten[l]){ // 이부분을 else if 처리했더니 tc2에서 문제가 발생
                        min = flatten[l]; // 예를 들어 flatten[0]이 1일때 max에 1을 입력하고 넘어가기 때문에 min에 값을 입력할 수가 없다.
                        minindex = l;
                    }
                }
                if(max == min){
                    break;
                }else{
                    flatten[maxindex] -= 1;
                    flatten[minindex] += 1;
                }
            }
            int max = 0;
            int min = 101;

            for(int m = 0; m < 100; m++){
                if(max < flatten[m]){
                    max = flatten[m];
                }
                else if(min > flatten[m]){
                    min = flatten[m];
                }
            }
            answer[i] = max - min;
        }
        for(int n = 0; n < answer.length; n++){
            System.out.println("#" + (n + 1) + " " + answer[n]);
        }
    }
}
