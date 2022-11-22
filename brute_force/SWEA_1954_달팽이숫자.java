package brute_force;

import java.util.Scanner;

public class SWEA_1954_달팽이숫자 {
    static void snail(int x, int y, int direction, int start, int temp[][], int snail[][]){
        if(start == temp.length * temp.length + 1){return;} // 현재 값이 최대값 이상이면 종료
        if(direction % 4 == 1){ // 동쪽 방향
            if(temp[x][y] == 0) { // 현재 위치가 방문한적이 없다면
                temp[x][y] = 1; // 방문 체크
                snail[x][y] = start; // 현재 값 리스트 저장
                start += 1;
            }
            if(y + 1 < snail.length && temp[x][y + 1] != 1){ // 배열의 범위를 넘지 않고 오른쪽 위치에 방문한 적이 없다면
                y += 1;
                snail(x, y, direction, start, temp,  snail);
            }
            else{ // 전진 방향을 남쪽으로 변경
                snail(x, y, direction + 1, start, temp,  snail);
            }

        } else if(direction % 4 == 2){ // 전진 방향 남쪽
            if(temp[x][y] == 0) {
                temp[x][y] = 1;
                snail[x][y] = start;
                start += 1;
            }
            if(x + 1 < snail.length && temp[x + 1][y] != 1){
                x += 1;
                snail(x, y, direction, start, temp,  snail);
            }
            else{
                snail(x, y, direction + 1, start, temp,  snail);
            }
        }else if(direction % 4 == 3){
            if(temp[x][y] == 0) {
                temp[x][y] = 1;
                snail[x][y] = start;
                start += 1;
            }
            if(y - 1 >= 0 && temp[x][y - 1] != 1){
                y -= 1;
                snail(x, y, direction, start, temp,  snail);
            }
            else{
                snail(x, y, direction + 1, start, temp,  snail);
            }
        }else{
            if(temp[x][y] == 0) {
                temp[x][y] = 1;
                snail[x][y] = start;
                start += 1;
            }
            if(x - 1 >= 0 && temp[x - 1][y] != 1){
                x -= 1;
                snail(x, y, direction, start, temp,  snail);
            }
            else{
                snail(x, y, direction + 1, start, temp,  snail);
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++){
            int N = sc.nextInt();
            int snail[][] = new int[N][N];
            int temp[][] = new int[N][N];
            int start = 1;
            int x = 0, y = 0;
            int direction = 1; // 초기 전진 방향 동쪽

            snail(x, y, direction, start, temp, snail);

            System.out.println("#" + (i + 1));
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    System.out.print(snail[j][k]);
                    if(k < N - 1){
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
