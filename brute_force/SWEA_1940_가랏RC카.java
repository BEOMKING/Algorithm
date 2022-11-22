package brute_force;

import java.util.Scanner;

public class SWEA_1940_가랏RC카 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        int[] answer = new int[T];

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt(); // 커맨드 수
            int distance = 0;
            int now = 0;

            for(int i = 0; i < N; i++){
                int command = sc.nextInt();

                if(command == 1){
                    int speed = sc.nextInt();
                    now += speed;
                    distance += now;
                }
                else if(command == 2){
                    int speed = sc.nextInt();
                    if(now - speed >= 0){
                        now -= speed;
                        distance += now;
                    }
                    else{
                        now = 0;
                    }
                }
                else{
                    distance += now;
                }
            }
            System.out.println("#" + test_case + " " + distance);
        }

    }
}
