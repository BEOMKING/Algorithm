package 완전탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4574_스도미노쿠 {
    static int[][] sudoku;
    static boolean isFinished;
    static int[] dy = {0, 1};
    static int[] dx = {1, 0};
    static int t = 1;
    static StringBuilder sb = new StringBuilder();
    static boolean[][] domino;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;

        while ((N = Integer.parseInt(br.readLine())) != 0) {
            sudoku = new int[9][9];
            domino = new boolean[10][10];
            isFinished = false;

            for (int i = 0; i < N; i++) {
                dominoSetting(br.readLine().split(" "));
            }
            numberSetting(br.readLine().split(" "));

            dfs(0, 0);
        }

        System.out.println(sb);
    }

    private static void dfs(final int y, final int x) {
        if (isFinished) {
            return;
        }
        if (x == 9) {
            dfs(y + 1, 0);
            return;
        }
        if (y == 9) {
            isFinished = true;
            print(t++);
            return;
        }

        if (sudoku[y][x] != 0) {
            dfs(y, x + 1);
        } else {
            for (int value = 1; value <= 9; value++) {
                if (isPossibleSudoku(y, x, value)) {
                    sudoku[y][x] = value;
                    for (int i = 0; i < 2; i++) {
                        int ny = y + dy[i];
                        int nx = x + dx[i];
                        if (ny < 9 && nx < 9 && sudoku[ny][nx] == 0) {
                            for (int value2 = 1; value2 <= 9; value2++) {
                                if (isPossibleSudoku(ny, nx, value2)) {
                                    if (domino[value][value2] || domino[value2][value]) {
                                        continue;
                                    }
                                    domino[value][value2] = true;
                                    domino[value2][value] = true;
                                    sudoku[ny][nx] = value2;
                                    dfs(y, x + 1);
                                    domino[value][value2] = false;
                                    domino[value2][value] = false;
                                    sudoku[ny][nx] = 0;
                                }
                            }
                        }
                    }
                }
            }
            sudoku[y][x] = 0;
        }
    }

    private static boolean isPossibleSudoku(final int y, final int x, final int value) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[y][i] == value) {
                return false;
            }
            if (sudoku[i][x] == value) {
                return false;
            }
        }

        int startY = (y / 3) * 3;
        int startX = (x / 3) * 3;
        for (int i = startY; i < startY + 3; i++) {
            for (int j = startX; j < startX + 3; j++) {
                if (sudoku[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void numberSetting(final String[] inputs) {
        for (int i = 1; i <= 9; i++) {
            sudoku[inputs[i - 1].charAt(0) - 'A'][inputs[i - 1].charAt(1) - '1'] = i;
        }
    }

    private static void dominoSetting(final String[] inputs) {
        int value1 = Integer.parseInt(inputs[0]);
        int value2 = Integer.parseInt(inputs[2]);
        sudoku[inputs[1].charAt(0) - 'A'][inputs[1].charAt(1) - '1'] = value1;
        sudoku[inputs[3].charAt(0) - 'A'][inputs[3].charAt(1) - '1'] = value2;
        domino[value1][value2] = true;
        domino[value2][value1] = true;
    }

    private static void print(int t) {
        sb.append("Puzzle ").append(t).append("\n");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(sudoku[i][j]);
            }
            sb.append("\n");
        }
    }
}
