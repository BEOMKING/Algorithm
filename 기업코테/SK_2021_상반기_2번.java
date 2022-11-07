package 기업코테;

import java.io.IOException;

public class SK_2021_상반기_2번 {

    public static void main(String[] args) throws IOException {
        int n = 6;
        solution(n, false);
    }
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static int[][] solution(int n, boolean clockwise) {
        if (clockwise) return forward(n);
        return reverse(n);
    }

    private static int[][] reverse(int n) {
        int temp[][] = new int[n][n];
        rtonado(temp, -1, 0, 0, 1, n, 1, 0);
        rtonado(temp, n - 1, -1, 1, 1, n, 1, 0);
        rtonado(temp, n, n - 1, 2, 1, n, 1, 0);
        rtonado(temp, 0, n, 3, 1, n, 1, 0);
        return temp;
    }

    private static void rtonado(int[][] temp, int y, int x, int direction, int target, int n, int start, int index) {
        if (direction == 3 && x == target - 1) return;
        if (direction == 1 && x == n - target - 2) return;
        if (direction == 0 && y == n - target - 2) return;
        if (direction == 2 && y == target - 1) return;

        for (int i = index; i < n - target; i++) {
            y += dy[direction];
            x += dx[direction];
            temp[y][x] = start++;
        }

        rtonado(temp, y, x, (direction + 1) % 4, ++target, n, start, ++index);
    }

    private static int[][] forward(int n) {
        int temp[][] = new int[n][n];

        return temp;
    }

}

/*
자연수 n과 시계/반시계 방향을 결정하는 boolean 값 clockwise가 주어집니다. 입출력 예 설명의 그림과 같이 소용돌이 모양(clockwise가 참이면 시계방향, 거짓이면 반시계방향)으로 n x n 정수 배열을 채워 return 하도록 solution 함수를 완성해주세요.

제한사항
n은 1 이상 1,000 이하입니다.
입출력 예(파이썬을 제외한 언어)
n	clockwise	result
5	true	[[1,2,3,4,1],[4,5,6,5,2],[3,6,7,6,3],[2,5,6,5,4],[1,4,3,2,1]]
6	false	[[1,5,4,3,2,1],[2,6,8,7,6,5],[3,7,9,9,8,4],[4,8,9,9,7,3],[5,6,7,8,6,2],[1,2,3,4,5,1]]
9	false	[[1,8,7,6,5,4,3,2,1],[2,9,14,13,12,11,10,9,8],[3,10,15,18,17,16,15,14,7],[4,11,16,19,20,19,18,13,6],[5,12,17,20,21,20,17,12,5],[6,13,18,19,20,19,16,11,4],[7,14,15,16,17,18,15,10,3],[8,9,10,11,12,13,14,9,2],[1,2,3,4,5,6,7,8,1]]

입출력 예 설명
입출력 예 #1

clockwise가 참이므로, 소용돌이를 시계방향으로 돌려야 합니다.
다음 그림은 5x5 정사각형을 시계방향 소용돌이 모양으로 채운 모습입니다.
ex1.png
입출력 예 #2

clockwise가 거짓이므로, 소용돌이를 반시계방향으로 돌려야 합니다.
다음 그림은 6x6 정사각형을 반시계방향 소용돌이 모양으로 채운 모습입니다.
ex2.png
입출력 예 #3

clockwise가 거짓이므로, 소용돌이를 반시계방향으로 돌려야 합니다.
다음 그림은 9x9 정사각형을 반시계방향 소용돌이 모양으로 채운 모습입니다.
ex3.png

 */
