package 구현.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_4803_트리 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int num = 0; // 반복 순서

        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) break; // 종료 조건

            num++;
            parents = new int[n + 1];
            make(parents);
            HashSet<Integer> hashSet = new HashSet<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                union(x, y);
            }

            for (int i = 1; i <= n; i++) if(find(i) != 0) hashSet.add(parents[i]);
            int cnt = hashSet.size();

            if(cnt > 1) sb.append("Case " + num + ": A forest of " + cnt + " trees.");
            else if(cnt == 1) sb.append("Case " + num + ": There is one tree.");
            else sb.append("Case " + num + ": No trees.");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
    static void make(int[] parents){
        for (int i = 1; i < parents.length; i++) {
            parents[i] = i;
        }
    }
    static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    static void union(int x, int y){
        int xRoot = find(x);
        int yRoot = find(y);
        if(xRoot == yRoot) {
            parents[yRoot] = 0;
            parents[xRoot] = 0;
        } else if(xRoot < yRoot) parents[yRoot] = xRoot;
        else parents[xRoot] = yRoot;

    }
}
