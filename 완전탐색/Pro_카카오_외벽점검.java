package 완전탐색;

import java.util.Arrays;

public class Pro_카카오_외벽점검 {
    static final int INF = 987654321;
    int N, min;
    int Weak[], Dist[];

    void solve(int cnt, int pos, int visited){ // 사용한 친구수, 친구의 시작점, 방문여부(비트)
        if(cnt > Dist.length) return;
        if(cnt >= min) return;

        for (int i = 0; i < Weak.length; i++) { // 나머지 취약지점을 방문할 수 있는지
            int nextPos = (pos + i) % Weak.length;
            int diff = Weak[nextPos] - Weak[pos]; // 취약지점 간의 거리

            if (nextPos < pos) // ex 10번 출발 1번 도착  13 - 10
                diff += N;

            if (diff > Dist[Dist.length - cnt]) break; //거리가 가장 이동거리가 큰 친구보다 크면
            visited |= 1 << nextPos;
        }

        if(visited == (1 << Weak.length) - 1){
            min = cnt;
            return;
        }

        for (int i = 0; i < Weak.length; i++) {
            if ((visited & (1 << i)) != 0) continue;
            solve(cnt + 1, i, visited);
        }
    }

    public int solution(int n, int[] weak, int[] dist) {
        Arrays.sort(dist);
        N = n;
        Weak = weak;
        Dist = dist;
        min = INF;

        for (int i = 0; i < Weak.length; i++) { // 취약 지점을 변경해가며 완전 탐색
            solve(1, i, 0);
        }

        if(min == INF) return -1;
        return min;
    }
}
