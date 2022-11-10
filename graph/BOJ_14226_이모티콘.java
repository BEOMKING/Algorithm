package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class BOJ_14226_이모티콘 {

    public static final int RANGE = 1001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        int[][] time = new int[RANGE][RANGE]; // 이모티콘 수, 클립보드에 저장된 개수
        Queue<Emoticon> q = new LinkedList<>();
        q.add(new Emoticon(1, 0));
        time[1][0] = 1;

        while (!q.isEmpty()) {
            Emoticon now = q.poll();
            int count = now.count;
            int copy = now.copy;
            if (count == S) {
                System.out.println(time[count][copy] - 1);
                break;
            }

            if (time[count][count] == 0) {
                q.add(new Emoticon(count, count));
                time[count][count] = time[count][copy] + 1;
            }

            if (count + copy < RANGE && time[count + copy][copy] == 0) {
                q.add(new Emoticon(count + copy, copy));
                time[count + copy][copy] = time[count][copy] + 1;
            }

            if (count - 1 >= 2 && time[count - 1][copy] == 0) {
                q.add(new Emoticon(count - 1, copy));
                time[count - 1][copy] = time[count][copy] + 1;
            }

        }
    }

    static class Emoticon {
        int count, copy;

        public Emoticon(int count, int copy) {
            this.count = count;
            this.copy = copy;
        }
    }
}
