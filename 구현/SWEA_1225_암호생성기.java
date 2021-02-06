package 구현;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1225_암호생성기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer[][] = new int[10][8];
        Queue<Integer> q = new LinkedList<Integer>();

        for(int t = 0; t < 10; t++) {
            int thisisproblem = sc.nextInt(); // TC가 정해져있는 건줄 알았는데 매번 입력을 받는거였다. 이러니까 입력이 제대로 안되니 이상하게 나오지..

            for (int i = 0; i < 8; i++) {
                q.offer(sc.nextInt());
            }

            int a = 1;
            while (a > 0) {
                for (int i = 1; i < 6; i++) {
                    int now = q.poll();
                    now -= i;
                    if (now <= 0) {
                        a = now;
                        q.offer(0);
                        break;
                    } else {
                        q.offer(now);
                    }
                }
            }

            for (int i = 0; i < 8; i++) {
                answer[t][i] = q.poll();
            }
        }
        for(int i = 0; i < 10; i++){
            System.out.print("#" + (i + 1) + " ");
            for(int j = 0; j < 8; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
