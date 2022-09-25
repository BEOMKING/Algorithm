package 완전탐색.DFS;

class Pro_미로탈출 {
    int[] dy = {1, 0, 0, -1};
    int[] dx = {0, -1, 1, 0};
    String[] commands = {"d", "l", "r", "u"};
    boolean[][][][] visited;
    boolean isFinish;
    String answer;

    /**
     *
     * @param n 미로의 세로 길이
     * @param m 미로의 가로 길이
     * @param x 현재 위치의 y 좌표
     * @param y 현재 위치의 x 좌표
     * @param r 탈출 지점의 y 좌표
     * @param c 탈출 지점의 x 좌표
     * @param k 이동해야 할 횟수
     * @return 이동 경로
     */
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        isFinish = false;
        answer = "impossible";
        visited = new boolean[n + 1][m + 1][k + 1]['z' - 'a' + 1];

        dfs(x, y, r, c, k, 0, "");

        return answer;
    }

    private void dfs(int y, int x, int r, int c, int k, int count, String dist) {
        if (isFinish) {
            return;
        }

        if (count == k) {
            if (y == r && x == c) {
                answer = dist;
                isFinish = true;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 1 || nx < 1 || ny >= visited.length || nx >= visited[0].length) {
                continue;
            }

            if (visited[ny][nx][count + 1][commands[i].charAt(0) - 'a']) {
                continue;
            }

            visited[ny][nx][count + 1][commands[i].charAt(0) - 'a'] = true;
            dfs(ny, nx, r, c, k, count + 1, dist + commands[i]);
        }
    }

    public static void main(String[] args) {
        Pro_미로탈출 solution = new Pro_미로탈출();
        System.out.println(solution.solution(3, 4, 2, 3, 3, 1, 5));
        System.out.println(solution.solution(2, 2, 1, 1, 2, 2, 2));
        System.out.println(solution.solution(3, 3, 1, 2, 3, 3, 4));
    }
}
