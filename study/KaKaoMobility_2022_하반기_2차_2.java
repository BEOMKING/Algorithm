package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class KaKaoMobility_2022_하반기_2차_2 {
    /**
     * 이 문제는 임의의 파킹존 두 지점을 선택해서 올 수 있는 사람들에게 최대 대여해줄 수 있는 차량의 수를 구하는 문제
     *
     * 이 문제에서 해결해야할 부분을
     * 1. 각 파킹존 사이의 거리를 구하는 것
     * 2. 임의의 파킹존 두 지점을 선택하고 해당 파킹존에 올 수 있는 유저들을 구하는 것
     *
     * 각 파킹존 사이의 거리를 구하는 것은 파킹존의 개수가 50개 이하이므로 플로이드 와샬 알고리즘을 사용했다.
     *
     * 그리고 임의의 파킹존 두 지점을 선택한다.
     * 이때, 문제는 두 파킹존에 접근할 수 있는 구역이 겹치는 경우가 있을 수 있다는 것이다.
     * 이를 해결하기 위해 각 파킹존에 접근할 수 있는 구역을 구하고, 두 파킹존에 접근할 수 있는 구역이 겹치는지 확인한다.
     * 겹치지 않는 구역에 대해 우선적으로 인원을 배치하고, 차량이 남는 경우에만 겹치는 구역에서 인원을 배치한다.
     *
     * 이렇게 하면 각 파킹존에 접근할 수 있는 구역이 겹치는 경우에도 최대한 많은 인원을 배치할 수 있다.
     *
     * @param n <= 50
     * @param edges <= n * (n - 1) / 2 <= 1225, {시작 장소, 도착 장소, 거리}
     * @param users <= n, 0 <= users[i] <= ?
     * @param d <= 5000, 유저가 이동할 수 있는 최대 거리
     * @param limit 파킹존에 주차할 수 있는 최대 차량 수
     * @return 최대 대여할 수 있는 차량의 수
     */
    public int solution(int n, int[][] edges, int[] users, int d, int limit) {
        // 각 파킹존 사이의 거리를 구하는 플로이드 와샬 알고리즘
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

        // 기존 풀이
        // 파킹존을 선택할 수 있는 모든 경우의 수를 구한다.
        // 경우의 수에서 각각의 경우에 대해 최대 대여할 수 있는 차량의 수를 구한다.
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

        // 종료 후 풀이
        // 임의의 파킹존 두 지점을 선택
        for (int firstZone = 1; firstZone <= n; firstZone++) {
            for (int secondZone = 1; secondZone <= n; secondZone++) {
                if (firstZone == secondZone) continue;
                // 각 파킹존에 접근할 수 있는 구역를 구한다.
                List<Integer> firstZoneAccess = new ArrayList<>();
                List<Integer> secondZoneAccess = new ArrayList<>();

                for (int i = 1; i <= n; i++) {
                    if (distance[firstZone][i] <= d) {
                        firstZoneAccess.add(i);
                    }
                    if (distance[secondZone][i] <= d) {
                        secondZoneAccess.add(i);
                    }
                }

                // 겹치는 구역을 구한다.
                List<Integer> overlap = new ArrayList<>();
                int size1 = firstZoneAccess.size();
                for (int i = 0; i < size1; i++) {
                    int size2 = secondZoneAccess.size();
                    for (int j = 0; j < size2; j++) {
                        if (firstZoneAccess.get(i) == secondZoneAccess.get(j)) {
                            overlap.add(firstZoneAccess.get(i));
                            // 접근 할 수 있는 구역에서 겹치는 구역을 제거한다.
                            firstZoneAccess.remove(i);
                            secondZoneAccess.remove(j);
                        }
                    }
                }

                // 겹치지 않는 구역에서 우선 주차할 수 있는 차량의 수를 구한다.

                // 겹치지 않는 구역에서 접근할 수 있는 유저의 수를 구한다.
                int notOverlapAccessFirstZone = 0;
                int notOverlapAccessSecondZone = 0;

                for (Integer index : firstZoneAccess) {
                    notOverlapAccessFirstZone += users[index];
                }

                for (Integer index : secondZoneAccess) {
                    notOverlapAccessSecondZone += users[index];
                }

                // 파킹존의 차량 대수와 유저의 수를 비교하여 주차할 수 있는 차량의 수를 구한다.
                int firstZoneParking = Math.min(limit, notOverlapAccessFirstZone);
                int secondZoneParking = Math.min(limit, notOverlapAccessSecondZone);

                // 겹치는 구역에서 접근할 수 있는 유저의 수를 구한다.
                int overlapAccess = 0;

                for (Integer index : overlap) {
                    overlapAccess += users[index];
                }

                // 겹치는 구역에서 주차할 수 있는 차량의 수를 구한다.
                answer = Math.max(answer, firstZoneParking + secondZoneParking + Math.min(limit * 2 - firstZoneParking - secondZoneParking, overlapAccess));
            }
        }

        return answer;
    }
}
