package 완전탐색;

import java.util.Scanner;

public class 소금쟁이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // TC
        int[] answer = new int[T + 1]; // 정답 저장 배열
        for(int i = 1; i < T + 1; i++) {
            int N = sc.nextInt(); // 정사각형 크기
            int Salt = sc.nextInt(); // 소금쟁이
            int alive = 0; // 생존 수

            int [][] pond = new int[N][N]; // 연못

            for(int j = 0; j < Salt; j++) {
                int row = sc.nextInt();
                int column = sc.nextInt();
                int direction = sc.nextInt();

                if(pond[row][column] == 0) {
                    if(direction == 1) { // 방향 상
                        if(row - 3 >= 0 && pond[row - 3][column] == 0) { // 3칸 이동
                            row -= 3;
                            if(row - 2 >= 0 && pond[row - 2][column] == 0) {
                                row -= 2;
                                if(row - 1 >= 0 && pond[row - 1][column] == 0) {
                                    row -= 1;
                                    pond[row][column] = 1; // 소금쟁이 위치 저장
                                }
                                else {
                                    if(row - 1 >= 0) {
                                        pond[row][column] = 0;
                                    }
                                }
                            }
                            else {
                                if(row - 2 >= 0) {
                                    pond[row][column] = 0;
                                }
                            }
                        }
                        else {
                            if(row - 3 >= 0) { // 이동한 곳이 연못 밖이 아닌 소금쟁이들의 충돌일 때
                                pond[row][column] = 0;
                            }
                        }
                    }
                    else if(direction == 2) {
                        if(row + 3 < N && pond[row + 3][column] == 0) {
                            row += 3;
                            if(row + 2 < N && pond[row + 2][column] == 0) {
                                row += 2;
                                if(row + 1 < N && pond[row + 1][column] == 0) {
                                    row += 1;
                                    pond[row][column] = 1;
                                }
                                else {
                                    if(row + 1 < N) {
                                        pond[row][column] = 0;
                                    }
                                }
                            }
                            else {
                                if(row + 2 < N) {
                                    pond[row][column] = 0;
                                }
                            }
                        }
                        else {
                            if(row + 3 < N) {
                                pond[row][column] = 0;
                            }
                        }
                    }
                    else if(direction == 3) {
                        if(column - 3 >= 0 && pond[row][column - 3] == 0) {
                            column -= 3;
                            if(column - 2 >= 0 && pond[row][column - 2] == 0) {
                                column -= 2;
                                if(column - 1 >= 0 && pond[row][column - 1] == 0) {
                                    column -= 1;
                                    pond[row][column] = 1;
                                }
                                else {
                                    if(column - 1 >= 0) {
                                        pond[row][column] = 0;
                                    }
                                }
                            }
                            else {
                                if(column - 2 >= 0) {
                                    pond[row][column] = 0;
                                }
                            }
                        }
                        else {
                            if(column - 3 >= 0) {
                                pond[row][column] = 0;
                            }
                        }
                    }
                    else {
                        if(column + 3 < N && pond[row][column + 3] == 0) {
                            column += 3;
                            if(column + 2 < N && pond[row][column + 2] == 0) {
                                column += 2;
                                if(column + 1 < N && pond[row][column + 1] == 0) {
                                    column += 1;
                                    pond[row][column] = 1;
                                }
                                else {
                                    if(column + 1 < N) {
                                        pond[row][column] = 0;
                                    }
                                }
                            }
                            else {
                                if(column + 2 < N) {
                                    pond[row][column] = 0;
                                }
                            }
                        }
                        else {
                            if(column + 3 < N) {
                                pond[row][column] = 0;
                            }
                        }
                    }
                }
            }
            for(int[] k:pond) { // 연못의 소금쟁이 수 체크
                for(int l:k) {
                    if(l == 1) {
                        alive += 1;
                    }
                }
            }
            answer[i] = alive;
        }
        for(int x = 1; x < T + 1; x++) {
            System.out.println("#" + x + " " + answer[x]);
        }
    }
}