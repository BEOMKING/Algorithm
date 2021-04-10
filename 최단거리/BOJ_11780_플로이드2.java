package 최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_11780_플로이드2 {
    static final int MAX = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int map[][] = new int[n + 1][n + 1];
        int distance[][] = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(map[i], MAX);
            Arrays.fill(distance[i], MAX);
        }
        for (int i = 0; i <= n; i++) map[i][0] = 0;

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            map[start][end] = Math.min(map[start][end], value);
            distance[start][end] = start; // 시작값으로 경로 저장
        }

        for (int i = 1; i <= n; i++) { // 플로이드 와샬
            for (int j = 1; j <= n; j++) {
                if(i == j) continue;
                for (int k = 1; k <= n; k++) {
                    if(i == k || j == k) continue;
                    if(map[j][k] > map[j][i] + map[i][k]) {
                        map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                        distance[j][k] = distance[i][k]; // 최단거리 갱신되면 경로 저장
                    }
                }
            }
        }

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if(i == j || map[i][j] == MAX) map[i][j] = 0;
            }
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(distance[i][j] == MAX) {
                    sb.append("0" + "\n");
                }else{
                    Stack<Integer> stack = new Stack<>();
                    int mid = j;
                    stack.push(mid);
                    while(i != distance[i][mid]){
                        mid = distance[i][mid];
                        stack.push(mid);
                    }
                    stack.push(i);
                    sb.append(stack.size() + " ");
                    while(!stack.isEmpty()){
                        sb.append(stack.pop() + " ");
                    }
                    sb.append("\n");
                }
            }
        }
        System.out.print(sb.toString());
    }
}
