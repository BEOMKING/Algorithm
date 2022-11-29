package brute_force.구현;

import java.util.Arrays;

/**
 * 스테이지의 실패율을 내림차순한 결과를 리턴하는 문제이다.
 * 데이터 개수가 최대 200000이기 때문에 모든 스테이지에 연산을 반복해도 200000 * 500 = 100000000이기 때문에 시간은 크게 고려하지 않았다.
 * 따라서 시간 복잡도는 O(NM)
 *
 * @solved 2022.11.29
 */
class Pro_실패율 {
    public int[] solution(int N, int[] stages) {
        Stage[] stageArray = new Stage[N + 2];

        for (int i = 0; i <= N + 1; i++) {
            stageArray[i] = new Stage(i, 0, 0);
        }

        for (int now : stages) {
            for (int i = 1; i <= now; i++) {
                stageArray[i].arrival++;
            }

            stageArray[now].challenger++;
        }

        for (int i = 1; i <= N; i++) {
            stageArray[i].calculate();
        }

        stageArray[0].failureRate = -1;
        stageArray[N + 1].failureRate = -1;

        Arrays.sort(stageArray);

        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            answer[i] = stageArray[i].index;
        }

        return answer;
    }

    private class Stage implements Comparable<Stage> {
        int index;
        int arrival;
        int challenger;
        double failureRate;

        public Stage(int index, int arrival, int challenger) {
            this.index = index;
            this.arrival = arrival;
            this.challenger = challenger;
        }

        public void calculate() {
            if (arrival == 0) {
                failureRate = 0;
            } else {
                this.failureRate = (double) challenger / arrival;
            }
        }

        @Override
        public int compareTo(Stage o) {
            if (o.failureRate > this.failureRate) {
                return 1;
            } else if (o.failureRate < this.failureRate) {
                return -1;
            } else {
                return this.index - o.index;
            }
        }
    }
}
