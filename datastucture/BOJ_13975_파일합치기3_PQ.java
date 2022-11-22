package datastucture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13975_파일합치기3_PQ {
    static int N;
    static long[] files;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            files = new long[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                files[j] = Integer.parseInt(st.nextToken());
            }
            PriorityQueue<Long> queue = new PriorityQueue<>();
            for (int j = 0; j < files.length; j++) {
                queue.add(files[j]);
            }

            long now;
            long result = 0;
            while (queue.size() >= 2) {
                now = queue.poll() + queue.poll();
                queue.add(now);
                result += now;
            }
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }

}
