package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {
    static int N, sequence[], sign[], max = -1000000001, min = 1000000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        sequence = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        sign = new int[4];
        for (int i = 0; i < 4; i++) {
            sign[i] = Integer.parseInt(st.nextToken());
        }

        dfs(sequence[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int sum, int count) {
        if(count == N){
            max = Math.max(sum, max);
            min = Math.min(sum, min);
            return;
        }

        for (int j = 0; j < 4; j++) {
            if(sign[j] != 0){
                sign[j]--;

                if(j == 0){
                    dfs(sum + sequence[count], count + 1);
                }else if(j == 1){
                    dfs(sum - sequence[count], count + 1);
                }else if(j == 2){
                    dfs(sum * sequence[count], count + 1);
                }else{
                    dfs(sum / sequence[count], count + 1);
                }

                sign[j]++;
            }
        }
    }
}
