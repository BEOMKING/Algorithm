package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1931_회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Conference[] conferences = new Conference[N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            conferences[i] = new Conference(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        int count = 0;
        int endTime = 0;
        Arrays.sort(conferences);

        for (int i = 0; i < N; i++) {
            if (conferences[i].start >= endTime) {
                count++;
                endTime = conferences[i].end;
            }
        }

        System.out.println(count);
    }

    static class Conference implements Comparable<Conference> {
        int start, end;

        public Conference(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Conference o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }

            return this.end - o.end;
        }
    }
}
