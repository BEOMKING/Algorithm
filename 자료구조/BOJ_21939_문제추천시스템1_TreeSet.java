package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_21939_문제추천시스템1_TreeSet {
    static TreeSet<Problem> treeSet;
    static HashMap<Integer, Integer> hashMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        treeSet = new TreeSet<>();
        hashMap = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            treeSet.add(new Problem(num, level));
            hashMap.put(num, level);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if (command.equals("recommend")) {
                System.out.println(recommend(num));
            }
            if (command.equals("solved")) solved(num);
            if (command.equals("add")) {
                int level = Integer.parseInt(st.nextToken());
                add(num, level);
            }

        }

    }

    private static void add(int num, int level) {
        treeSet.add(new Problem(num, level));
        hashMap.put(num, level);
    }

    private static int recommend(int num) {
        if(num == 1) return treeSet.last().num;
        else return treeSet.first().num;
    }

    private static void solved(int num) {
        treeSet.remove(new Problem(num, hashMap.get(num)));
        hashMap.remove(num);
    }

    static class Problem implements Comparable<Problem> {
        int num, level;

        public Problem(int num, int level) {
            this.num = num;
            this.level = level;
        }

        @Override
        public int compareTo(Problem o) {
            if(o.level == this.level) {
                return this.num - o.num;
            }
            else return this.level - o.level;
        }

    }

}
