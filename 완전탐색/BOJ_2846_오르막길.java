package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2846_오르막길 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int road[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        int count = 0;
        int before = road[0];
        for (int i = 1; i < N; i++) {
            if(before < road[i]){
                count += road[i] - before;
            }else{
                result = Math.max(result, count);
                count = 0;
            }
            before = road[i];
        }
        result = Math.max(result, count);
        System.out.print(result);
    }
}
