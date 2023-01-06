package study;

import java.util.Arrays;

// 만약 파킹존의 크기가 컸다면 어떤 알고리즘을 사용해야 할까요?
// 그러면 다익스트라 알고리즘을 사용했을 것 같습니다.
// 다익스트라 알고리즘은 한 정점에서 다른 모든 정점까지의 최단 경로를 구하는 알고리즘입니다.
// 그러면 이 문제에서는 모든 정점에서 다른 모든 정점까지의 최단 경로를 구해야 하기 때문에
// 모든 정점에서 다익스트라 알고리즘을 실행해야 합니다.
// 그러면 시간 복잡도는 O(N^2 * logN)이 됩니다.
class KaKaoMobility_2022_하반기_2차_2 {
    // 이 문제는 두 개의 임의의 파킹존을 선택하고 올 수 있는 사람들에게 최대한 많이 대여를 시키는 문제입니다.
    // 임의의 파킹존을 선택하는 경우의 수는 파킹존의 수가 그렇게 많지 않기 때문에 모든 경우의 수를 구해도 됩니다.
    // 그러면 유저가 이동할 수 있는 거리의 한계가 있기 때문에 파킹존과의 거리를 구해야 한다고 생각했습니다.
    public int solution(int n, int[][] edges, int[] users, int d, int limit) {
        // 파킹존 사이의 거리를 구하기 위해 플로이드 와샬 알고리즘을 사용했습니다.
        // 그 이유는 파킹존의 크기가 작기 때문에 모든 경우의 수를 구해도 시간이 오래 걸리지 않기 때문입니다.
        int[][] distance = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(distance[i], 100000);
        }

        for (int i = 0; i < edges.length; i++) {
            distance[edges[i][0]][edges[i][1]] = edges[i][2];
            distance[edges[i][1]][edges[i][2]] = edges[i][2];
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);
                }
            }
        }
        // 이후에 로직은 시간이 부족해서 제대로 구현하지 못했습니다.
        // 만약 시간이 더 있었다면 파킹존을 선택하는 경우의 수를 구하고 파킹존에 올 수 있는 사람들을 구해서 차량을 배치하는 로직을 구현했을 것 같습니다.
        // 위에서 구한 거리를 이용해서 파킹존에 올 수 있는 사람들을 구하는데 하나 고려해야할 점이 있습니다.
        // 양쪽 파킹존에 모두 갈 수 있는 사람들이 있는데 이들을 어디에 배치해야 할지 고민이 있었습니다.
        // 그래서 하나의 파킹존에 도착할 수 있는 사람들을 먼저 구해서 차량을 대여시키고
        // 그래도 남는 차량이 있다면 양쪽 파킹존에 도착할 수 있는 사람들에게 차량을 대여시키는 로직을 구현했을 것 같습니다.
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int first = 0;
            for (int j = 1; j <= n; j++) {
                if (distance[i][j] <= d) {
                    first += users[j];
                }
            }

            first = limit > first ? limit - first : limit;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                int second = 0;
                for (int l = 1; l <= n; l++) {
                    if (distance[i][l] <= d) {
                        second += users[l];
                    }
                }
                second = limit > second ? limit - second : limit;

                answer = Math.max(answer, first + second);
            }
        }

        return answer;
    }
}
