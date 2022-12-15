package study;

import java.util.Arrays;

/**
 *  m = 3
 *  40 20 90 1000 bike
 *  1  2  1  3
 *  1  3  22 32
 *     0  1  2  3
 *  0  0  0  0  0
 *  1  40 -1  1  1
 *  2  93 22 -1 43
 *  3  1093 -1 -1 96
 *
 * -1 40 10 90 public
 * 1  3  13 14
 *
 * 1 2 1 1 walk
 * 1 3 x x
 */
class KaKaoMobility_2022_하반기_2차_1 {
    /**
     * 모든 구간을 각 이동수단으로 이동하는 최소 시간을 계산한 후, 가장 작은 시간을 리턴하는 문제이다.
     * 자전거와 대중교통은 중간에 도보를 이용할 수 있다.
     * 자동차는 도보를 이용할 수 없다.
     * 연속적으로 걷는 시간의 제한이 있다.
     * 대중교통을 이용할 수 없는 구간이 있다. 이때, infos 배열의 값은 -1이다.
     *
     * 구간의 수가 최대 20000개이기 때문에 모든 경우의 수를 계산하는 것은 불가능하다고 판단해서 DP를 사용했다.
     * 이 중, 자동차와 도보를 계산하는 경우는 각각 1차원 배열로 계산했다.
     * 자동차는 어짜피 다른 이동수단을 사용할 수가 없고 도보는 연속적으로 걷는 시간의 제한이 있기 때문이다.
     *
     * @param infos <= 20000, 구간별 이동수단의 이동시간, {자동차, 자전거, 대중교통, 도보}
     * @param m <= 100, 연속으로 걸을 수 있는 시간
     * @return 모든 구간을 이동하는데 걸리는 최소 시간
     */
    public int solution(int[][] infos, int m) {
        int carMinTime = calculateCar(infos);
        int walkMinTime = calculateWalk(infos, m);
        int bikeMinTime = calculateBike(infos, m);
        int publicMinTime = calculatePublic(infos, m);

        return Math.min(carMinTime, Math.min(bikeMinTime, Math.min(publicMinTime, walkMinTime)));
    }

    private int calculateBike(int[][] infos, int m) {
        // 구간과 연속 누적 보행 시간의 이차원 배열이고 값으로 최소 시간
        int[][] dp = new int[infos.length + 1][m + 1];
        for (int i = 1; i <= infos.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // 모든 구간 돌면서 최소 시간을 구한다.
        for (int i = 0; i < infos.length; i++) {
            int bike = infos[i][1];
            int walk = infos[i][3];

            // 이전 구간까지의 최소 시간을 가져온다.
            int beforeMin = Integer.MAX_VALUE;
            for (int j = 0; j <= m; j++) {
                beforeMin = Math.min(beforeMin, dp[i][j]);
            }

            // 이전 구간까지의 최소 시간 + 자전거 이동 시간
            // 현재 구간에서 자전거를 탄다면 연속 누적 보행 시간은 0이 된다.
            dp[i + 1][0] = bike + beforeMin;

            if (bike > walk) {
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
