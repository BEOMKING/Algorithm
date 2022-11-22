package shortest;

import java.util.ArrayList;
import java.util.List;

class Pro_등산코스정하기 {
    /**
     * 출입구에서 산봉우리를 거쳐 돌아오는 경로 중 가장 긴 시간을 intensity 라고 함
     *
     * @param n 지점의 개수
     * @param paths 지점 간의 연결 정보
     * @param gates 출입구
     * @param summits 정상
     * @return 경로들 중에서 가장 작은 intensity 를 가진 경로의 산봉우리와 그 intensity 를 출력
     */
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        List[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList();
        }
        for (int i = 0; i < paths.length; i++) {
            lists[paths[i][0]].add(paths[i][1]);
            lists[paths[i][1]].add(paths[i][0]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Pro_등산코스정하기 solution = new Pro_등산코스정하기();
        int n = 5;
        int[][] paths = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
        int[] gates = {1, 2};
        int[] summits = {5};
        int[] answer = solution.solution(n, paths, gates, summits);
        System.out.println(answer[0] + " " + answer[1]);
    }
}
