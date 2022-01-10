package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14575_뒤풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = strToInt(st.nextToken());
        int T = strToInt(st.nextToken());

        Capacity[] capacities = new Capacity[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            capacities[i] = new Capacity(strToInt(st.nextToken()), strToInt(st.nextToken()));
        }

        System.out.println(binarySearch(capacities, T));

    }

    private static int binarySearch(Capacity[] capacities, int T) {
        int S = Integer.MAX_VALUE;
        int start = 1, mid, end = T;
        while (start <= end) {
            mid = (start + end) / 2;
            Check check = checking(mid, capacities);

            if(check.result && check.minSum <= T && check.maxSum >= T) {
                end = mid - 1;
                S = Math.min(mid, S);
            } else {
                start = mid + 1;
            }

        }

        return answer(S);
    }

    private static int answer(int s) {
        if(s == Integer.MAX_VALUE) return -1;
        return s;
    }

    private static Check checking(int mid, Capacity[] capacities) {
        int minSum = 0;
        int maxSum = 0;

        for (int i = 0; i < capacities.length; i++) {
            Capacity capacity = capacities[i];
            int good = capacity.good;
            int bad = capacity.bad;
            if(mid < good) {
                return new Check(false, minSum, maxSum);
            }
            maxSum += Math.min(bad, mid);
            minSum += good;
        }

        return new Check(true, minSum, maxSum);
    }

    private static int strToInt(String str) {
        return Integer.parseInt(str);
    }

    static class Check {
        boolean result;
        int minSum, maxSum;

        public Check(boolean result, int minSum, int maxSum) {
            this.result = result;
            this.minSum = minSum;
            this.maxSum = maxSum;
        }
    }

    static class Capacity {
        int good, bad;

        public Capacity(int good, int bad) {
            this.good = good;
            this.bad = bad;
        }
    }

}
