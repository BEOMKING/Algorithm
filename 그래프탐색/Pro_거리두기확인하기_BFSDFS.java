package 그래프탐색;

import java.util.LinkedList;
import java.util.Queue;

public class Pro_거리두기확인하기_BFSDFS {
    private final int roomSize = 5;

    public int[] solution(String[][] places) {
        int[] answer = new int[roomSize];

        for (int i = 0; i < roomSize; i++) {
            String[] place = places[i];
            if(checkPlace(place)) answer[i] = 1;
        }
        return answer;
    }

    private boolean checkPlace(String[] place) {
        for (int i = 0; i < roomSize; i++) {
            for (int j = 0; j < roomSize; j++) {
                if(place[i].charAt(j) != 'P') continue;
                if(!bfs(i, j, place)) return false;
            }
        }
        return true;
    }

    private boolean bfs(int y, int x, String[] p) {
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(y, x));

        while (!queue.isEmpty()) {
            Location now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if(ny < 0 || ny >= roomSize || nx < 0 || nx >= roomSize || (ny == y && nx == x)) continue;

                int d = Math.abs(ny - y) + Math.abs(nx - x);

                if (p[ny].charAt(nx) == 'P' && d <= 2) return false;
                if (p[ny].charAt(nx) == 'O' && d <= 1) queue.offer(new Location(ny, nx));
            }

        }

        return true;
    }

    public class Location {
        int y, x;

        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
//    private final int[] straightY = {-1, 0, 1, 0};
//    private final int[] straightX = {0, 1, 0, -1};
//    private final int[] diagonalY = {-1, 1, 1, -1};
//    private final int[] diagonalX = {1, 1, -1, -1};

//    public int[] solution(String[][] places) {
//        int[] answer = new int[roomSize];
//        char[][] restroom = new char[roomSize][roomSize];
//        for (int i = 0; i < roomSize; i++) {
//            for (int j = 0; j < roomSize; j++) {
//                restroom[j] = places[i][j].toCharArray();
//            }
//            answer[i] = dfs(restroom);
//        }
//        return answer;
//    }
//
//    private int dfs(char[][] restroom) {
//        for (int i = 0; i < roomSize; i++) {
//            for (int j = 0; j < roomSize; j++) {
//                if(restroom[i][j] != 'P') continue;
//                if(!(checkDiagonal(i, j, restroom) && checkStraight(i, j, restroom))) {
//                    return 0;
//                }
//            }
//        }
//        return  1;
//    }
//
//    private boolean checkStraight(int i, int j, char[][] restroom) {
//        for (int k = 0; k < 4; k++) {
//            int ny = i + straightY[k];
//            int nx = j + straightX[k];
//            if(ny < 0 || ny >= roomSize || nx < 0 || nx >= roomSize) continue;
//            if(restroom[ny][nx] == 'P') return false;
//            int nny = i + 2 * straightY[k];
//            int nnx = j + 2 * straightX[k];
//            if(nny < 0 || nny >= roomSize || nnx < 0 || nnx >= roomSize) continue;
//            if(restroom[nny][nnx] == 'P' && restroom[ny][nx] != 'X') return false;
//        }
//
//        return true;
//    }
//
//    private boolean checkDiagonal(int i, int j, char[][] restroom) {
//        for (int k = 0; k < 4; k++) {
//            int ny = i + diagonalY[k];
//            int nx = j + diagonalX[k];
//            if(ny < 0 || ny >= roomSize || nx < 0 || nx >= roomSize) continue;
//            if(restroom[ny][nx] == 'P') {
//                if(restroom[ny][j] != 'X' || restroom[i][nx] != 'X') return false;
//            }
//        }
//        return true;
//    }

}
