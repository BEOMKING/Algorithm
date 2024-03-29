package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_16935_배열돌리기3 {
    static int N;
    static int M;
    static int array[][];

    static void changearray(int num) {
        if (num == 1) { // 상하 반전
            for (int n = 0; n < N / 2; n++) { // 배열의 절반까지만 실행하면 나머지 절반을 바꿀 수 있음
                for (int m = 0; m < M; m++) {
                    int temp = array[n][m];
                    array[n][m] = array[N - 1 - n][m]; // N - 1 :: 행의 마지막 -n :: 행이 증가면서 맞은편 행은 감소
                    array[N - 1 - n][m] = temp;
                }
            }
        } else if (num == 2) { // 좌우 반전
            for (int m = 0; m < M / 2; m++) {
                for (int n = 0; n < N; n++) {
                    int temp = array[n][m];
                    array[n][m] = array[n][M - 1 - m];
                    array[n][M - 1 - m] = temp;
                }
            }
        } else if (num == 3) { // 오른쪽 90도
            int temparray[][] = new int[N][M]; // 임시 배열 생성
            for(int i = 0; i < N; i++){ // 임시 배열에 현재 배열 삽입
                temparray[i] = array[i];
            }
            array = new int[M][N]; // 90도 회전을 할 경우 행과 열이 바뀌기 때문
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    array[m][N - 1 - n] = temparray[n][m]; // 3, 4 -> 4, 2
                }
            }
            int tem = N; // static 변수값도 변경해줘야함
            N = M;
            M = tem;
        }else if (num == 4) { // 왼쪽 90도
            int temparray[][] = new int[N][M];
            for(int i = 0; i < N; i++){
                temparray[i] = array[i];
            }
            array = new int[M][N];
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    array[M - 1 - m][n] = temparray[n][m];
                }
            }
            int tem = N;
            N = M;
            M = tem;
        }else if (num == 5) { // 4개의 부분 배열로 나누고 시계방향으로 이동
            for (int n = 0; n < N / 2; n++) { // 맵의 절반만 이동하면 이동됨
                for (int m = 0; m < M / 2; m++) {
                    int temp = array[n][m];
                    array[n][m] = array[n + N / 2][m];
                    array[n + N / 2][m] = array[n + N / 2][m + M / 2];
                    array[n + N / 2][m + M / 2] = array[n][m + M /2];
                    array[n][m + M /2] = temp;
                }
            }
        }else if (num == 6) {
            for (int n = 0; n < N / 2; n++) {
                for (int m = 0; m < M / 2; m++) {
                    int temp = array[n][m];
                    array[n][m] = array[n][m + M /2];
                    array[n][m + M /2] = array[n + N / 2][m + M / 2];
                    array[n + N / 2][m + M / 2] = array[n + N / 2][m];
                    array[n + N / 2][m] = temp;
                }
            }
        }
    }
    public static void main (String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        array = new int[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                array[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < R; i++){
            changearray(Integer.parseInt(st.nextToken()));
        }

        for (int n = 0; n < array.length; n++) {
            for (int m = 0; m < array[0].length; m++) {
                System.out.print(array[n][m] + " ");
            }
            System.out.println();
        }
    }
}