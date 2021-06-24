package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21608_상어초등학교 {
    static int N, classroom[][], result, number, like[][];
    static Queue<Location> q;
    static PriorityQueue<Location> q2;
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static boolean condition1, condition2, condition3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        classroom = new int[N + 1][N + 1]; // 교실
        like = new int[(N * N) + 1][4];

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int ns = Integer.parseInt(st.nextToken()); // 현재 학생 번호
            condition1 = false; condition2 = false;
            for (int j = 0; j < 4; j++) { // 좋아하는 학생 번호
                like[ns][j] = Integer.parseInt(st.nextToken());
            }

            if(i == 0){
                q = new LinkedList<>();
                for (int k = 1; k <= N; k++) {
                    for (int j = 1; j <= N; j++) {
                        q.offer(new Location(k, j));
                    }
                }
            }else if(condition1(ns)) continue;
            if(condition2(ns)) continue;
            condition3(ns);
        }

        satisfaction();
        System.out.print(result);
    }
    private static void satisfaction() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int score = 0;
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(ny <= 0 || ny > N || nx <= 0 || nx > N) continue;
                    for (int l = 0; l < 4; l++) {
                        if(like[classroom[i][j]][l] == classroom[ny][nx]) score++;
                    }
                }
                if(score == 1) result += 1;
                if(score == 2) result += 10;
                if(score == 3) result += 100;
                if(score == 4) result += 1000;
            }
        }
    }
    private static boolean condition3(int ns) {
        Location now = q2.poll();
        classroom[now.y][now.x] = ns;
        return true;
    }
    private static boolean condition2(int ns) {
        int max = 0;
        q2 = new PriorityQueue<>();

        while(!q.isEmpty()){
            Location now = q.poll();
            if(classroom[now.y][now.x] != 0) continue; // 현재 자리에 학생이 있는 경우
            int emptynum = 0; // 비어있는 칸이 인접한 경우

            for (int k = 0; k < 4; k++) {
                int ny = now.y + dy[k];
                int nx = now.x + dx[k];
                if(ny <= 0 || ny > N || nx <= 0 || nx > N) continue;
                if(classroom[ny][nx] == 0) emptynum++;
            }

            if(emptynum == max) q2.offer(new Location(now.y, now.x));
            if(max < emptynum) {
                max = emptynum;
                q2.clear();
                q2.offer(new Location(now.y, now.x));
            }
        }
        if(q2.size() > 1) return false; // 조건 2를 만족하는 경우가 1개 초과
        classroom[q2.peek().y][q2.peek().x] = ns;
        return true;
    }
    private static boolean condition1(int ns) {
        q = new LinkedList<>();
        int max = 0; // 좋아하는 학생 수

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(classroom[i][j] != 0) continue; // 비어있지 않은 경우
                int likenum = 0; // 좋아하는 학생이 인접한 경우

                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(ny <= 0 || ny > N || nx <= 0 || nx > N) continue;
                    for (int l = 0; l < 4; l++) {
                        if(like[ns][l] == classroom[ny][nx]) likenum++;
                    }
                }

                if(likenum == max) q.offer(new Location(i, j));
                if(max < likenum) {
                    max = likenum;
                    q.clear();
                    q.offer(new Location(i, j));
                }
            }
        }
        if(q.size() > 1) return false; // 조건 1을 만족하는 경우가 1개 초과
        classroom[q.peek().y][q.peek().x] = ns;
        return true;
    }
    public static class Location implements Comparable<Location>{
        int y, x;
        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
        @Override
        public int compareTo(Location o) {
            if(y - o.y > 0) return 1;
            else if(y == o.y) return x - o.x;
            else return -1;
        }
    }
}
