package brute_force;

import java.util.Scanner;

public class SWEA_2805_농작물수확하기 {
    static int farm[][];
    static int money;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // TC
        int answer[] = new int[T];

        for(int t = 0; t < T; t++){
            int N = sc.nextInt(); // 농장 크기

            farm = new int[N][N];
            money = 0; // 수익

            for(int i = 0; i < N; i++){ // 입력 문자 숫자로 변환
                String value = sc.next();
                for(int j = 0; j < value.length(); j++){
                    farm[i][j] = (value.charAt(j) - '0');
                }
            }
            int start = 0; // 시작점
            for(int i = 0; i < N; i++){
                for(int j = N / 2 - start; j <= N / 2 + start; j++){ // 시작점을 중간점에 두고 시작, 시작점 + 확인 개수를 해서 확인
                    money += farm[i][j];
                }
                if(i < N / 2){ // 행이 중간점에 도달하지 않았다면
                    start += 1;
                }else{
                    start -= 1;
                }
            }
            answer[t] = money;
        }
        for(int i = 0; i < T; i++){
            System.out.print("#" + (i + 1) + " ");
            System.out.println(answer[i]);
        }
    }
}
