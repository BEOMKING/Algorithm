package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_15686_치킨배달 {
    static int N, M, min = Integer.MAX_VALUE;
    static int[][] map;
    static Location[] locations;
    static List<Location> chicken;
    static List<Location> home;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        locations = new Location[M];
        chicken = new ArrayList<>();
        home = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int now = Integer.parseInt(st.nextToken());
                if(now == 2) chicken.add(new Location(i, j));
                if(now == 1) home.add(new Location(i, j));
                map[i][j] = now;
            }
        }

        combination(0, 0);

        System.out.println(min);
    }

    public static void combination(int start, int count) {
        if(count == M) {
            min = Math.min(min, distance());
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            locations[count] = chicken.get(i);
            combination(i + 1, count + 1);
            combination(i + 1, count);
        }
    }

    private static int distance() {
        int result = 0;
        for (int i = 0; i < home.size(); i++) {
            int y = home.get(i).y;
            int x = home.get(i).x;
            result += calculate(y, x);
        }
        return result;
    }

    private static int calculate(int i, int j) {
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < locations.length; k++) {
            int y = locations[k].y;
            int x = locations[k].x;
            min = Math.min(min, Math.abs(i - y) + Math.abs(j - x));
        }
        return min;
    }

    public static class Location {
        int y, x;

        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
