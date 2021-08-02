package 최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10217_KCMTravel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 공항 수
            int M = Integer.parseInt(st.nextToken()); // 지원 비용
            int K = Integer.parseInt(st.nextToken()); // 티켓 정보 수

            int[][] dp = new int[N + 1][M + 1];
            List<Info>[] ticket = new ArrayList[N + 1];
            for (int j = 0; j <= N; j++) {
                ticket[j] = new ArrayList<>();
                Arrays.fill(dp[j], Integer.MAX_VALUE);
            }

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                ticket[u].add(new Info(v, c, d));
            }

            PriorityQueue<Info> pq = new PriorityQueue<>();
            pq.add(new Info(1, 0, 0));
            dp[1][0] = 0;

            while (!pq.isEmpty()){
                Info now = pq.poll();
                if(now.start == N) break;

                for (Info info: ticket[now.start]) {
                    int sumCost = now.cost + info.cost;
                    int sumDist = now.dist + info.dist;

                    if(sumCost > M) continue;

                    if(dp[info.start][sumCost] <= sumDist) continue;

                    for (int j = sumCost; j <= M; j++) {
                        if(dp[info.start][j] > sumDist) dp[info.start][j] = sumDist;
                    }

                    dp[info.start][sumCost] = sumDist;
                    pq.add(new Info(info.start, sumCost, sumDist));
                }
            }

            int result = Integer.MAX_VALUE;
            for (int j = 0; j <= M; j++) {
                result = Math.min(result, dp[N][j]);
            }

            if(result < Integer.MAX_VALUE) sb.append(result);
            else sb.append("Poor KCM");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static class Info implements Comparable<Info>{
        int start, cost, dist;

        public Info(int start, int cost, int dist) {
            this.start = start;
            this.cost = cost;
            this.dist = dist;
        }
        @Override
        public int compareTo(Info o) {
            if(this.dist == o.dist) {
                return this.cost - o.cost;
            }else return this.dist - o.dist;
        }
    }
}
