package 구현.문자열;

import java.util.Arrays;

class Pro_실패율 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] narriveUser = new int[N + 2];
        idxfail[] failure = new idxfail[N + 1];
        int Number = stages.length;

        for (int user : stages) narriveUser[user]++;

        failure[0] = new idxfail(0, -1);
        for (int i = 1; i <= N; i++) {
            if(Number != 0) { // 현재 스테이지를 도착한 인원이 있다면
                failure[i] = new idxfail(i, (double) narriveUser[i] / Number);
                Number -= narriveUser[i]; // 현재 실패한 인원은 다음 스테이지에 도착했을 수 없다.
            }
            else failure[i] = new idxfail(i, 0);
        }

        Arrays.sort(failure);

        for (int i = 0; i < N; i++) answer[i] = failure[i].index;

        return answer;
    }
    static class idxfail implements Comparable<idxfail>{
        int index;
        double failure;
        public idxfail(int index, double failure) {
            this.index = index;
            this.failure = failure;
        }
        @Override
        public int compareTo(idxfail o) {
            if(failure > o.failure) return -1;
            else if(failure < o.failure) return 1;
            else return index - o.index;
        }
    }

}