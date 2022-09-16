package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1220_Magnetic {
    static int list[][] = new int[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = 1;

        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            for(int i = 0; i < 100; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++){
                    list[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 1 N 2 S
            int result = 0;
            for(int i = 0; i < 100; i++){
                int now = 0;
                for(int j = 0; j < 100; j++){
                    if(now == 0) {
                        if(list[j][i] == 2){
                            continue;
                        }
                        now = list[j][i];
                        continue;
                    }
                    if(list[j][i] == 2){
                        now = 0;
                        result += 1;
                    }
                }
            }
            System.out.println("#" + (t + 1) + " " + result);
        }
    }
}
