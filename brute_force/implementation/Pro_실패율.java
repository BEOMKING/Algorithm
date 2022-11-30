package brute_force.implementation;

import java.util.Arrays;

/**
 * 스테이지의 실패율을 내림차순한 결과를 리턴하는 문제이다.
 * 데이터 개수가 최대 200000이기 때문에 모든 스테이지에 연산을 반복해도 200000 * 500 = 100000000이기 때문에 모든 연산을 수행해도 시간초과가 발생하지 않는다.
 * 따라서 시간 복잡도는 O(NM)
 *
 * 여기서 시간을 개선할 수 있는 방법이 있는데 도착한 스테이지가 주어졌을 때, 그 이전 스테이지에 모두 연산을 수행하지 않아도 되기 때문이다.
 * 예를 들어 2, 1, 2, 6, 2, 4, 3, 3이 주어졌을 때, 총 인원은 8명이고 1스테이지에 도전중인 사람은 1명이다.
 * 그러면 2스테이지에 도착한 인원은 총 인원에서 1스테이지에 도전중인 사람을 뺀 7명이다.
 * 이 아이디어를 가지고 실패율을 계산하면 시간복잡도를 O(N)으로 줄일 수 있다.
 *
 * @solved 2022.11.29
 */
class Pro_실패율 {
    public int[] solution(int N, int[] stages) {
        Stage[] stageArray = new Stage[N + 2];

        for (int i = 0; i <= N + 1; i++) {
            stageArray[i] = new Stage(i, 0);
        }

        for (int now : stages) {
            stageArray[now].challenger++;
        }

        int num = stages.length;

        for (int i = 1; i <= N; i++) {
            if (num != 0) {
                stageArray[i].failureRate = (double) stageArray[i].challenger / num;
                num -= stageArray[i].challenger;
            } else {
                stageArray[i].failureRate = 0;
            }
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
        int challenger;
        double failureRate;

        public Stage(int index, int challenger) {
            this.index = index;
            this.challenger = challenger;
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
