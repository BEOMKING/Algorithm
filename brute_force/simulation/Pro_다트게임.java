package brute_force.simulation;

class Pro_다트게임 {
    public int solution(String dartResult) {
        int[] points = new int[4];
        int[] sum = new int[4];
        int sequence = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            char now = dartResult.charAt(i);

            if ('0' <= now && now <= '9') {
                sequence++;
                points[sequence] = now - '0';

                if (dartResult.charAt(i + 1) == '0') {
                    i++;
                    points[sequence] = 10;
                }
            }

            if (now == 'S') {
                sum[sequence] = points[sequence];
            }

            if (now == 'D') {
                sum[sequence] = points[sequence] * points[sequence];
            }

            if (now == 'T') {
                sum[sequence] = points[sequence] * points[sequence] * points[sequence];
            }

            if (now == '*') {
                sum[sequence] *= 2;
                sum[sequence - 1] *= 2;
            }

            if (now == '#') {
                sum[sequence] *= -1;
            }
        }

        return sum[1] + sum[2] + sum[3];
    }
}
