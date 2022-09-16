package 완전탐색;

import java.util.Scanner;

public class SWEA_1210_Ladder1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TestCase = 10; // 테스트 케이스 10개 고정
        int answer[] = new int[TestCase]; // 정답 저장

        for(int i = 0; i < TestCase; i++){
            int x = 0, y = 0; // 목적지 정보 저장
            int NowCase = sc.nextInt();
            int ladder[][] = new int[100][100];
            for(int j = 0; j < 100; j++){
                for(int k = 0; k < 100; k++){
                    ladder[j][k] = sc.nextInt();
                    if(ladder[j][k] == 2){ // 목적지 정보
                        x = j;
                        y = k;
                    }
                }
            }
            while(x > 0){ // 출발 x 좌표에 도착하면 정지
                if(y - 1 >= 0 && ladder[x][y - 1] == 1){ // 현재 위치의 왼쪽이 사다리라면
                    y -= 1; // 위치 이동
                    ladder[x][y] = 0; // 현재 위치 기록 제거(0으로 초기화 시키지 않으면 다음 반복에서 다시 제자리로 돌아가서 무한루프 발생)
                }
                else if(y + 1 < 100 && ladder[x][y + 1] == 1){ // 현재 위치의 오른쪽이 사다리라면
                    y += 1;
                    ladder[x][y] = 0;
                }
                else{ // 그것도 아니라면 위쪽으로
                    x -= 1;
                    ladder[x][y] = 0;
                }
            }
            answer[i] = y;
        }
        for(int m = 0; m < answer.length; m++){
            System.out.println("#" + (m + 1) + " " + answer[m]);
        }
    }
}
