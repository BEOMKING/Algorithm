package 완전탐색;

public class Pro_행렬테두리회전하기 {
    static int[][] map;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        map = new int[rows + 1][columns + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = j + (i - 1) * columns;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotation(queries[i]);
        }

        return answer;
    }

    private int rotation(int[] query) {
        int y1 = query[0]; int x1 = query[1];
        int y2 = query[2]; int x2 = query[3];

        int start = map[y1][x1];
        int direction = 0;
        int min = start;

        int nowY = y1; int nowX = x1;

        while(direction < 4) {
            int ny = nowY + dy[direction];
            int nx = nowX + dx[direction];

            if(ny < y1 || ny > y2 || nx < x1 || nx > x2) {
                direction++;
                continue;
            }

            min = Math.min(min, map[nowY][nowX]);
            map[nowY][nowX] = map[ny][nx];
            nowY = ny; nowX = nx;
        }

        map[nowY][nowX + 1] = start;
        return min;
    }

}
