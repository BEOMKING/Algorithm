package study;

import java.util.Arrays;

// 개선안은 뭐가 있을까?
// 도보만 이용한 경우가 자전거와 도보를 이용한 경우에 포함되어 있기 때문에 굳이 계산할 필요가 없었을 것 같습니다.
class KaKaoMobility_2022_하반기_2차_1 {
    // 이 문제는 여러 교통수단을 이용해서 목적지에 도착하는 최소 시간을 구하는 문제였습니다.
    // 그리고 각 교통수단을 이용할 수 있는 조건이 달랐기 때문에 각 교통수단별로 메서드를 분리해서 구현했습니다.
    // 여기서 자동차를 타는 방법은 자동차만 이용할 수 있었기 때문에 자동차의 시간을 전부 합한 것이 최소 시간이라고 생각했습니다.
    // 도보를 이용하는 방식은 자전거와 대중교통을 이용하는 함께 이용하는 방법과 분리해서 도보만 이용하는 경우를 따로 계산했습니다.
    // 도보를 이용하는 시간을 전부 더해주되 연속적으로 도보를 이용하는 시간이 초과했을 경우에는 불가능한 경우로 처리했습니다.
    public int solution(int[][] infos, int m) {
        int carMinTime = calculateCar(infos);
        int walkMinTime = calculateWalk(infos, m);
        int bikeMinTime = calculateBike(infos, m);
        int publicMinTime = calculatePublic(infos, m);

        return Math.min(carMinTime, Math.min(bikeMinTime, Math.min(publicMinTime, walkMinTime)));
    }
    // 자동차와 도보만 이용하는 경우는 구간의 개수만큼만 연산을 수행하면 되었기 때문에 시간적인 문제가 없었습니다.
    // 하지만 자전거와 대중교통을 이용하는 경우는 도보를 함께 이용하는 경우를 고려해야 했기 때문에 범위를 생각했을 때 시간적인 문제가 있었습니다.
    // 저는 이전 구간에서의 연속도보이용시간별 최소 시간으로 다음 구간의 최소 시간을 구할 수 있다고 생각해 DP를 사용했습니다.
    private int calculateBike(int[][] infos, int m) {
        // 구간행과 연속도보이용시간열로 이루어진 이차원 배열을 생성했습니다.
        int[][] dp = new int[infos.length + 1][m + 1];
        for (int i = 1; i <= infos.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // 모든 구간 돌면서 최소 시간을 구하는 로직을 수행했습니다.
        for (int i = 0; i < infos.length; i++) {
            int bike = infos[i][1];
            int walk = infos[i][3];
            // 이전 구간의 최소 시간을 구했습니다.
            // 왜냐면 현재 구간의 연속도보시간이 0인 경우는 이전 구간의 연속도보시간이 얼마던지 상관없이 현재 구간에서 자전거를 타는 경우이기 때문입니다.
            int beforeMin = Integer.MAX_VALUE;
            for (int j = 0; j <= m; j++) {
                beforeMin = Math.min(beforeMin, dp[i][j]);
            }
            // 이전 구간까지의 최소 시간 + 자전거 이동 시간
            // 이것을 이용해 현재 구간의 연속도보시간이 0인 경우의 최소 시간을 구했습니다.
            dp[i + 1][0] = bike + beforeMin;
            // 그 이후에 자전거 시간이 도보시간보다 작거나 같다면 이미 위에서 로직을 수행한 것이기 때문에 넘어가고 아니라면 로직을 수행했습니다.
            if (bike > walk) {
                // 이전 구간의 연속도보시간과 현재 구간의 도보시간을 더한 값이 m보다 작거나 같다면 로직을 수행했습니다.
                for (int j = walk; j <= m; j++) {
                    // 현재 도보시간을 뺀 이전 구간이 가능한 상태였으면 현재 구간의 최소 시간을 구했습니다.
                    if (dp[i][j - walk] != Integer.MAX_VALUE) {
                        dp[i + 1][j] = dp[i][j - walk] + walk;
                    }
                }
            }
        }
        // 따라서 시간 복잡도는 구간의 길이와 연속도보이용시간의 길이에 따라 O(nm)이 됩니다.
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= m; i++) {
            min = Math.min(min, dp[infos.length][i]);
        }

        return min;
    }
    // 대중교통의 경우 자전거와 거의 동일하게 구현했습니다.
    private int calculatePublic(int[][] infos, int m) {
        int[][] dp = new int[infos.length + 1][m + 1];
        for (int i = 1; i <= infos.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < infos.length; i++) {
            int pub = infos[i][2];
            int walk = infos[i][3];

            int beforeMin = Integer.MAX_VALUE;
            for (int j = 0; j <= m; j++) {
                beforeMin = Math.min(beforeMin, dp[i][j]);
            }

            if (beforeMin == Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            // 다만 다른 점은 대중교통의 경우 현재 구간에서 대중교통을 이용하지 않는 경우가 있기 때문에 이를 고려했습니다.
            if (pub != -1) {
                dp[i + 1][0] = beforeMin + pub;
            }

            if (pub == -1 || (pub != -1 && pub > walk)) {
                for (int j = walk; j <= m; j++) {
                    if (dp[i][j - walk] != Integer.MAX_VALUE) {
                        dp[i + 1][j] = dp[i][j - walk] + walk;
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= m; i++) {
            min = Math.min(min, dp[infos.length][i]);
        }

        return min;
    }

    private int calculateCar(int[][] infos) {
        int carMinTime = 0;

        for (int i = 0; i < infos.length; i++) {
            carMinTime += infos[i][0];
        }

        return carMinTime;
    }

    private int calculateWalk(int[][] infos, int m) {
        int walkMinTime = 0;
        int continuousWalkingTime = 0;

        for (int i = 0; i < infos.length; i++) {
            int walkTime = infos[i][3];

            continuousWalkingTime += walkTime;

            if (continuousWalkingTime <= m) {
                walkMinTime += walkTime;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        return walkMinTime;
    }

    public static void main(String[] args) {
        KaKaoMobility_2022_하반기_2차_1 solution = new KaKaoMobility_2022_하반기_2차_1();
        int[][] infos = {{20, 40, -1, 60}, {50, 20, 40, 30}, {10, 30, 10, 20}, {40, 10, 30, 50}};
        int m1 = 60;
        int[][] infos2 = {{100, 80, 10, 20}, {100, 60, -1, 40}};
        int m2 = 30;
        int[][] infos3 = {{20, 40, -1, 1}, {50, 20, 40, 2}, {10, 90, 10, 1}, {40, 10, 30, 3}};
        int m3 = 3;
        System.out.println(solution.solution(infos3, m3));
    }
}
