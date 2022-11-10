package graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16959_체스판여행1 {
    private static final int KNIGHT = 0;
    private static final int BISHOP = 1;
    private static final int ROOK = 2;
    static int[][] chessBoard;
    static int[] knightY = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] knightX = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] bishopY = {1, 1, -1, -1};
    static int[] bishopX = {1, -1, 1, -1};
    static int[] rookY = {1, -1, 0, 0};
    static int[] rookX = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        chessBoard = new int[n][n];
        Queue<ChessPiece> queue = new LinkedList<>();
        int answer = Integer.MAX_VALUE;
        boolean[][][][] visited = new boolean[n][n][n * n + 2][3];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int now = Integer.parseInt(line[j]);
                chessBoard[i][j] = now;
                if (now == 1) {
                    queue.add(new ChessPiece(i, j, 0, 2, KNIGHT));
                    queue.add(new ChessPiece(i, j, 0, 2, BISHOP));
                    queue.add(new ChessPiece(i, j, 0, 2, ROOK));
                    visited[i][j][2][KNIGHT] = true;
                    visited[i][j][2][BISHOP] = true;
                    visited[i][j][2][ROOK] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            ChessPiece now = queue.poll();
            int y = now.y;
            int x = now.x;
            int time = now.time;
            int target = now.target;
            int type = now.type;

            if (target == n * n + 1) {
                answer = Math.min(answer, time);
                continue;
            }

            for (int i = 0; i < 3; i++) {
                if (i == type) continue;
                if (visited[y][x][target][i]) continue;
                visited[y][x][target][i] = true;
                queue.add(new ChessPiece(y, x, time + 1, target, i));
            }

            if (now.type == KNIGHT) {
                for (int i = 0; i < 8; i++) {
                    int nextY = y + knightY[i];
                    int nextX = x + knightX[i];
                    if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= n) continue;
                    if (visited[nextY][nextX][target][KNIGHT]) continue;
                    visited[nextY][nextX][target][KNIGHT] = true;

                    if (chessBoard[nextY][nextX] == target) {
                        queue.add(new ChessPiece(nextY, nextX, time + 1, target + 1, KNIGHT));
                    } else {
                        queue.add(new ChessPiece(nextY, nextX, time + 1, target, KNIGHT));
                    }
                }
            } else if (type == BISHOP) {
                for (int i = 0; i < 4; i++) {
                    int nextY = y + bishopY[i];
                    int nextX = x + bishopX[i];

                    while (nextY >= 0 && nextY < n && nextX >= 0 && nextX < n) {
                        if (visited[nextY][nextX][target][BISHOP]) {
                            nextY += bishopY[i];
                            nextX += bishopX[i];
                            continue;
                        }

                        visited[nextY][nextX][target][BISHOP] = true;

                        if (chessBoard[nextY][nextX] == target) {
                            queue.add(new ChessPiece(nextY, nextX, time + 1, target + 1, BISHOP));
                        } else {
                            queue.add(new ChessPiece(nextY, nextX, time + 1, target, BISHOP));
                        }
                        nextY += bishopY[i];
                        nextX += bishopX[i];
                    }
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    int nextY = y + rookY[i];
                    int nextX = x + rookX[i];

                    while (nextY >= 0 && nextY < n && nextX >= 0 && nextX < n) {
                        if (visited[nextY][nextX][target][ROOK]) {
                            nextY += rookY[i];
                            nextX += rookX[i];
                            continue;
                        }

                        visited[nextY][nextX][target][ROOK] = true;
                        if (chessBoard[nextY][nextX] == target) {
                            queue.add(new ChessPiece(nextY, nextX, time + 1, target + 1, ROOK));
                        } else {
                            queue.add(new ChessPiece(nextY, nextX, time + 1, target, ROOK));
                        }
                        nextY += rookY[i];
                        nextX += rookX[i];
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static class ChessPiece {
        int y, x, time, target, type;

        public ChessPiece(int y, int x, int time, int target, int type) {
            this.y = y;
            this.x = x;
            this.time = time;
            this.target = target;
            this.type = type;
        }
    }
}
